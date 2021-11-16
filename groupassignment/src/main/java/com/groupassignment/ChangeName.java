package com.groupassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeName {
    private File oldFilename;
    private ArrayList<Student> list;

    public ChangeName(ArrayList<Student> students, File file) {
        this.oldFilename = file;
        this.list = students;
    }

    public String toNewConvention() throws FileNotFoundException{
        String name1;
        String name2;
        String fullname;
        String newFilename;
        String originalName;
        Scanner scan = new Scanner(oldFilename);
        scan.useDelimiter("_");
        name1 = scan.next();
        name2 = scan.next();
        fullname = name1+name2;
        originalName = scan.next();
        Student student = findStudent(fullname);
        if(student != null){
            newFilename = student.getFullName()+"_"+ student.getIdNumber()+"_"+"assignSubFile"+"_"+originalName+".pdf";
            scan.close();
            return newFilename;
        }
        scan.close();
        return "student not found";
    }

    private Student findStudent(String fullname){
        for(Student s: list){
            if(s.getFullName().equals(fullname)){
                return s;
            }
        }
        return null;
    }
}
