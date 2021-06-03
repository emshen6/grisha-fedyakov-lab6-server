package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Helper.Parser;
import com.company.Helper.Printer;

public class Remove_lower extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        try {
            if(args.size() > 0) {
                Ticket ticket = Parser.SetTicket(args.get(0));
                if (Main.tickets.removeIf(u -> u.compareTo(ticket) < 0)) {
                    if (IsClient) {
                        Printer.getInstance().WriteLine("Успешно");
                    } else {
                        Main.responce.add("Успешно");
                    }
                } else {
                    if (IsClient) {
                        Printer.getInstance().WriteLine("Неудачно");
                    } else {
                        Main.responce.add("Неудачно");
                    }
                }
            }
            else{
                if(IsClient){
                    Printer.getInstance().WriteLine("Не все аргументы");
                }
                else {
                    Main.responce.add("Не все аргументы");
                }
            }
        }
        catch (Exception e){
            if(IsClient){
                Printer.getInstance().WriteLine("Ошибка команды");
            }
            else {
                Main.responce.add("Ошибка команды");
            }
        }
    }
}
