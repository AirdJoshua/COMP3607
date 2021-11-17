package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class noConventionStrategy implements IChangeName {
    private File oldFilename;
    private Student student;
    private ArrayList<Student> list;

    public noConventionStrategy(File file, ArrayList<Student> students) {
        this.oldFilename = file;
        this.list = students;
    }

    @Override
    public String changePdfName() {
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String newFilename;
        String fileName = oldFilename.getName();

        student = findStudent(fileName.toLowerCase().replaceAll("\\s", ""));

        if (student != null) {
            newFilename = student.getFullName() + "_" + student.getIdentifier() + "_" + "assignsubmission_file" + "_"
                    + fileName;
            try {
                Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newFilename).toPath()),
                        StandardCopyOption.REPLACE_EXISTING);
                return newFilename;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "student not found";
    }

    public Student findStudent(String fileName) {
        for (Student s : list) {
            if (fileName.contains(s.getIdNumber())) {
                return s;
            }
        }

        for (Student s : list) {
            if (fileName.contains(s.getFullName().toLowerCase().replaceAll("\\s", ""))) {
                return s;
            }
        }
        return null;
    }
}
