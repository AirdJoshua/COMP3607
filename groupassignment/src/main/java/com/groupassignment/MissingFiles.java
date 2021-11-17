package com.groupassignment;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class MissingFiles{
    
    public void missingSubmissionFiles(ArrayList<Student> students, ArrayList<Student> submitted){
        ArrayList<Student> missing = new ArrayList<Student>();
        Iterator<Student> subIter = submitted.iterator();
        boolean found;
        for(Student s: students){
            String studentID = s.getIdNumber();
            found = false;
            while(subIter.hasNext() && !found){
                Student temp = subIter.next();
                if (studentID.equals(temp.getIdNumber()));
                    found = true;
            }
            if(!found)
                missing.add(s);
        }
        for(Student s: missing){
            //System.out.println(s.getFullName());
        }
    }

}
