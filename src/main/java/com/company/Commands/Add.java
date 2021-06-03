package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Parser;
import com.company.Helper.Printer;

public class Add extends Command {

    @Override
    public void Execute(boolean IsClient)  {
        if(args.size() >= 1) {
            Main.tickets.add(Parser.SetTicket(args.get(0)));
            if(IsClient){
                Printer.getInstance().WriteLine("Успешно");
            }
            else {
                Main.responce.add("Успешно");
            }
        }
        else {
            if(IsClient){
                Printer.getInstance().WriteLine("Неудача");
            }
            else {
                Main.responce.add("Неудача");
            }
        }
    }
}
