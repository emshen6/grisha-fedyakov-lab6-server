package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Printer;


public class Clear extends Command {
    @Override
    public void Execute(boolean IsClient) throws Exception {
        Main.tickets.clear();
        if(IsClient){
            Printer.getInstance().WriteLine("Удача");
        }
        else {
            Main.responce.add("Удача");
        }
    }
}
