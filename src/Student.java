package com.groupassignment;
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

    public Student (String identifier, String fullName, String idNumber, String emailAddress, String status, String grade, String maxGrade, String canChangeGrade, String lastChanged, String feedback){
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

    public String getIdentifier() {
        return identifier;
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

    @Override
    public String toString() {
        return "Student" +
                "identifier='" + identifier + '\'' +
                ", fullName='" + fullName + '\'' +
                ", idNumber=" + idNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", status='" + status + '\'' +
                ", grade='" + grade + '\'' +
                ", maxGrade=" + maxGrade +
                ", canChangeGrade=" + canChangeGrade +
                ", lastChanged='" + lastChanged + '\'' +
                ", feedback='" + feedback + '\'';
    }
}
