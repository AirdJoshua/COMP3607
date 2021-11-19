package com.groupassignment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention2RenameTest{
    private Convention2RenameStrategy newName;
    private ArrayList<Student> students = Student.getStudents("../studentDataSheet/Sample 1 CSV.csv");

    public Convention2RenameTest(){
    }

    @BeforeAll
    public static void setUpClass() {
        File f = new File("filesToRename/renamedFiles/");
        f.mkdirs();
    }
    
    @AfterAll
    public static void tearDownClass() {
        File f = new File("Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
        f.delete();
        f= new File("filesToRename/renamedFiles/Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
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
        File file = new File("Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
        newName = new Convention2RenameStrategy(file, students);
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
        Student expResults = new Student("Participant 601727", "Anna Horton", "81393384", "anna.horton@my.uwi.edu", "", "", "100.00", "Yes", "Monday, 4 January 2021, 1:13 AM", null);
        Student results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student results = newName.findStudent("Anna Horton");
        assertNotNull(results);
    }
}
