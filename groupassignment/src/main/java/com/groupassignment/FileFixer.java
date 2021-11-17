package com.groupassignment;

import java.io.File;
import java.util.ArrayList;

public class FileFixer 
{
    public static void main( String[] args )
    {
        ArrayList<Student> students = Student.getStudents("studentDataSheet\\Sample 3 CSV.csv");
        RenameFiles renameFiles = new RenameFiles();
        
        for(FilesIterator fileIter = renameFiles.createIterator(); fileIter.hasNext();){
            File file = fileIter.next();
            String filename = file.getName();
            
            String[] data = filename.split("_");

            //check for the space contained in the name as well as the random myElearning code of convention 2
            if(data.length >= 2 && data[0].contains(" ") && data[1].length() == 6){
                Convention2RenameStrategy renameStrategy = new Convention2RenameStrategy(file, students);
                String newName = renameStrategy.changePdfName();
                
                renameStrategy.missingSubmissionFiles(students,renameStrategy.getSubmittedStudents());
                System.out.println(newName);
            }
            //check for the dash contained in convention 1
            else if(data.length >= 2 && data[0].contains("-")){
                String[] randomCodes = data[0].split("-");
                if(randomCodes[0].length() == 10 && randomCodes[1].length() == 6){
                    Convention1To2Strategy renameStrategy = new Convention1To2Strategy(file, students);
                    String newName = renameStrategy.changePdfName();
                    System.out.println(newName);
                }
            }
            else{
                NoConventionStrategy renameStrategy = new NoConventionStrategy(file, students);
                String newName = renameStrategy.changePdfName();
                System.out.println(newName);
            }
        }
    }
}
