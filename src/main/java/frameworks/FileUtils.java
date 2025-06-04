package frameworks;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.stream.Collectors;

@UtilityClass
public class FileUtils {

    @SneakyThrows
    public void writeDataToTheFile(String filePath, String  data) {

        File file=new File(filePath);

        FileWriter fileWriter= new FileWriter(filePath, file.exists());

        fileWriter.write(data);

        fileWriter.close();

    }

    @SneakyThrows
    public String readDataFromTheFile(String filePath)
    {
        FileReader fr=new FileReader(filePath);

        BufferedReader br=new BufferedReader(fr);

        return br.lines().collect(Collectors.joining("\n"));

    }


}
