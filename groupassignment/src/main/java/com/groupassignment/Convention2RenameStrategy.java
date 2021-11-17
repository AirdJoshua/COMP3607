package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;

public class Convention2RenameStrategy implements IChangeName{
    private File oldFilename;
    private List<Student> list;

    public Convention2RenameStrategy(File file, List<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    @Override
    public String changePdfName(){
        Student student;
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String name;
        String fullname;
        String newFilename;
        String originalName = "";
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

        while(scan.hasNext()){
            originalName += scan.next();
        }
        

        student = findStudent(fullname);
        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdentifier()+"_"+"assignsubmission_file"+"_"+ originalName;
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
            if(s.getFullName().replaceAll("\\s", "").toLowerCase().equals(fullname.replaceAll("\\s", "").toLowerCase())){
                return s;
            }
        }
        return null;
    }
}
