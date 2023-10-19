package com.Nicholas.commands;

import com.Nicholas.interfaces.Command;

import java.util.HashMap;

public class CommandManager {
    private static CommandManager instance;
    private final HashMap<String, Command> commands;
    private final Command fallbackCommand;
    private CommandManager() {
        this.fallbackCommand = new FallbackCommand();

        commands = new HashMap<>();
        registerCommand("ADD_CHILD", new AddChildCommand());
        registerCommand("GET_RELATIONSHIP", new GetRelationshipCommand());
        registerCommand("EXIT", new ExitCommand());
    }

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void registerCommand(String commandName, Command command) {
        this.commands.put(commandName, command);
    }

    public void executeCommand(String commandName, String[] args) {
        if (commands.containsKey(commandName)) {
            Command command = commands.get(commandName);
            command.execute(args);
        } else {
            this.fallbackCommand.execute(args);
        }
    }
}
