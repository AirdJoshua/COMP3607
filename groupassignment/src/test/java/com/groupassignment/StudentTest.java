package com.groupassignment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import org.junit.BeforeClass;
import org.junit.Before;

public class StudentTest{
    private Student student;

    public StudentTest(){
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        student = new Student("Participant 601725", "Maryann Steele", "81304376", "maryann.steele@my.uwi.edu", "", "", "100.00", "Yes", "-", "");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetIdNumber(){
        System.out.println("get Id Number");
        String expResults = "81304376";
        String results = student.getIdNumber();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetCanChangeGrade(){
        System.out.println("get Can Change Grade");
        String expResults = "Yes";
        String results = student.getCanChangeGrade();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetEmail(){
        System.out.println("get Email");
        String expResults = "maryann.steele@my.uwi.edu";
        String results = student.getEmailAddress();
        assertEquals(expResults,results);
    }

    @Test
    public void testFeedback(){
        System.out.println("get Feedback");
        String expResults = "";
        String results = student.getFeedback();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetGrade(){
        System.out.println("get Grade");
        String expResults = "";
        String results = student.getGrade();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetIdentifier(){
        System.out.println("get Identifier");
        String expResults = "Participant 601725";
        String results = student.getIdentifier();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetLast(){
        System.out.println("get Last Chnages");
        String expResults = "-";
        String results = student.getLastChanged();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetMaxGrade(){
        System.out.println("get Max Grade");
        String expResults = "100.00";
        String results = student.getMaxGrade();
        assertEquals(expResults,results);
    }

    @Test
    public void testGetStatus(){
        System.out.println("get Status");
        String expResults = "";
        String results = student.getStatus();
        assertEquals(expResults,results);
    }

}
