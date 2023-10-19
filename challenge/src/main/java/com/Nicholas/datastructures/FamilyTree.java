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

    public void setPerson(Person person) {
        this.person = person;
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
        List<Person> siblings = new ArrayList<>();
        Person mother = person.getMother();
        if (mother != null) {
            List<Person> children = mother.getChildren();
            siblings.addAll(children);
            siblings.remove(person);
        }
        return siblings.stream()
                .filter(child -> child.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
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
            brotherInLaws.addAll(getBrothers(person));
        }
        return brotherInLaws;
    }

    /**
     * Sister-In-Law Relationship
     */
    public List<Person> getSisterInLaws(Person person) {
        List<Person> sisterInLaws = new ArrayList<>();
        if (person.getSpouse() != null) {
            sisterInLaws.addAll(getSisters(person));
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