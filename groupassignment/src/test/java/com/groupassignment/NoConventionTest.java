package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoConventionTest{
    private NoConventionStrategy newName;
    private ArrayList<Student> students = Student.getStudents("../studentDataSheet/Sample 5 CSV.csv");  
    
    public NoConventionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        File f = new File("filesToRename/renamedFiles/");
        f.mkdirs();
    }
    
    @AfterAll
    public static void tearDownClass() {
        File f = new File("81348493 Assignment 1 Darrell Rufus Porter.pdf");
        f.delete();
        f= new File("filesToRename/renamedFiles/81348493_601706_assignsubmission_file_Assignment 1 Darrell Rufus Porter.pdf");
        f.delete();
        f = new File("filesToRename/renamedFiles");
        f.delete();
        f = new File("filesToRename");
        f.delete();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @BeforeEach
    public void setUp() {
        File file = new File("81348493 Assignment 1 Darrell Rufus Porter.pdf");
        newName = new NoConventionStrategy(file, students);
        try{
            file.createNewFile();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        //String expResults = "81348493 Assignment 1 Darrell Rufus Porter.pdf ";
        Student expResults = new Student("601683", "Beth Morales-Horton", "81305512", "beth.moraleshorton@my.uwi.edu", null, null, "100", "Yes", "-", null);
        Student results = newName.changePdfName();
        assertNotNull(results);
    }

    @Test
    public void testFindStudentNull(){
        System.out.println("Find Student empty string");
        Student results = newName.findStudent("");
        assertNull(results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student by ID");
        Student results = newName.findStudent("81321343 Assignment 1.pdf");
        System.out.println(results);
        assertNotNull(results);
    }
    
    @Test
    public void testFindStudentbyName(){
        System.out.println("Find Student by Name");
        Student results = newName.findStudent("Assignment1 Winifred Bowers.pdf");
        System.out.println(results);
        assertNotNull(results);
    }

    @Test
    public void testFindStudentNULL(){
        System.out.println("Find Student NULL");
        Student results = newName.findStudent(null);
        assertNull(results);
    }
}
