package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Printer;

public class Info extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        if(IsClient){
            Printer.getInstance().WriteLine("Начало старта: " + Main.start.toString() + "\r\nКол-во элементов: " + Main.tickets.size());
        }
        else {
            Main.responce.add("Начало старта: " + Main.start.toString() + "\r\nКол-во элементов: " + Main.tickets.size());
        }
    }
}
