package com.groupassignment;

import java.util.ArrayList;

public interface IChangeName {
    public String changePdfName();
    public Student findStudent(String fullname);
    public ArrayList<Student> getSubmittedStudents();
}
