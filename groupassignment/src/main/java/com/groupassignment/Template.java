package com.groupassignment;

import java.util.List;

public abstract class Template {

    private List<Student> list;
    
    public final void template(List<Student> studentList){
        list = studentList;
        changePdfName();
    }
    
    public abstract String changePdfName();

    protected  Student findStudent(String fullname) {
        for(Student s: list){
            if(s.getFullName().equals(fullname)){
                return s;
            }
        }
        return null;
    }

}
