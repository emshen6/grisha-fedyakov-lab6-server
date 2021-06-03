package com.company.Commands;


import com.company.Command;
import com.company.Managers.CommandManager;
import com.company.Main;
import com.company.Helper.Printer;

public class Help extends Command {
    @Override
    public void Execute(boolean IsClient) {
        for (Command a: CommandManager.getInstance().GetCommands()) {
            if(IsClient){
                Printer.getInstance().WriteLine("Команда: " + a.getName());
            }
            else {
                Main.responce.add("Команда: " + a.getName());
            }
        }
    }
}
