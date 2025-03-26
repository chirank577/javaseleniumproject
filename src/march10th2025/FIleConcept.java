package march10th2025;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FIleConcept {
    //IOException ==> INPUT/OUYPUY EXCEPTION WHICH IS MAINLY DEALT WITH FILES
    //Use Cases would be deallock of files, unable to rad or write data etc....
    public static void main(String[] args) throws IOException {
// Prints the path of the current working project
        System.out.println(System.getProperty("user.dir"));

        //We are creating  file object where we pass the path of the file
        //During the creation of file object it will not check whether the file is valid one or not

        File f1=new File(System.getProperty("user.dir")+"//src/march10th2025//Logs");


        //checks if the given file exists or not
        // Returns true if the above condition is satisfied else false
        System.out.println(f1.exists());

        //Checks if we can write the data to the given file path
        // Returns true if the above condition is satisfied else false
        System.out.println(f1.canWrite());

        //Checks if we can read the data to the given file path
        // Returns true if the above condition is satisfied else false
        System.out.println(f1.canRead());

        //creates the missing folders /directories
        f1.mkdirs();

        System.out.println(f1.exists());

        //Checks if the given file object is folder/directory
        // Returns true if the above condition is satisfied else false
        System.out.println(f1.isDirectory());

        //Checks is the given file path is hidden or not
        System.out.println(f1.isHidden());

        //prints the path of the file stored in the file object
        System.out.println(f1.getPath());

        File f2=new File(f1.getPath()+"//Logs.txt");

        System.out.println(f2.exists());

        //create the missing files
        f2.createNewFile();

        System.out.println(f2.canWrite());
        System.out.println(f2.canRead());

        f2.setReadOnly();
//setting the file to writable mode
        f2.setWritable(true);

        System.out.println(f2.canWrite());
       //checks if the given object is afile or not
        System.out.println(f2.isFile());
//prints the size of the file in the form of bytes
        System.out.println(f2.length());

        //Prints the size of the file in the form of kb
        System.out.println(f2.length()/1024);

        //Prints the last modified date and time in nano seconds
        System.out.println(f2.lastModified());

        //simple date format is used to pass which date format we want the time stamp to be represen
        //format: dd-mm-yyyy, yyyy-mm-dd, dd-mm-yyyy hh-mm-ss.sss.etc
        SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss a");

        //converts the date and time in nano seconds
        Date d1=new Date(f2.lastModified());

        //formats the date as per given format
        //sdf.format will acept only a date object
        System.out.println(sdf.format(d1));

        File f3=new File(f1.getPath()+"//Logs1.txt");
        if(f3.exists())
            f3.delete();// if file already exists delete the old file
        f2.renameTo(f3);//Renaming the file with the help of file objects

       // f3.deleteOnExit();//it will delete the file after all the program execution

        System.out.println(f3.length());

        System.out.println(f3.canRead());






    }
}
