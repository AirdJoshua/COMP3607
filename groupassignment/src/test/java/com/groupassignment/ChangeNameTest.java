package com.groupassignment;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class ChangeNameTest {
      
    public final void changeNameTest(){
        setUp();
        testChangePdfName();
        testFindStudent();
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
    public abstract void setUp();

    @Test
    public abstract void testChangePdfName();

    @Test
    public abstract void testFindStudent();
    
}
