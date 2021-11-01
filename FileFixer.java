import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class FileFixer {
    public static void main(String[] args) throws Exception{
        File csvFile = new File("./testSheet.csv");
        ArrayList<Student> students = new ArrayList<Student>();
        String row;

        //if csvFile exists
        if (csvFile.isFile()) {
            BufferedReader csvReader = new BufferedReader(new FileReader("./testSheet.csv"));
            
            //read and discard first line
            csvReader.readLine();
            
            //store the data from csvFile into an ArrayList of type student
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Student student = new Student(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
                students.add(student);
            }
            csvReader.close();
        }
         File toBeRenamed = new File("./filesToRename/e.pdf");
         renameFile(toBeRenamed, "f");

    }

    private static void renameFile(File toBeRenamed, String newName) throws Exception{
        //create new path object from toBeRenamed
        Path toBeRenamedPath = Paths.get(toBeRenamed.getPath());
        Files.copy(toBeRenamedPath, (new File("./filesToRename/renamedFiles/" + newName + ".pdf").toPath()), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void missingSubmissions(ArrayList<Student> students){  //checks for missing submissions (requires a list of student submissions)
        /*
        ArrayList<Student> missing = new ArrayList<Student>();
        bool found;
        for(Student s: students){
            studentID = s.getIdNumber()
            found = false;
            while not end of the list of files
                pull ID section of convention2 name
                    if studentID.equals(ID);
                        found == true;
            if(found == false)
                missing.add(s);
        }
         //if she wants us to output it to a file
        File missingSubmissions = new File("./missingSubmissions.txt");
        FileWriter fw = new FileWriter("missingSubmissions.txt");
        for(Student s: missing){
            fw.write(s.getIdNumber() + " " + s.getFullName() + "\n");
        }
        */
        
    }
}
