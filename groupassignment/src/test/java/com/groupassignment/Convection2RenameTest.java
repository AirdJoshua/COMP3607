package com.groupassignment;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.Before;

public class Convection2RenameTest {
    private IChangeName newName;
    List<Student> students = new ArrayList<Student>();
    Student student = new Student("Participant 601725", "Maryann Steele", "81304376", "maryann.steele@my.uwi.edu", "", "", "100.00", "Yes", "-", "");
        

    public Convection2RenameTest(){

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        students.add(student); 
        File file = new File("C:\\Users\\willk\\Documents\\GitHub\\COMP3607\\1420037856-602106_Maryann_Steele_601725_Info 2603 Assignment 1.pdf");
        newName = new OriginalNameChangeStrategy(file, students);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        String expResults = "Maryann Steele_601725_assignsubmission_file_Info 2603 Assignment 1.pdf";
        String results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student expResults = student;
        Student results = newName.findStudent("Maryann Steele");
        assertEquals(expResults, results);
    }

}
