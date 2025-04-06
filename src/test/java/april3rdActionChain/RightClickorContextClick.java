package april3rdActionChain;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class RightClickorContextClick {
    public static void main(String[] args) {
        BrowserUtils.killExistingBrowsers();
        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);

        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);
        seleniumUtils.launchApps("https://the-internet.herokuapp.com/context_menu");

        Actions a1=new Actions(driver);
        a1.pause(3000).contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']"))).build().perform();
        seleniumUtils.acceptAlert();
        PathUtils.applySleep(3000);
        driver.quit();

    }

}
