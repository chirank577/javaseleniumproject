package march25thCloseAndQuit;

import frameworks.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SeleniumLocators {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Locator --> Means of locating the required thing
//        driver =new ChromeDriver();
        driver= BrowserUtils.getDriver("chrome");





        //Locators are useful to identify the button, radio button, text box etc in the given web page

        //In Selenium automation, we refer any button, radio button, checkbox, etc.... as element(s)

        //Different types of locators:
        //1. ID --> It is always unique in the given webpage
        //2. NAME
        //3. LINKTEXT
        //4. PARTIALLINKTEXT
        //5. TAGNAME
        //6. CLASS
        //7. XPATH
        //8. CSS
        //9. Relative Locators (From Selenium 4)

        //Syntax of finding the element:
        //driver.findElement();

        //driver ---> Represents the browser
        //.findElement() --> Helps us in finding the right element across the web page

        //Syntax of finding the element on the basis of ID:
        //driver.findElement(By.id(value));
        launchApps("https://practicetestautomation.com/practice-test-login/");

        WebElement userName=driver.findElement(By.id("username"));
        //userName.sendKeys("student");
        enterData(userName,"student","username");

        WebElement password=driver.findElement(By.id("password"));
        //password.sendKeys("Password123");
        enterData(password,"Password123","password");

        Thread.sleep(1000);

        //compound classes are not supported by selenium


        WebElement click_Login=driver.findElement(By.className("btn"));//class attribute
        clickOnElement(click_Login,"btn");
        Thread.sleep(1000);

        driver.quit();



//
    }

    public static void clickOnElement(WebElement element, String labelName)
    {
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.click();
    }

    public static void enterData(WebElement element, String data, String labelName)
    {
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.sendKeys(data);

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
        driver.manage().window().maximize();

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
