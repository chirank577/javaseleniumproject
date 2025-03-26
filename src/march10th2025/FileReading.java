package march10th2025;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class FileReading {
    public static void main(String[] args) throws IOException {
        readDatafromTheFile_Alternate(System.getProperty("user.dir")+"//src//march10th2025//Logs//Logs_New.txt");

    }
   /* public static void readDataFromTheFile(String filePath) throws IOException {
        //filereader is the class used to read the data from the file
        FileReader fr=new FileReader(filePath);
       // read() is used to read the data from the file
        System.out.println(fr.read());// reads the first caracter only with ASCII value

        //fr.read():
        //reads the file char by char
        //reads the ASCII value of the given character
        //returns -1 if it reaches the end of the file

        int a=0;
         while((a=fr.read())!=-1)
         {
             //converting the interger to a character
             System.out.println((char)a);
         }
    }*/

    public static void readDatafromTheFile_Alternate(String filePath) throws IOException {
          FileReader fr=new FileReader(filePath);

          //BufferReader help us in reading the date line by line
        //Since BufferReader cannnot interact with the file directly, we are taking the help of filereader to read the data from the file

        BufferedReader br=new BufferedReader(fr);

        //reads the first line of data in the file
        System.out.println(br.readLine());

        //shorcut to read all the lines of data
        System.out.println(br.lines().collect(Collectors.joining("\n")));


    }
}


