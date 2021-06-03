package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Printer;


public class Remove_by_id extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        if(args.size() > 0) {
            if (Main.tickets.removeIf(u -> u.getId() == Long.parseLong(args.get(0)))) {
                if (IsClient) {
                    Printer.getInstance().WriteLine("Успешно");
                } else {
                    Main.responce.add("Успешно");
                }
            } else {
                if (IsClient) {
                    Printer.getInstance().WriteLine("ID не найден");
                } else {
                    Main.responce.add("ID не найден");
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
}
