package april9th2025;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class NewVersionOfRelativeLocators {
    public static void main(String[] args) {

        BrowserUtils.killExistingBrowsers();

        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver, elementUtils);
        seleniumUtils.launchApps("https://demo.automationtesting.in/Register.html");

        driver.manage().window().fullscreen();//Switches to full screen mode

        WebElement  element=driver.findElement(with(By.xpath("//input[@ng-model='Phone']")).below(By.xpath("//input[@ng-model='EmailAdress']")));
        element.sendKeys("hello");
        driver.quit();

    }
}
