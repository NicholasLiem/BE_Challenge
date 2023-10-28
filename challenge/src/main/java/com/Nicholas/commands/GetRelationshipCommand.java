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
            Person person = familyTree.searchPersonByName(personName);

            if (person != null) {
                List<Person> relatives = null;

                switch (relationship.toLowerCase()) {
                    case "son":
                        relatives = familyTree.getChildrenByGender(person, "Male");
                        break;
                    case "daughter":
                        relatives = familyTree.getChildrenByGender(person, "Female");
                        break;
                    case "siblings":
                        relatives = familyTree.getSiblings(person);
                        break;
                    case "brother-in-law":
                        relatives = familyTree.getBrotherInLaws(person);
                        break;
                    case "sister-in-law":
                        relatives = familyTree.getSisterInLaws(person);
                        break;
                    case "mother-in-law":
                        relatives = familyTree.getMotherInLaws(person);
                        break;
                    case "maternal-aunt":
                        relatives = familyTree.getMaternalAunts(person);
                        break;
                    case "paternal-aunt":
                        relatives = familyTree.getPaternalAunts(person);
                        break;
                    case "maternal-uncle":
                        relatives = familyTree.getMaternalUncles(person);
                        break;
                    case "paternal-uncle":
                        relatives = familyTree.getPaternalUncles(person);
                        break;
                    case "paternal-grandfather":
                        relatives = familyTree.getPaternalGrandFather(person);
                        break;
                    case "grand-children":
                        relatives = familyTree.getGrandChildren(person);
                        break;
                    default:
                        System.out.print("INVALID_RELATIONSHIP_TYPE");
                        break;
                }

                if (relatives != null) {
                    if (relatives.isEmpty()) {
                        System.out.print("NONE");
                    } else {
                        Utils.printList(relatives);
                    }
                }
            } else {
                System.out.print("PERSON_NOT_FOUND");
            }

        } else {
            System.out.print("GET_RELATIONSHIP_ARGS_NOT_ACCEPTED");
        }
    }
}
