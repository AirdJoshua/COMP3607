package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;


public class Convention1To2Strategy extends MissingFiles implements IChangeName{
    private File oldFilename;
    private List<Student> list;

    public Convention1To2Strategy(File file, List<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    @Override
    public Student changePdfName(){
        Student student;
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String newFilename;
        Scanner scan;
        String fileName = oldFilename.getName();
        try {
            scan = new Scanner(fileName);
        } catch (Exception e) {
            System.out.println("File not found");
            return null;
        }
        scan.useDelimiter("_");
        //read myElearning code
        scan.next();
        //read first and last names
        
        //String identifier = scan.next();
        String originalName = "";

        while(scan.hasNext()){
            originalName = scan.next();
        }

        student = findStudent(fileName.replaceAll("\\s", "").toLowerCase());

        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdentifier()+"_"+"assignsubmission_file_"+ originalName;
            scan.close();
            try{
                File renamedFiles =new File("filesToRename/renamedFiles/");
                if(!renamedFiles.exists()){
                    renamedFiles.mkdir();
                }
                Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newFilename).toPath()), StandardCopyOption.REPLACE_EXISTING);
                return student;
            }
            catch(Exception e){
                e.printStackTrace();    
            }
        }
        scan.close();  
        return null; 
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