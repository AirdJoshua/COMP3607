package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RenameFilesTest {
    private RenameFiles rFiles;
    private List<File> files = new ArrayList<File>();
    private int index;

    public RenameFilesTest(){

    }

    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        rFiles = new RenameFiles();
   }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getFilesFromFolder(){
        System.out.println("get Files");
        FileIterator expResults = rFiles.createIterator();
        FileIterator results = rFiles.createIterator();;
        assertEquals(expResults, results);
    }
 
}
