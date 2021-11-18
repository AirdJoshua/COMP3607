package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention1To2Test extends ChangeNameTest{

    private ArrayList<Student> students = Student.getStudents("studentDataSheet\\Sample 3 CSV.csv");
    private Convention1To2Strategy newName;

    @BeforeEach
    public void setUp() {
        File file = new File("./1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
        newName = new Convention1To2Strategy(file, students);
    }

    @Test
    public void testChangePdfName(){
        //System.out.println("get New name");
        Student expResults = new Student("601683", "Beth Morales-Horton", "81305512", "beth.moraleshorton@my.uwi.edu", null, null, "100", "Yes", "-", null);
        //String expResults = "1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf";
        Student results = newName.changePdfName();
        assertEquals(expResults,results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student results = newName.findStudent("Beth Morales");
        assertNotNull(results);
    }
}
