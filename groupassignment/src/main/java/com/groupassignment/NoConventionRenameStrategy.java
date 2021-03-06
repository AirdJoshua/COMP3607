package com.groupassignment;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NoConventionRenameStrategy implements IChangeName{
    private File oldFilename;
    private List<Student> list;

    public NoConventionRenameStrategy(File file, List<Student> students){
        this.oldFilename = file;
        this.list = students;
    }

    public Student changePdfName() {
        Student student;
        Path toBeRenamedPath = Paths.get(oldFilename.getPath());
        String newFilename;
        String fileName = oldFilename.getName();

        student = findStudent(fileName.toLowerCase().replaceAll("\\s", ""));

        if (student != null) {
            newFilename = student.getFullName() + "_" + student.getIdentifier() + "_" + "assignsubmission_file" + "_"
                    + fileName;
            try {
                File renamedFiles =new File("filesToRename/renamedFiles/");
                if(!renamedFiles.exists()){
                    renamedFiles.mkdir();
                }
                Files.copy(toBeRenamedPath, (new File("filesToRename/renamedFiles/" + newFilename).toPath()), StandardCopyOption.REPLACE_EXISTING);
                return student;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Student findStudent(String fileName) {
        if(fileName == null){
            return null;
        }
        for (Student s : list) {
            if (fileName.contains(s.getIdNumber())) {
                return s;
            }
        }

        for (Student s : list) {
            if (fileName.replaceAll("\\s", "").toLowerCase().contains(s.getFullName().toLowerCase().replaceAll("\\s", ""))) {
                return s;
            }
        }
        return null;
    }
}