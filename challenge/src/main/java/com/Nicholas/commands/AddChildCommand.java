package com.Nicholas.commands;

import com.Nicholas.datastructures.Person;
import com.Nicholas.interfaces.Command;

public class AddChildCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 3) {
            CommandManager cm = CommandManager.getInstance();
            String parentName = args[0];
            String childName = args[1];
            String childGender = args[2];

            Person parent = cm.getFamilyTree().searchPersonRecursive(parentName);

            Person newChildExist = cm.getFamilyTree().searchPersonRecursive(childName);
            if (newChildExist != null){
                System.out.println("PERSON_ALREADY_IN_FAMILY");
                return;
            }

            if (parent == null) {
                System.out.println("PERSON_NOT_FOUND");

            } else {
                Person child = new Person(childName, childGender);
                parent.addChild(child);
                System.out.println("CHILD_ADDED");
            }
        } else {
            System.out.println("ADD_CHILD_ARGS_NOT_ACCEPTED");
        }
    }
}
