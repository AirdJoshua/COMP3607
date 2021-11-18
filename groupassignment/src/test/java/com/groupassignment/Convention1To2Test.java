package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Convention1To2Test{


    public Convention1To2Test() {
    }

    private Convention1To2Strategy newName;
    private ArrayList<Student> students = Student.getStudents("../studentDataSheet/Sample 3 CSV.csv");
    
    @BeforeAll
    public static void setUpClass() {
        File f = new File("filesToRename/renamedFiles/");
        f.mkdirs();
    }
    
    @AfterAll
    public static void tearDownClass() {
        File f = new File("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
        f.delete();
        f= new File("filesToRename/renamedFiles/Beth Morales-Horton_601683_assignsubmission_file_81305512.pdf");
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
        File file = new File("./1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
        newName = new Convention1To2Strategy(file, students);
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
        //String expResults = "Beth Morales-Horton_601683_assignsubmission_file_81305512.pdf";
        Student results = newName.changePdfName();
        assertNotNull(results);
    }

    @Test
    public void testFindStudent(){
        System.out.println("Find Student");
        Student results = newName.findStudent("1409121490-602637_Beth_Morales-Horton_601683_Assignment1_81305512.pdf");
        assertNotNull(results);
    }
}
