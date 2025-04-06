package april2ndActionChain;

import frameworks.*;
import frameworks.constants.BrowsersTypes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class PerfromMouseHover {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());

        ElementUtils elementUtils = new ElementUtils(driver);
        Reports reports = new Reports(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementUtils);
        seleniumUtils.launchApps("https://the-internet.herokuapp.com/hovers");

        //driver.findelements returns the list of webelements for the given locator
        List<WebElement> elements = elementUtils.findElements(By.xpath("//img[@alt='User Avatar']"),5);

        //actions library helps us in performing some advanced actions onto the browser
        Actions a1 = new Actions(driver);

        for (WebElement e : elements) {
            seleniumUtils.performMouseHover(e);

            reports.captureScreenShot();}



//        for(int i=0;i<elements.size();i++)
//        {
//            a1.moveToElement(elements.get(i)).build().perform();
//            Thread.sleep(1000);
//
//            reports.captureScreenShot();
//        }


//    reports.captureScreenShot();
            driver.quit();


        }
    }
