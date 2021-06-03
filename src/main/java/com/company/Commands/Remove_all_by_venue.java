package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Venue;
import com.company.Helper.Parser;
import com.company.Helper.Printer;

public class Remove_all_by_venue extends Command {
    @Override
    public void Execute(boolean IsClient) throws Exception {
        if(args.size() > 0) {
            Venue v = Parser.SetVenue(args.get(0));
            if (Main.tickets.removeIf(u -> u.getVenue().equals(v))) {
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

}
