package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Helper.Parser;
import com.company.Helper.Printer;

import java.util.ArrayList;

public class Update_by_id extends Command {
    @Override
    public void Execute(boolean IsClient)  {
        if(args.size() > 1) {
            Long id = Long.parseLong(args.get(0));
            ArrayList<Ticket> tickets = new ArrayList<>(Main.tickets);

            Ticket ticket = Parser.SetTicket(args.get(1));
            boolean isb = false;

            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getId().equals(id)) {
                    tickets.set(i, ticket);
                }
            }

            Main.tickets.clear();
            Main.tickets.addAll(tickets);
            if (isb) {
                Main.responce.add("Успешно");
            } else {
                Main.responce.add("ID не найден");
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
