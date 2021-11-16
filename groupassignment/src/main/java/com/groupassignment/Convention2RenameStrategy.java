package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Convention2RenameStrategy implements IChangeName{
    private File oldFilename;
    private Student student;
    private ArrayList<Student> list;

    public Convention2RenameStrategy(File file, ArrayList<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    @Override
    public String changePdfName(){
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String name;
        String fullname;
        String newFilename;
        String originalName;
        Scanner scan;
        
        try {
            scan = new Scanner(oldFilename.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return "File not found";
        }
        scan.useDelimiter("_");
        name = scan.next();
        //read identifier
        scan.next();

        //read assignSubmissionFile
        scan.next();
        scan.next();
        fullname = name;
        originalName = scan.next();

        student = findStudent(fullname);
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

    public Student findStudent(String fullname) {
        for(Student s: list){
            if(s.getFullName().equals(fullname)){
                return s;
            }
        }
        return null;
    }
}