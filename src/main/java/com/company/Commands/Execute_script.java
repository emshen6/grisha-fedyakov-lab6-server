package com.company.Commands;

import com.company.Command;
import com.company.Managers.CommandManager;
import com.company.Main;
import com.company.Helper.Printer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class Execute_script extends Command {
    @Override
    public void Execute(boolean IsClient) throws Exception {
        try{
            if(args.size() > 0) {
                Scanner scanner = new Scanner(new File(args.get(0)));

                while (scanner.hasNext()) {
                    String next = scanner.nextLine().trim();
                    for (Command Commands : CommandManager.getInstance().GetCommands()) {
                        if (next.startsWith(Commands.getName()) || next.startsWith(Commands.getName().toLowerCase(Locale.ROOT))) {
                            Commands.Execute(IsClient);
                        }
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
        catch (FileNotFoundException e){
            if(IsClient){
                Printer.getInstance().WriteLine("Файла нет или доступ к нему запрещен");
            }
            else {
                Main.responce.add("Файла нет или доступ к нему запрещен");
            }
        }
        catch (Exception e){
            if(IsClient){
                Printer.getInstance().WriteLine("Команда работает неверно");
            }
            else {
                Main.responce.add("Команда работает неверно");
            }
        }
    }
}
