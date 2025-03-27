package march25thLaunchingBrowsers;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.Set;

public class DifferentWaysOfLaunchingBrowsers {
    public static void main(String[] args) {
        //1st way
        //drawback of this approach is that we cannot achieve cross browsers testing
        //we can run our test cases only in Chrome browser
       // ChromeDriver driver=new ChromeDriver();
       // driver.get("https://www.target.com");

        //2nd way
        //Drawback of this approach is that it does not cotain the method to launch the application
        //Searchcontext interface contains only two methods
        //1. findelements
        //2.findelements
        //right way to create the driver, but we can not launch the application
        //SearchContext s1=new EdgeDriver();

        //Third way: Recommended Approach

//        RemoteWebDriver driver=new ChromeDriver();
//        driver.get("https://www.google.com");

        //fourth approach
        //ChromiumDriver driver=new ChromeDriver();//it will only work for chrome and edge driver

        //fifth approach
       // RemoteWebDriver driver=new ChromiumDriver();
        //we can never create an object using the Chromiumdriver as it expect some argument to be passed during the driver creation
        //which nad be tedious at times to pass it
        //values to be passed are related to some chrome-devtools and its capabilities

        //sisth way:
        //not a recommended way at all
       // SearchContext s1=new Webdriver();

        //seventh way : recommended approach when we are using ay selenium grid, Lambda test, browser stack etc.
        //main reason is hat this is mainly used for executing the test cases in a remote enviroment

//        WebDriver driver=new RemoteWebDriver();

        //eighth way always recommended

        WebDriver driver=new ChromeDriver();


        //NOTE: all the implementation of web driver are done in remote Webdriver do remoteWebdriver and Webdriver are highly recommended
        //all the implementation of the webdriver interface are done in remotewebdriver class











    }
}
