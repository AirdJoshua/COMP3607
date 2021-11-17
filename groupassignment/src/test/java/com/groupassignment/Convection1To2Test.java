package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convection1To2Test extends ChangeNameTest{


    public Convection1To2Test() {
    }

    private Convention1To2Strategy newName;
    ArrayList<Student> students = Student.getStudents("studentDataSheet\\Sample 1 CSV.csv");
    
    @BeforeEach
    public void setUp() {
        File file = new File("1420037856-602106_Maryann_Steele_601725_Info 2603 Assignment 1.pdf");
        newName = new Convention1To2Strategy(file, students);
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
        Student results = newName.findStudent("Maryann Steele");
        assertNotNull(results);
    }
}
