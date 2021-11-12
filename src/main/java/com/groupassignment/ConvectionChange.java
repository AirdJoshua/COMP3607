package com.groupassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class ConvectionChange implements IChangeName {

    private File oldFilename;
    private Student student;
    private List<Student> list;


    public ConvectionChange(Student student, File file, List<Student> students) {
        this.oldFilename = file;
        this.student = student;
        this.list = students;
    }

    @Override
    public String changePdfName(){
        String name1;
        String name2;
        String fullname;
        String newFilename;
        String originalName;
        Scanner scan;
        try {
            scan = new Scanner(oldFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "File not found";
        }
        scan.useDelimiter("_");
        name1 = scan.next();
        name2 = scan.next();
        fullname = name1+name2;
        originalName = scan.next();
        student = findStudent(fullname);
        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdNumber()+"_"+"assignSubFile"+"_"+originalName+".pdf";
            scan.close();
            return newFilename;
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
