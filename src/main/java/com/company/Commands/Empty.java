package com.company.Commands;

import com.company.Command;

import java.io.Serializable;

public class Empty extends Command {
    private static final long serialVersionUID = 0x0fff;
    @Override
    public void Execute(boolean IsClient) throws Exception {

    }

    @Override
    public String toString() {
        return "Empty{" +
                "\n\tname=" + getName() + ",\n" +
                "\targs=" + args +
                "\n}";
    }
}
