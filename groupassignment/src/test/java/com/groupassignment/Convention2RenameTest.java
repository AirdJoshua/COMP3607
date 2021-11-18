package com.groupassignment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention2RenameTest extends ChangeNameTest {
    private Convention2RenameStrategy newName;
    private List<Student> students = Student.getStudents("studentDataSheet\\Sample 1 CSV.csv");

    public Convention2RenameTest(){
    }
    
  
    @BeforeEach
    public void setUp() {
        File file = new File("Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf");
        newName = new Convention2RenameStrategy(file, students);
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        Student expResults = new Student("601683", "Beth Morales-Horton", "81305512", "beth.moraleshorton@my.uwi.edu", null, null, "100", "Yes", "-", null);
        //String expResults = "Anna Horton_601727_assignsubmission_file_info 2603 assignment 1.pdf";
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
