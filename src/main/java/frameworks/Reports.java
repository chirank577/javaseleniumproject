package frameworks;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

@AllArgsConstructor
public class Reports {

    WebDriver driver;
    @SneakyThrows
    public String captureScreenShot(String...imgName)
    {
        //Takescreenshot--> is the function used to capture the screenshot
        //(Takescreenshot)driver--> is the function used to capture the screenshot of the browsers
        //((Takescreenshot)driver).getScreenShot()--> is the function used to capture the screenshot of the browser
        //and store it either in the form of file or byte array or base64
        //when we store the screenshot in the form of a file, it generates .png file
        //All the screenshots generated will be stored in the temp folder


        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        System.out.println(src.getPath());

        File dest=new File(PathUtils.getScreenSHotPath(imgName));
        //Copying the file from source to destination
        Files.copy(src.toPath(),dest.toPath());
        return dest.getPath();
    }

}
