package march10th2025;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    //Inside a static method, we can call other statuc methods or variables
    //Inside a non static method, we can call both static and non-static methods or variables

    public static void main(String[] args) throws IOException {
        writeDataToTheFile(System.getProperty("user.dir")+"//src//march10th2025//Logs//Logs_New.txt","lets see if it starts with first line Sample_Content");
        writeDataToTheFile(System.getProperty("user.dir")+"//src//march10th2025//Logs//Logs_New.txt","Sample_Content chiru");


    }

    public static void writeDataToTheFile(String filePath, String content) throws IOException {
        //filewrite is the library that helps us in writing the data to the file

        //filewriter will create a new file if the file does not exist
        //file writer writes the data to the file character by character
        //filewriter overrides the data by default

        File f1=new File(filePath);
        FileWriter fr=new FileWriter(filePath,f1.exists());

        if(f1.exists())
            fr.write("\n");
        fr.write(content);
        fr.close();
        /*{
            //append the data to the existig file if it i set to true
            FileWriter fr=new FileWriter(filePath,true);
            fr.write("\n");//add a new line to the existing file
            fr.write(content);
            fr.close();}
        else {
            FileWriter fr=new FileWriter(filePath);
            fr.write(content);
            fr.close();
        }*/

    }



}
