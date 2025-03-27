package march25thLaunchingBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.Set;

public class HandlingWindowsAndTabs {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");

        //Syntax of creating a new tab:
        driver.switchTo().newWindow(WindowType.TAB);//SELENIUM 4
        driver.get("https://www.facebook.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.target.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String Youtube=driver.getWindowHandle();


        //syntax to create a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.cricbuzz.com");
        String cricbuzz=driver.getWindowHandle();

        //switches to youtube window
        driver.switchTo().window(Youtube);
        Thread.sleep(4000);

        driver.switchTo().window(cricbuzz);
        Thread.sleep(2000);

        //Easiest way to switch accross all the tabs/windows that is launched
        Set<String> handles=driver.getWindowHandles();//returns the set of all the unique reference number for all the tabs or window launched

        for(String handle:handles)
        {
            driver.switchTo().window(handle);
            Thread.sleep(2000);

            //prints the current url of the application that is launched
            System.out.println(driver.getCurrentUrl());

            //prints the title of the page
            System.out.println(driver.getTitle());
        }



    }
}
