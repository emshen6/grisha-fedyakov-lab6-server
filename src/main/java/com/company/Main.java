package com.company;

import com.company.Helper.Logger;
import com.company.Helper.Parser;
import com.company.Helper.Printer;
import com.company.Managers.CommandManager;
import com.company.Managers.TicketManager;
import com.company.Models.Ticket;

import java.io.PrintStream;
import java.net.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static DatagramPacket recieve = new DatagramPacket(new byte[2048], 2048);
    public static DatagramPacket send;
    public static DatagramSocket server;
    public static String ip = "192.168.5.1";
    public static int port = 1112;



    public static Responce responce = new Responce();
    public static ArrayDeque<Ticket> tickets = new ArrayDeque<>();
    public static LocalDateTime start;
    public static String path = "C:\\file.txt";
    public static Thread client = new Thread(Main::console);
    public static TicketManager manager = new TicketManager();

    public static void console(){
        try {
            while (true) {
                String command = Printer.getInstance().ReadLine();
                boolean is = false;
                for (Command comm : CommandManager.getInstance().GetCommands()){
                    if(command.toLowerCase(Locale.ROOT).startsWith(comm.getName().toLowerCase(Locale.ROOT))){
                        comm.args = new ArrayList<>(Arrays.asList(command.split(",")));
                        comm.args.remove(0);
                        if(command.toLowerCase(Locale.ROOT).equals("add") || command.toLowerCase(Locale.ROOT).equals("remove_lower") || command.toLowerCase(Locale.ROOT).equals("update_by_id")){
                            comm.args.add(Parser.GetTicket(manager.get_ticket()));
                        }
                        else if(command.toLowerCase(Locale.ROOT).equals("remove_all_by_venue")){
                            comm.args.add(Parser.GetVenue(manager.GetVenue()));
                        }
                        is = true;
                        comm.Execute(true);
                    }
                }
                if(!is){
                    Printer.getInstance().WriteLine("такой команды не существует");

                }
                Printer.getInstance().WriteLine("введите команду");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws UnknownHostException, SocketException {
        Printer.Init(System.in, new PrintStream(System.out, true, Charset.forName("windows-1251")));
        start = LocalDateTime.now();
        Logger.Info("старт сервера");


        Logger.Info("добавлены команды");

        client.start();

        if(args.length != 0){
            path = args[0];
            Logger.Info("установлен путь файла");
        }
        else {
            Logger.Info("путь установлен как стандартный");
        }
        Parser.Read(path);



        server = new DatagramSocket(port, InetAddress.getByName(ip));
        Logger.Info("создан сервер");

        try {
            while (true) {
                recieve = new DatagramPacket(new byte[4096], 4096);
                server.receive(recieve);
                Logger.Info("принят клиент с ip: " + recieve.getAddress());
                Command command = Parser.GetCommand(recieve.getData());
                System.out.println(command.toString());
                boolean is = false;
                for (Command command1 : CommandManager.getInstance().GetCommands()) {
                    if (command.getName().toLowerCase(Locale.ROOT).startsWith(command1.getName().toLowerCase(Locale.ROOT))) {
                        command1.args = command.args;
                        command1.Execute(false);
                        is = true;
                        command1.args.clear();
                    }
                }
                if (!is) {
                    responce.add("такой команды не существует");
                }
                responce.add("введите команду");
                Logger.Info("сервер выполнил или отверг комнаду");

                byte[] response = Parser.GetResponce(responce);
                responce.clear();
                send = new DatagramPacket(response, response.length, recieve.getAddress(), port-1);
                server.send(send);
                Logger.Info("отправлен результат");
            }
        }
        catch (Exception e){
            Logger.Error(e.getMessage());
        }
    }
}
