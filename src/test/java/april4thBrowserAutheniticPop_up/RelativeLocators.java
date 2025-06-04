package april4thBrowserAutheniticPop_up;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {
    public static void main(String[] args) {

        //relative locators are present since selenium 4
        //Relative locators are used to find elements relative  to other elements on the page.
        BrowserUtils.killExistingBrowsers();
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);
        seleniumUtils.launchApps("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        WebElement txt_email=driver.findElement(By.xpath("//input[@id='email']"));

        RelativeLocator.RelativeBy by=RelativeLocator.with(By.name("mobile"))
                .below(txt_email);
        driver.findElement(by).sendKeys("2345678");
        PathUtils.applySleep(3000);

        driver.quit();

    }
}
