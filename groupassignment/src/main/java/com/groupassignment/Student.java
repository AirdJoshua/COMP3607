package com.groupassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Student {
    private String identifier;
    private String fullName;
    private String idNumber;
    private String emailAddress;
    private String status;
    private String grade;
    private String maxGrade;
    private String canChangeGrade;
    private String lastChanged;
    private String feedback;

    public Student(String identifier, String fullName, String idNumber, String emailAddress, String status,
            String grade, String maxGrade, String canChangeGrade, String lastChanged, String feedback) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.emailAddress = emailAddress;
        this.status = status;
        this.grade = grade;
        this.maxGrade = maxGrade;
        this.canChangeGrade = canChangeGrade;
        this.lastChanged = lastChanged;
        this.feedback = feedback;
    }

    public Student(String identifier, String fullName, String idNumber, String emailAddress, String status,
            String grade, String maxGrade, String canChangeGrade, String lastChanged) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.emailAddress = emailAddress;
        this.status = status;
        this.grade = grade;
        this.maxGrade = maxGrade;
        this.canChangeGrade = canChangeGrade;
        this.lastChanged = lastChanged;
    }

    public String getIdentifier() {
        String[] s = identifier.split(" ");
        return s[1];
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStatus() {
        return status;
    }

    public String getGrade() {
        return grade;
    }

    public String getMaxGrade() {
        return maxGrade;
    }

    public String getCanChangeGrade() {
        return canChangeGrade;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public String getFeedback() {
        return feedback;
    }

    public static ArrayList<Student> getStudents(String csvFilePath){
        File csvFile = new File(csvFilePath);
        ArrayList<Student> students = new ArrayList<Student>();
        String row;

        //if csvFile exists
        if (csvFile.isFile()) {
            try{
                BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
            
            //read and discard first line
            csvReader.readLine();
            
            //store the data from csvFile into an ArrayList of type student
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
                students.add(student);
            }
            csvReader.close();
            } catch(Exception e){
                System.out.println("Error while reading CSV file !!!");
            }
        }

        return students;
    }

    @Override
    public String toString() {
        return "Student" + "identifier='" + identifier + '\'' + ", fullName='" + fullName + '\'' + ", idNumber="
                + idNumber + ", emailAddress='" + emailAddress + '\'' + ", status='" + status + '\'' + ", grade='"
                + grade + '\'' + ", maxGrade=" + maxGrade + ", canChangeGrade=" + canChangeGrade + ", lastChanged='"
                + lastChanged + '\'' + ", feedback='" + feedback + '\'';
    }
}
