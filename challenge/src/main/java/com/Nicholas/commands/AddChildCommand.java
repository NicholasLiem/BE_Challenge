package com.Nicholas.commands;

import com.Nicholas.datastructures.FamilyTree;
import com.Nicholas.datastructures.Person;
import com.Nicholas.interfaces.Command;
import com.Nicholas.utils.Utils;

import java.util.List;

public class AddChildCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 3) {
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

            kingArthur.addChild(bill);
            kingArthur.addChild(charlie);
            kingArthur.addChild(percy);
            kingArthur.addChild(ronald);
            kingArthur.addChild(ginerva);

            bill.addChild(victoire);
            bill.addChild(dominique);
            bill.addChild(louis);
            percy.addChild(molly);
            percy.addChild(lucy);

            ronald.addChild(rose);
            ronald.addChild(hugo);

            ginerva.addChild(james);
            ginerva.addChild(albus);
            ginerva.addChild(lily);

            victoire.addChild(remus);
            malfoy.addChild(draco);
            malfoy.addChild(aster);

            james.addChild(william);
            albus.addChild(ron);
            albus.addChild(ginny);

            FamilyTree ft = new FamilyTree(kingArthur);
//            List<Person> ronaldBrothers = ft.getBrothers(ronald);
//            Utils.printList(ronaldBrothers);
//            List<Person> rosePaternalUncles = ft.getPaternalAunts(rose);
//            Utils.printList(rosePaternalUncles);
//            List<Person> remusMaternalAunt = ft.getMaternalAunts(remus);
//            Utils.printList(remusMaternalAunt);
        } else {
            System.out.println("Add_Child: Too few arguments");
        }
    }
}
