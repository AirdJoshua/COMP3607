package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NoConventionTest extends ChangeNameTest {

    public NoConventionTest() {
    }

    private NoConventionStrategy newName;
    private List<Student> students = Student.getStudents("studentDataSheet\\Sample 5 CSV.csv");  
    
    @BeforeEach
    public void setUp() {
        File file = new File("81348493 Assignment 1 Darrell Rufus Porter.pdf");
        newName = new NoConventionStrategy(file, students);
        students.toString();
    }
    
    @Test
    public void testGetSubmittedStudents(){
        System.out.println("get submitted");
        List<Student> result = newName.getSubmittedStudents();
        assertNotNull(result);
    }

    @Test
    public void testChangePdfName(){
        System.out.println("get New name");
        String expResults = "81348493_601706_assignsubmission_file_Assignment 1 Darrell Rufus Porter.pdf";
        String results = newName.changePdfName();
        assertEquals(expResults,results);
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
        Student results = newName.findStudent("Irving Fitzgerald Info 2603 Assignment 1.pdf ");
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
