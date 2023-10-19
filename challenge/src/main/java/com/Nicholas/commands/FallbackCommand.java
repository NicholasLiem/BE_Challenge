package com.Nicholas.commands;

import com.Nicholas.interfaces.Command;

public class FallbackCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.out.println("Your command is not recognized");
    }
}
