package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention1To2Test extends ChangeNameTest{


    public Convention1To2Test() {
    }

    private Convention1To2Strategy newName;
    private ArrayList<Student> students = Student.getStudents("studentDataSheet\\Sample 3 CSV.csv");
    
    @BeforeEach
    public void setUp() {
        students = Student.getStudents("studentDataSheet\\Sample 3 CSV.csv");
        File file = new File("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
        newName = new Convention1To2Strategy(file, students);
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        String expResults = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";
        String results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student results = newName.findStudent("Beth Morales");
        assertNotNull(results);
    }
}
