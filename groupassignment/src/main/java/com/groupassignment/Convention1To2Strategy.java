package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Convention1To2Strategy implements IChangeName {
    private File oldFilename;
    private Student student;
    private ArrayList<Student> list;

    public Convention1To2Strategy(File file, List<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    public Convention1To2Strategy(File file, List<Student> students) {
    }

    @Override
    public String changePdfName(){
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String newFilename;
        Scanner scan;
        String fileName = oldFilename.getName();
        try {
            scan = new Scanner(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return "File not found";
        }
        scan.useDelimiter("_");
        //read myElearning code
        scan.next();
        //read first and last names
        
        //String identifier = scan.next();
        String originalName = new String();

        while(scan.hasNext()){
            originalName = scan.next();
        }

        student = findStudent(fileName.replaceAll("\\s", "").toLowerCase());

        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdentifier()+"_"+"assignsubmission_file_"+ originalName;
            scan.close();
            try{
                Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newFilename).toPath()), StandardCopyOption.REPLACE_EXISTING);
                return newFilename;
            }
            catch(Exception e){
                e.printStackTrace();    
            }
        }
        scan.close();  
        return "student not found"; 
    }

    public Student findStudent(String fileName) {
        for(Student s: list){
            if(fileName.contains(s.getIdentifier().replaceAll("\\s", "").toLowerCase())){
                return s;
            }
        }
        return null;
    }
}