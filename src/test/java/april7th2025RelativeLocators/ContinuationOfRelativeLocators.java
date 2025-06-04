package april7th2025RelativeLocators;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;


public class ContinuationOfRelativeLocators {
    public static void main(String[] args) {

        BrowserUtils.killExistingBrowsers();
        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());

        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);
        seleniumUtils.launchApps("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        //above example
        RelativeBy txt_MobileNumber=with(By.cssSelector("#mobile")).above(By.xpath("//input[@id='subjects']"));
        driver.findElement(txt_MobileNumber).sendKeys("677363");

        //below
        RelativeBy txt_subject=with(By.cssSelector("#subjects")).below(By.cssSelector("#dob"));

        driver.findElement(txt_subject).sendKeys("verification");


        //left of
        RelativeBy Widget=with(By.xpath("//button[normalize-space(text())='Widgets']")).toLeftOf(By.xpath("//input[@id='mobile']"));

        driver.findElement(Widget).click();


        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        //right
        RelativeBy select_City=with(By.id("city")).toRightOf(By.id("state"));

        Select s1=new Select(driver.findElement(select_City));
        s1.selectByVisibleText("Agra");

        PathUtils.applySleep(2000);




        driver.quit();



    }
}
