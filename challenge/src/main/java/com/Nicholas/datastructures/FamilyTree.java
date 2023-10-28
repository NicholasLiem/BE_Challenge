package com.Nicholas.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private Person person;
    public FamilyTree(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    /**
     * Son and Daughter Relationship
     */
    public List<Person> getChildrenByGender(Person person, String gender) {
        List<Person> children = person.getChildren();
        return children.stream()
                .filter(child -> child.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    /**
     * Sibling Relationship
     */
    public List<Person> getSiblingsByGender(Person person, String gender) {
        List<Person> siblings =  getAllSiblings(person);
        return siblings.stream()
                .filter(child -> child.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    public List<Person> getSiblings(Person person){
        List<Person> siblings = getAllSiblings(person);;
        return siblings;
    }

    private List<Person> getAllSiblings(Person person) {
        List<Person> siblings = new ArrayList<>();
        Person mother = person.getMother();
        if (mother != null) {
            List<Person> children = mother.getChildren();
            siblings.addAll(children);
            siblings.remove(person);
        }
        return siblings;
    }

    /**
     * Brother Relationship
     */
    public List<Person> getBrothers(Person person) {
        return getSiblingsByGender(person, "Male");
    }

    /**
     * Sister Relationship
     */
    public List<Person> getSisters(Person person) {
        return getSiblingsByGender(person, "Female");
    }

    /**
     * Brother-In-Law Relationship
     */
    public List<Person> getBrotherInLaws(Person person) {
        List<Person> brotherInLaws = new ArrayList<>();
        if (person.getSpouse() != null) {
            List<Person> siblings = getSiblings(person.getSpouse());
            for (Person sibling : siblings) {

                if (sibling.getGender().equalsIgnoreCase("Male"))
                {
                    brotherInLaws.add(sibling);
                }

                if (sibling.getSpouse() != null && sibling.getSpouse().getGender().equalsIgnoreCase("Male")) {
                    brotherInLaws.add(sibling.getSpouse());
                }
            }
        } else {
            List<Person> siblings = getSiblings(person);
            for (Person sibling : siblings) {

                if (sibling.getGender().equalsIgnoreCase("Male"))
                {
                    brotherInLaws.add(sibling);
                }

                if (sibling.getSpouse() != null && sibling.getSpouse().getGender().equalsIgnoreCase("Male")) {
                    brotherInLaws.add(sibling.getSpouse());
                }
            }
        }
        return brotherInLaws;
    }


    /**
     * Sister-In-Law Relationship
     */
    public List<Person> getSisterInLaws(Person person) {
        List<Person> sisterInLaws = new ArrayList<>();
        if (person.getSpouse() != null) {
            List<Person> siblings = getSiblings(person.getSpouse());
            for (Person sibling : siblings) {
                if (sibling.getGender().equalsIgnoreCase("Female"))
                {
                    sisterInLaws.add(sibling);
                }
                if (sibling.getSpouse() != null && sibling.getSpouse().getGender().equalsIgnoreCase("Female")) {
                    sisterInLaws.add(sibling.getSpouse());
                }
            }
        } else {
            List<Person> siblings = getSiblings(person);
            for (Person sibling: siblings) {
                if (sibling.getGender().equalsIgnoreCase("Female"))
                {
                    sisterInLaws.add(sibling);
                }
                if (sibling.getSpouse() != null && sibling.getSpouse().getGender().equalsIgnoreCase("Female")) {
                    sisterInLaws.add(sibling.getSpouse());
                }
            }
        }
        return sisterInLaws;
    }


    /**
     * Maternal-Aunt Relationship
     */
    public List<Person> getMaternalAunts(Person person) {
        Person mother = person.getMother();
        return (mother != null) ? getSisters(mother) : new ArrayList<>();
    }

    /**
     * Paternal-Aunt Relationship
     */
    public List<Person> getPaternalAunts(Person person) {
        Person father = person.getFather();
        return (father != null) ? getSisters(father) : new ArrayList<>();
    }

    /**
     * Maternal-Uncle Relationship
     */
    public List<Person> getMaternalUncles(Person person) {
        Person mother = person.getMother();
        return (mother != null) ? getBrothers(mother) : new ArrayList<>();
    }

    /**
     * Paternal-Uncle Relationship
     */
    public List<Person> getPaternalUncles(Person person) {
        Person father = person.getFather();
        return (father != null) ? getBrothers(father) : new ArrayList<>();
    }


    /**
     * Get Paternal GrandFather
     */
    public List<Person> getPaternalGrandFather(Person person) {
        List<Person> grandpa = new ArrayList<>();

        Person father = person.getFather();
        Person paternalGrandpa = father.getFather();

        if (paternalGrandpa != null) {
            grandpa.add(paternalGrandpa);
        }
        return grandpa;
    }

    /**
     * Get GrandChildren
     */
    public List<Person> getGrandChildren(Person person) {
        List<Person> grandchildren = new ArrayList<>();

        List<Person> children = person.getChildren();
        for(Person child : children) {
            List<Person> grandchild = child.getChildren();
            grandchildren.addAll(grandchild);
        }

        return grandchildren;
    }

    /**
     * Get MotherInLaw
     */
    public List<Person> getMotherInLaws(Person person) {
        List<Person> motherInLaws = new ArrayList<>();
        Person spouse = person.getSpouse();
        if (spouse != null) {
            Person motherInLaw = spouse.getMother();
            if (motherInLaw != null) {
                motherInLaws.add(motherInLaw);
            }
        }
        return motherInLaws;
    }

    public Person searchPersonByName(String name) {
        return searchPersonRecursive(this.getPerson(), name);
    }

    private Person searchPersonRecursive(Person currentPerson, String name) {
        if (currentPerson.getName().equalsIgnoreCase(name)) {
            return currentPerson;
        }

        if (currentPerson.getSpouse() != null && currentPerson.getSpouse().getName().equalsIgnoreCase(name)) {
            return currentPerson.getSpouse();
        }

        List<Person> children = currentPerson.getChildren();

        for (Person child : children) {
            Person foundPerson = searchPersonRecursive(child, name);
            if (foundPerson != null) {
                return foundPerson;
            }
        }

        return null;
    }

    public void printFamilyTree() {
        printFamilyTreeRecursive(this.person, 0);
    }

    private void printFamilyTreeRecursive(Person person, int generation) {
        if (person == null) {
            return;
        }

        String indentation = "  ".repeat(Math.max(0, generation));
        String spouseInfo = person.getSpouse() != null ? " (Spouse: " + person.getSpouse().getName() + ")" : "";

        System.out.println(indentation + person.getName() + spouseInfo);

        for (Person child : person.getChildren()) {
            printFamilyTreeRecursive(child, generation + 1);
        }
    }
}