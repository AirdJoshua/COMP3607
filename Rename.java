import java.util.Scanner;
public class Rename {
    private String oldFilename;

    public Rename(String oldFilename) {
        this.oldFilename = oldFilename;
    }

    public String toNewConvection(){
        String name1, name2;
        String newFilename;
        String originalName;
        String assignSubFile = null;
        Scanner scan = new Scanner(oldFilename);
        scan.useDelimiter("_");
        name1 = scan.next();
        name2 = scan.next();
        originalName = scan.next();
        newFilename = name1+" "+name2 +"_"+ studentID+"_"+assignSubFile+"_"+originalName+".pdf";

        return newFilename;
    }

    //Assumption that Collection of Students
    /* File name get;
    find the student
    use parsing to separate convection 1 to convection 2
    Covection 1 separates into
    int randomCode  randomCode1 and 2
    usedelimiter (_)
    String name1
    usedelimiter (_)
    String name2
    usedelimiter (_)
    String originalName    select everything even if the original file name has white spaces
    usedelimiter (_)
    int randomCode   randomCode3 and 4

    String Name1
    String Name2
    String assignSubFile
    int StudentID;

    newFilename = Name1+" "+Name2 +"_"+ studentID+"_"+assignSubFile+"_"+originalName+".pdf";

    */
}
