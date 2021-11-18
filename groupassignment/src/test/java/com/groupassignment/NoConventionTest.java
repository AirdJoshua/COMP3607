package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoConventionTest extends ChangeNameTest {

    public NoConventionTest() {
    }

    private NoConventionStrategy newName;
    private List<Student> students = new ArrayList<Student>();   
    
    @BeforeEach
    public void setUp() {
        File file = new File("81348493 Assignment 1 Darrell Rufus Porter.pdf ");
        newName = new NoConventionStrategy(file, students);
    }
    
    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        //String expResults = "81348493 Assignment 1 Darrell Rufus Porter.pdf ";
        Student expResults = new Student("601683", "Beth Morales-Horton", "81305512", "beth.moraleshorton@my.uwi.edu", null, null, "100", "Yes", "-", null);
        Student results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student by ID");
        Student results = newName.findStudent("81348493");
        assertNotNull(results);
        System.out.println("Find Student by Name");
        results = newName.findStudent("Darrell Rufus");
        assertNotNull(results);
    }
}
