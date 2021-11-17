package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convection1To2Test extends ChangeName{


    public Convection1To2Test(ArrayList<Student> students, File file) {
        super(students, file);
    }

    private IChangeName newName;
    List<Student> students = new ArrayList<Student>();
    Student student = new Student("Participant 601725", "Maryann Steele", "81304376", "maryann.steele@my.uwi.edu", "", "", "100.00", "Yes", "-", "");
     
    
    @BeforeEach
    public void setUp() {
        students.add(student); 
        File file = new File("C:\\Users\\willk\\Documents\\GitHub\\COMP3607\\1420037856-602106_Maryann_Steele_601725_Info 2603 Assignment 1.pdf");
        newName = new OriginalNameChangeStrategy(file, students);
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
