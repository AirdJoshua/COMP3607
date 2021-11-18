package com.groupassignment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention2RenameTest{
    private Convention2RenameStrategy newName;
    private List<Student> students = Student.getStudents("../studentDataSheet/Sample 3 CSV.csv");

    public Convention2RenameTest(){
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @AfterEach
    public void tearDown() {
    }
  
    @BeforeEach
    public void setUp() {
        File file = new File("Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
        newName = new Convention2RenameStrategy(file, students);
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        String expResults = "Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf";
        String results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student results = newName.findStudent("Anna Horton");
        assertNotNull(results);
    }
    
}
