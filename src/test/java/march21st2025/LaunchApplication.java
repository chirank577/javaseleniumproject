package march21st2025;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchApplication {
    public static void main(String[] args) {

        //used to maintain the path of the  chromedriver.exe file
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//Drivers//chromedriver");

        //
         WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();

        //1st way
        //drawback og the above approach
        //1. need to ensure that the driver remains in the same location
        //2. we have to manually download the driver for each and every browser upgrade
        //3. suppose if driver file is corrupted or removed, then we have to this setup again and again
        //4. when we execute the code in a VDI or remote machines, they might not accept using separate .exe files for launching the browsers

        //2nd way:
        //Webdriver-manager which is like a sister company to selenium. it helps us in easy setup of browsers without any System.setproperties

        WebDriverManager.firefoxdriver().setup();//it will automatically download the geckodriver.exe file and sets the path or the browser automatically
        driver=new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.close();

        //3rd way

        //It wil automatically download the edge-driver.exe file and sets the path of the browser automatically
        //then it create the driver object
        //when we use .create() method, it will automatically close the browser once the execution is completed

        driver=WebDriverManager.edgedriver().create();
        driver.get("https://www.google.com");

        //4th way;

        //this kind of approach is applicable from selenium 4.8 onwards
        //without using any external library like webdrivermanager to manage the browsers,
        //called as selenium manager that is now present within the selenium library

        driver=new ChromeDriver();
        driver.get("https://www.amazon.com");

        driver=new FirefoxDriver();
        driver.get("https://www.amazon.com");

        driver=new EdgeDriver();
        driver.get("https://www.target.com");


    }
}
