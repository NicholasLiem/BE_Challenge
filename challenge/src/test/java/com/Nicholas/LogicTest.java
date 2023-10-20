package com.Nicholas;

import com.Nicholas.datastructures.FamilyTree;
import com.Nicholas.datastructures.Person;
import com.Nicholas.utils.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class LogicTest {
    private FamilyTree familyTree;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @Before
    public void setUp() {
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

        this.familyTree = new FamilyTree(kingArthur);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void sibling_test() {
        Person motherTestPerson = new Person("Mother of Test Person", "Female");
        Person fatherTestPerson = new Person("Father of Test Person", "Male");
        fatherTestPerson.marry(motherTestPerson);
        Person testPerson = new Person("Test Person", "Male");
        Person sibling1 = new Person("Sibling1", "Male");
        Person sibling2 = new Person("Sibling2", "Female");

        fatherTestPerson.getSpouse().addChild(testPerson);
        fatherTestPerson.getSpouse().addChild(sibling1);
        fatherTestPerson.getSpouse().addChild(sibling2);

        List<Person> siblings = familyTree.getSiblings(testPerson);

        assertEquals(2, siblings.size());
        assertTrue(siblings.contains(sibling1));
        assertTrue(siblings.contains(sibling2));
        assertFalse(siblings.contains(testPerson));
    }

    @Test
    public void brother_test(){
        Person fatherTestPerson = new Person("Father of Test Person", "Male");
        Person motherTestPerson = new Person("Mother of Test Person", "Female");
        fatherTestPerson.marry(motherTestPerson);
        Person testPerson = new Person("Test Person", "Male");
        Person brother1 = new Person("Brother1", "Male");

        fatherTestPerson.getSpouse().addChild(testPerson);
        fatherTestPerson.getSpouse().addChild(brother1);

        List<Person> brothers = familyTree.getBrothers(testPerson);

        assertEquals(1, brothers.size());
        assertTrue(brothers.contains(brother1));
        assertFalse(brothers.contains(testPerson));
    }

    @Test
    public void sister_test(){
        Person fatherTestPerson = new Person("Father of Test Person", "Male");
        Person motherTestPerson = new Person("Mother of Test Person", "Female");
        fatherTestPerson.marry(motherTestPerson);
        Person testPerson = new Person("Test Person", "Male");
        Person sister1 = new Person("Sister1", "Female");

        fatherTestPerson.getSpouse().addChild(testPerson);
        fatherTestPerson.getSpouse().addChild(sister1);

        List<Person> sisters = familyTree.getSisters(testPerson);

        assertEquals(1, sisters.size());
        assertTrue(sisters.contains(sister1));
        assertFalse(sisters.contains(testPerson));
    }

    @Test
    public void brother_in_law_test(){
        Person darcy = familyTree.searchPersonByName("Darcy");
        Person albus = familyTree.searchPersonByName("Albus");
        Person lily = familyTree.searchPersonByName("Lily");
        List<Person> brotherInLawOfDarcy = familyTree.getBrotherInLaws(darcy);
        assertEquals(1, brotherInLawOfDarcy.size());
        assertTrue(brotherInLawOfDarcy.contains(albus));
        assertFalse(brotherInLawOfDarcy.contains(lily));
    }

    @Test
    public void sister_in_law_test(){
        Person ted = familyTree.searchPersonByName("Ted");
        Person dominique = familyTree.searchPersonByName("Dominique");
        Person louis = familyTree.searchPersonByName("Louis");
        List<Person> sisterInLawOfTed = familyTree.getSisterInLaws(ted);
        assertEquals(1, sisterInLawOfTed.size());
        assertTrue(sisterInLawOfTed.contains(dominique));
        assertFalse(sisterInLawOfTed.contains(louis));


        Person darcy = familyTree.searchPersonByName("Darcy");
        Person alice = familyTree.searchPersonByName("Alice");
        Person lily = familyTree.searchPersonByName("Lily");
        List<Person> sisterInLawOfDarcy = familyTree.getSisterInLaws(darcy);
        assertEquals(2, sisterInLawOfDarcy.size());
        assertTrue(sisterInLawOfDarcy.contains(alice));
        assertTrue(sisterInLawOfDarcy.contains(lily));
    }

    @Test
    public void maternal_aunt_test(){
        Person remus = familyTree.searchPersonByName("Remus");
        Person dominique = familyTree.searchPersonByName("Dominique");
        Person louis = familyTree.searchPersonByName("Louis");
        List<Person> maternalAuntOfWilliam = familyTree.getMaternalAunts(remus);
        assertEquals(1, maternalAuntOfWilliam.size());
        assertTrue(maternalAuntOfWilliam.contains(dominique));
        assertFalse(maternalAuntOfWilliam.contains(louis));
    }

    @Test
    public void paternal_aunt_test(){
        Person william = familyTree.searchPersonByName("William");
        Person lily = familyTree.searchPersonByName("Lily");
        Person alice = familyTree.searchPersonByName("Alice");
        List<Person> paternalAuntOfWilliam = familyTree.getPaternalAunts(william);
        assertEquals(1, paternalAuntOfWilliam.size());
        assertTrue(paternalAuntOfWilliam.contains(lily));
        assertFalse(paternalAuntOfWilliam.contains(alice));
    }

    @Test
    public void maternal_uncle_test(){
        Person remus = familyTree.searchPersonByName("Remus");
        Person dominique = familyTree.searchPersonByName("Dominique");
        Person louis = familyTree.searchPersonByName("Louis");
        List<Person> maternalUncleOfRemus = familyTree.getMaternalUncles(remus);
        assertEquals(1, maternalUncleOfRemus.size());
        assertTrue(maternalUncleOfRemus.contains(louis));
        assertFalse(maternalUncleOfRemus.contains(dominique));
    }

    @Test
    public void paternal_uncle_test(){
        Person victoire = familyTree.searchPersonByName("Victoire");
        Person charlie = familyTree.searchPersonByName("Charlie");
        Person percy = familyTree.searchPersonByName("Percy");
        Person ronald = familyTree.searchPersonByName("Ronald");
        Person ginerva = familyTree.searchPersonByName("Ginerva");

        List<Person> paternalUncle = familyTree.getPaternalUncles(victoire);
        assertEquals(3, paternalUncle.size());
        assertTrue(paternalUncle.contains(charlie));
        assertTrue(paternalUncle.contains(percy));
        assertTrue(paternalUncle.contains(ronald));
        assertFalse(paternalUncle.contains(ginerva));
    }

    @Test
    public void add_child_test(){
        Person newChild = new Person("New Child", "Male");
        Person kingArthur = familyTree.searchPersonByName("King Arthur");
        Person charlie = familyTree.searchPersonByName("Charlie");
        Person percy = familyTree.searchPersonByName("Percy");
        Person ronald = familyTree.searchPersonByName("Ronald");
        Person ginerva = familyTree.searchPersonByName("Ginerva");
        Person bill = familyTree.searchPersonByName("Bill");
        kingArthur.getSpouse().addChild(newChild);

        List<Person> children = kingArthur.getChildren();

        assertEquals(6, children.size());
        assertTrue(children.contains(newChild));
        assertTrue(children.contains(charlie));
        assertTrue(children.contains(percy));
        assertTrue(children.contains(ronald));
        assertTrue(children.contains(ginerva));
        assertTrue(children.contains(bill));
    }

    @Test
    public void not_found_test(){
        Person notFound = new Person("Not found", "Male");
        Person test = familyTree.searchPersonByName("Not found");
        assertNull(test);

        Person kingArthur = familyTree.searchPersonByName("King Arthur");
        kingArthur.getSpouse().addChild(notFound);
        test = familyTree.searchPersonByName("Not found");
        assertNotNull(test);
    }

    @Test
    public void not_found_relation() {
        Person ted = familyTree.searchPersonByName("Ted");
        List<Person> tedSibling = familyTree.getSiblings(ted);
        Utils.printList(tedSibling);
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains("NONE"));
    }
}