package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Helper.Parser;
import com.company.Helper.Printer;

public class Save extends Command {
    @Override
    public void Execute(boolean IsClient) throws Exception {
        if(IsClient) {
            Parser.Save(Main.path);
            Printer.getInstance().WriteLine("успех");
        }
        else{
            Main.responce.add("недостаточно прав на вызов комнады");
        }
    }
}
