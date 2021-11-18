package com.groupassignment;

import java.io.File;
import java.util.ArrayList;

public class FileFixer 
{
    public static void main( String[] args )
    {
        ArrayList<Student> students = Student.getStudents("studentDataSheet/Sample 3 CSV.csv");
        ArrayList<Student> submittedStudents = new ArrayList<>();
        Student result;
        RenameFiles renameFiles = new RenameFiles();
        RenameContext renameContext;
        
        for(FileIterator fileIter = renameFiles.createIterator(); fileIter.hasNext();){
            File file = fileIter.next();
            String filename = file.getName();
            
            String[] data = filename.split("_");

            //check for the space contained in the name as well as the random myElearning code of convention 2
            if(data.length >= 2 && data[0].contains(" ") && data[1].length() == 6){
                renameContext = new RenameContext(new Convention2RenameStrategy(file, students));
                result = renameContext.changePdfName();

                if(result != null){
                    submittedStudents.add(result);
                }
            }
            //check for the dash contained in convention 1
            else if(data.length >= 2 && data[0].contains("-")){
                String[] randomCodes = data[0].split("-");
                if(randomCodes[0].length() == 10 && randomCodes[1].length() == 6){
                    renameContext = new RenameContext(new Convention1To2Strategy(file, students));
                    result = renameContext.changePdfName();

                    if(result != null){
                        submittedStudents.add(result);
                    }
                }
            }
            else{
                renameContext = new RenameContext(new NoConventionStrategy(file, students));
                result = renameContext.changePdfName();

                if(result != null){
                    submittedStudents.add(result);
                }
            }
        }

        students.removeAll(submittedStudents);
        for(Student s: students){
            System.out.println("Student: " + s.getFullName() + " with ID: " + s.getIdNumber() + " did not submit\n");
        }
    }
}
