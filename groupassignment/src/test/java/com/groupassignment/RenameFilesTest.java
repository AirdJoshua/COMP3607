package com.groupassignment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RenameFilesTest {
    private RenameFiles rFiles;

    public RenameFilesTest(){
    }

    @BeforeAll
    public static void setUpClass() {

    }
    
    @AfterAll
    public static void tearDownClass() {
        File f = new File("filesToRename");
        f.delete();
    }
    
    @BeforeEach
    public void setUp() {
        File f = new File("filesToRename");
        f.mkdir();
        rFiles = new RenameFiles();
   }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void getFilesFromFolder(){
        System.out.println("get Files");
        FileIterator results = rFiles.createIterator();
        assertNotNull(results);
    }
 
}
