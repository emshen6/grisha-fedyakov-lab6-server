package com.company.Commands;


import com.company.Command;
import com.company.Main;
import com.company.Helper.Printer;

public class Head extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        if(Main.tickets.size() != 0) {
            if(IsClient){
                Printer.getInstance().WriteLine(Main.tickets.getFirst().toString());
            }
            else {
                Main.responce.add(Main.tickets.getFirst().toString());
            }
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
