package april4thBrowserAutheniticPop_up;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlingFrames {
    public static void main(String[] args) {
        //Frames are nothing but partition of the web page

        BrowserUtils.killExistingBrowsers();
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver, elementUtils);
        seleniumUtils.launchApps("https://the-internet.herokuapp.com/nested_frames");

        //syntax of switching to a frame on the basis of name or id;
        //driver.switch.frame(nameorID)
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");//we can ot move to frme left directly.
        System.out.println(seleniumUtils.getElementText(By.xpath("//body[normalize-space(text())='LEFT']")));
        //switches back to parent frame
        driver.switchTo().parentFrame();//since frame middle is sibling to frame left we eed to go back to frame top n the middle
        driver.switchTo().frame("frame-middle");
        System.out.println(seleniumUtils.getElementText(By.xpath("//div[text()='MIDDLE']")));
        driver.switchTo().parentFrame();//since frame middle is sibling to frame left we eed to go back to frame top n the middle
        driver.switchTo().frame("frame-right");
        System.out.println(seleniumUtils.getElementText(By.xpath("//body[normalize-space(text())='RIGHT']")));

driver.switchTo().defaultContent();//switches out of all frames and comes to the default content
        driver.switchTo().frame("frame-bottom");
        System.out.println(seleniumUtils.getElementText(By.xpath("//body[normalize-space(text())='BOTTOM']")));



        driver.quit();


    }
}
