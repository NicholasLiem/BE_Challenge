package com.Nicholas.commands;

import com.Nicholas.datastructures.FamilyTree;
import com.Nicholas.datastructures.Person;
import com.Nicholas.interfaces.Command;
import com.Nicholas.utils.Utils;

import java.util.List;

public class GetRelationshipCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            CommandManager cm = CommandManager.getInstance();
            String personName = args[0];
            String relationship = args[1];


            FamilyTree familyTree = cm.getFamilyTree();
            Person person = familyTree.searchPersonRecursive(personName);

            if (person != null) {
                switch (relationship.toLowerCase()) {
                    case "son":
                        List<Person> sons = familyTree.getChildrenByGender(person, "Male");
                        Utils.printList(sons);
                        break;
                    case "daughter":
                        List<Person> daughters = familyTree.getChildrenByGender(person, "Female");
                        Utils.printList(daughters);
                        break;
                    case "siblings":
                        List<Person> siblings = familyTree.getSiblings(person);
                        Utils.printList(siblings);
                        break;
                    case "brother-in-law":
                        List<Person> bil = familyTree.getBrotherInLaws(person);
                        Utils.printList(bil);
                        break;
                    case "sister-in-law":
                        List<Person> sil = familyTree.getSisterInLaws(person);
                        Utils.printList(sil);
                        break;
                    case "maternal-aunt":
                        List<Person> maternalAunt = familyTree.getMaternalAunts(person);
                        Utils.printList(maternalAunt);
                        break;
                    case "paternal-aunt":
                        List<Person> paternalAunt = familyTree.getPaternalAunts(person);
                        Utils.printList(paternalAunt);
                        break;
                    case "maternal-uncle":
                        List<Person> maternalUncle = familyTree.getMaternalUncles(person);
                        Utils.printList(maternalUncle);
                        break;
                    case "paternal-uncle":
                        List<Person> paternalUncle = familyTree.getPaternalUncles(person);
                        Utils.printList(paternalUncle);
                        break;
                    default:
                        System.out.println("INVALID_RELATIONSHIP_TYPE");
                        break;
                }
            } else {
                System.out.println("PERSON_NOT_FOUND");
            }

        } else {
            System.out.println("GET_RELATIONSHIP_ARGS_NOT_ACCEPTED");
        }
    }
}
