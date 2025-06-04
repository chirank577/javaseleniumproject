package april4thBrowserAutheniticPop_up;

import frameworks.*;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JSFunctions {
    public static void main(String [] args)
    {

        //JS functions is always used to perform the actions which are not possible using selenium
        BrowserUtils.killExistingBrowsers();
        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
//        ElementUtils elementUtils=new ElementUtils(driver);
//        SeleniumUtils seleniumUtils =new SeleniumUtils(driver, elementUtils);
//        seleniumUtils.launchApps("")

        //Generate Alerts or pop ups
        ((JavascriptExecutor)driver).executeScript("alert('Hello World')");
        driver.switchTo().alert().accept();

        //Launch the application
        ((JavascriptExecutor)driver).executeScript("window.location='https://www.cricbuzz.com';");


        //highlight the textbox
        WebElement element= driver.findElement(By.xpath("//div[text()=' We have updated our ']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'",element);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
       // Reports reports=new Reports(driver);
       // reports.captureScreenShot();

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");

        PathUtils.applySleep(3000);
        //scroll the page to top
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-document.body.scrollHeight)");

        PathUtils.applySleep(3000);

        //regular java script code
        String jscode= """
                var a=10;
                var b=20;
                console.log(a+b);
                """;
        ((JavascriptExecutor)driver).executeScript(jscode);

        //open an application in new tab

        ((JavascriptExecutor)driver).executeScript("window.open('https://practicetestautomation.com/practice-test-login/','_blank');");
        //switching to the new window
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // or the last one

// Now find the element again fresh on new page
        WebElement searchBox = driver.findElement(By.id("username"));
        searchBox.sendKeys("chiru");
        PathUtils.applySleep(3000);

        //Zooming Out
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%'");

        //Zooming In
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='250%'");

        //Zooming to Default
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='100%'");

        //Zooming to a specific element
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.zoom='400%'",driver.findElement(By.id("username")));

       PathUtils.applySleep(3000);

        driver.quit();
    }
}
