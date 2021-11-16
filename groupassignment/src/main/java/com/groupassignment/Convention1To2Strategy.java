package com.groupassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;


public class Convention1To2Strategy implements IChangeName {
    private File oldFilename;
    private Student student;
    private ArrayList<Student> list;

    public Convention1To2Strategy(File file, ArrayList<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    @Override
    public String changePdfName(){
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String newFilename;
        Scanner scan;
        
        try {
            scan = new Scanner(oldFilename.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return "File not found";
        }
        scan.useDelimiter("_");
        String myelearningCode = scan.next();
        String name1 = scan.next();
        String name2 = scan.next();
        String identifier = scan.next();
        String originalName = scan.next();

        student = findStudent(identifier);

        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdNumber()+"_"+"assignsubmission_file"+"_"+ originalName;
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
            String[] identifier= s.getIdentifier().split(" ");
            if(fileName.contains(identifier[1])){
                return s;
            }
        }
        return null;
    }
}