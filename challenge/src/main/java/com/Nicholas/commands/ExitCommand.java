package com.Nicholas.commands;

import com.Nicholas.interfaces.Command;

class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.out.println("Exiting app...");
        System.exit(0);
    }
}