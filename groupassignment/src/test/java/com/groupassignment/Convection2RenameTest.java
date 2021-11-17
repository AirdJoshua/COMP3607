package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convection2RenameTest {
    private IChangeName newName;
    List<Student> students = new ArrayList<Student>();
    Student student = new Student("Participant 601725", "Maryann Steele", "81304376", "maryann.steele@my.uwi.edu", "", "", "100.00", "Yes", "-", "");
        

    public Convection2RenameTest(){
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        students.add(student); 
        File file = new File("C:\\Users\\willk\\Documents\\GitHub\\COMP3607\\1420037856-602106_Maryann_Steele_601725_Info 2603 Assignment 1.pdf");
        newName = new OriginalNameChangeStrategy(file, students);
    }
    
    @AfterEach
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
