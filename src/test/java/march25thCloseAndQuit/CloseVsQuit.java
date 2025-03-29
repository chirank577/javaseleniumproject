package march25thCloseAndQuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CloseVsQuit {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //whenever we create a driver objects, a session ID is created
        driver =new ChromeDriver();
        System.out.println(driver);

        //maximize the browser
        driver.manage().window().maximize();

        //deletes all the existing cookies that are present in the browser
        driver.manage().deleteAllCookies();

        launchApps("https://www.facebook.com");
        createNewTabAndLaunchApp("https://www.target.com");
        createNewTabAndLaunchApp("https://www.instagram.com");
        createNewWindowAndLaunchApps("https://www.cricbuzz.com");
        createNewWindowAndLaunchApps("https://www.flipkart.com");

       switchToAllTheTabsAndWindow();
//        Set<String> handles=driver.getWindowHandles();
//
//        for(String handle : handles)
//        {
//            driver.switchTo().window(handle);
//
//            if(driver.getCurrentUrl().contains("target"))//close that particular tab/window if the URL contains snapchat
//            {
//                driver.close();//session id is set to null
//                break;}
//
//        }
        closeRespectiveTaborWindow("Target");
        Thread.sleep(1000);
        driver.quit();

        //after using driver.quit(), the subsequent selenium code will throw an error called as NoSuchSessionException as the SessionID is null
       driver.switchTo().newWindow(WindowType.WINDOW);

    }

    public static void closeRespectiveTaborWindow(String urlOrTitle) throws InterruptedException {
        Set<String> handles=driver.getWindowHandles();

        for(String handle : handles)
        {
            driver.switchTo().window(handle);

            if(driver.getCurrentUrl().contains(urlOrTitle) || driver.getTitle().contains(urlOrTitle))
            {
                driver.close();
            }
            Thread.sleep(1000);
        }
    }

    public static void switchToAllTheTabsAndWindow() throws InterruptedException{
        Set<String> handles=driver.getWindowHandles();

        for(String handle : handles)
        {
            driver.switchTo().window(handle);
            Thread.sleep(1000);
        }
    }

    public static String launchApps(String url) {

        driver.get(url);

        return driver.getWindowHandle();
    }

    public static String createNewTabAndLaunchApp(String url) {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);

        return driver.getWindowHandle();
    }
    public static String createNewWindowAndLaunchApps(String url)
    {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
        return driver.getWindowHandle();
    }
}
