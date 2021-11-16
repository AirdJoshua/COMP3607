package com.groupassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;

public class OriginalNameChangeStrategy implements IChangeName{

    private File oldFilename;
    private List<Student> list;


    public OriginalNameChangeStrategy( File file, List<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }


    @Override
    public String changePdfName() {
        Student student;
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String[] strings = new String[10];
        String newFilename;
        String words = "";
        String id = "";
        boolean found = false;
        StringBuilder originalName = new StringBuilder();
        Scanner scan;
        try {
            scan = new Scanner(oldFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found";
        }
        scan.useDelimiter("_ |\\W");
        while(!scan.hasNextLine()){
            int x=0;
            strings[x]= scan.next();
            strings[x] = strings[x].trim();
            int len = strings[x].length();
            found = ifDigits(strings[x], len);
            if(len == 8 && found)
                id = strings[x];
            else{
                words = words.concat(strings[x]);
            }
        }
        
        for(int x = 0; x < strings.length;x++){
            originalName.append(strings[x]);
        }

        if(found)
            student = findById(id);
        else    
            student = findStudent(originalName.toString());

        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdNumber()+"_"+"assignSubFile"+"_"+originalName+".pdf";
            scan.close();
            try{
                Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newFilename + ".pdf").toPath()), StandardCopyOption.REPLACE_EXISTING);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return newFilename;
        }
        scan.close();
        return "student not found";
    }

    private boolean ifDigits(String string, int len){
        for(int x = 0; x<len; x++){
            if(!Character.isDigit(string.charAt(x)))
                return false;
        }
        return true;
    }
    
    public Student findStudent(String string) {
        for(Student s: list){
            if(string.contains(s.getFullName())){
                return s;
            }
        }
        return null;
    }

    public Student findById(String id){
        for(Student s:list){
            if(s.getIdNumber().equals(id))
                return s;
        }
        return null;
    }

}
