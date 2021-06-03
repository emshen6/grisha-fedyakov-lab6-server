package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Printer;

public class Remove_first extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        if(Main.tickets.size() != 0) {
            Main.tickets.removeFirst();
        }
        else{
            if(IsClient){
                Printer.getInstance().WriteLine("Ни одного элемента нет");
            }
            else {
                Main.responce.add("Ни одного элемента нет");
            }
        }
    }
}
