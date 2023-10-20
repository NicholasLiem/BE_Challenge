package com.Nicholas.commands;

import com.Nicholas.datastructures.FamilyTree;
import com.Nicholas.datastructures.Person;
import com.Nicholas.interfaces.Command;

import java.util.HashMap;

public class CommandManager {
    private FamilyTree familyTree;
    private static CommandManager instance;
    private final HashMap<String, Command> commands;
    private final Command fallbackCommand;
    private CommandManager() {
        this.fallbackCommand = new FallbackCommand();
        this.familyTree = initializeFamilyTree();
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

    public FamilyTree initializeFamilyTree(){
        Person kingArthur = new Person("King Arthur", "Male");
        Person queenMargaret = new Person("Queen Margaret", "Female");

        Person bill = new Person("Bill", "Male");
        Person charlie = new Person("Charlie", "Male");
        Person percy = new Person("Percy", "Male");
        Person ronald = new Person("Ronald", "Male");
        Person ginerva = new Person("Ginerva", "Female");

        Person flora = new Person("Flora", "Female");
        Person audrey = new Person("Audrey", "Female");
        Person helen = new Person("Helen", "Female");
        Person harry = new Person("Harry", "Male");

        Person victoire = new Person("Victoire", "Female");
        Person dominique = new Person("Dominique", "Female");
        Person louis = new Person("Louis", "Male");
        Person molly = new Person("Molly", "Female");
        Person lucy = new Person("Lucy", "Female");
        Person rose = new Person("Rose", "Female");
        Person hugo = new Person("Hugo", "Male");
        Person james = new Person("James", "Male");
        Person albus = new Person("Albus", "Male");
        Person lily = new Person("Lily", "Female");

        Person ted = new Person("Ted", "Male");
        Person malfoy = new Person("Malfoy", "Male");
        Person darcy = new Person("Darcy", "Female");
        Person alice = new Person("Alice", "Female");

        Person remus = new Person("Remus", "Male");
        Person draco = new Person("Draco", "Male");
        Person aster = new Person("Aster", "Female");
        Person william = new Person("William", "Male");
        Person ron = new Person("Ron", "Male");
        Person ginny = new Person("Ginny", "Female");


        kingArthur.marry(queenMargaret);
        bill.marry(flora);
        percy.marry(audrey);
        ronald.marry(helen);
        ginerva.marry(harry);
        victoire.marry(ted);
        rose.marry(malfoy);
        james.marry(darcy);
        albus.marry(alice);

        kingArthur.getSpouse().addChild(bill);
        kingArthur.getSpouse().addChild(charlie);
        kingArthur.getSpouse().addChild(percy);
        kingArthur.getSpouse().addChild(ronald);
        kingArthur.getSpouse().addChild(ginerva);

        bill.getSpouse().addChild(victoire);
        bill.getSpouse().addChild(dominique);
        bill.getSpouse().addChild(louis);
        percy.getSpouse().addChild(molly);
        percy.getSpouse().addChild(lucy);

        ronald.getSpouse().addChild(rose);
        ronald.getSpouse().addChild(hugo);

        ginerva.addChild(james);
        ginerva.addChild(albus);
        ginerva.addChild(lily);

        victoire.addChild(remus);
        malfoy.getSpouse().addChild(draco);
        malfoy.getSpouse().addChild(aster);

        james.getSpouse().addChild(william);
        albus.getSpouse().addChild(ron);
        albus.getSpouse().addChild(ginny);

        return new FamilyTree(kingArthur);
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}
