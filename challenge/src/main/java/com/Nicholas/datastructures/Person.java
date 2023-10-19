package com.Nicholas.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private Person father;
    private Person mother;
    private Person spouse;
    private List<Person> children;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (spouse != null) {
            spouse.children.add(child);

            if (spouse.gender.equalsIgnoreCase("Female")) {
                child.setMother(spouse);
                child.setFather(this);
            } else if (spouse.gender.equalsIgnoreCase("Male")) {
                child.setFather(spouse);
                child.setMother(this);
            }
        }
    }


    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public void marry(Person partner) {
        if (partner != null && this.getSpouse() == null && partner.getSpouse() == null) {
            this.setSpouse(partner);
            partner.setSpouse(this);
        } else {
            System.out.println("Invalid marriage request");
        }
    }
}
