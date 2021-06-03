package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Helper.Printer;

public class Show extends Command {
    @Override
    public void Execute(boolean IsClient) {
        if(Main.tickets.size() != 0) {
            for (Ticket ticket : Main.tickets) {
                if(IsClient){
                    Printer.getInstance().WriteLine(ticket.toString());
                }
                else {
                    Main.responce.add(ticket.toString());
                }
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
