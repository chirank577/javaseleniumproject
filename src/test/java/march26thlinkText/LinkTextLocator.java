package march26thlinkText;

import frameworks.BrowserUtils;
import frameworks.PathUtils;
import frameworks.Reports;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.*;

import java.io.File;
import java.nio.file.Files;


public class LinkTextLocator {

    static WebDriver driver;
    @SneakyThrows
    public static void main(String[] args) {

        BrowserUtils.killExistingBrowsers();
        driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver);
        seleniumUtils.launchApps("https://www.cricbuzz.com");

        //Linktext:
        //it will work when rhe text is surrounded by the cnhor tags
        //Ex. <a>Hello</a>
        //Ex. <a> <span> World</span><a>// it will not work in this case since it is surrounded by span

        WebElement lnk=driver.findElement(By.linkText("Teams"));
        seleniumUtils.clickOnElement(lnk,"Teams");

        WebElement lnkAustralia=driver.findElement(By.linkText("Australia"));
        seleniumUtils.clickOnElement(lnkAustralia,"Australia");

        WebElement lnkPlayers=driver.findElement(By.linkText("Players"));
        seleniumUtils.clickOnElement(lnkPlayers,"Players");

        //syntax of finding the element
        //the rigth use case is that if the link test is huge, then we go for the partial value to find the particular element
        //and perform the action
        WebElement lnkLatestNews=driver.findElement(By.partialLinkText("Hasaranga give Royals"));
        seleniumUtils.clickOnElement(lnkLatestNews,"Hasaranga give Royals");

        WebElement lnkForDC=driver.findElement(By.partialLinkText("DC Won"));
        seleniumUtils.clickOnElement(lnkForDC,"SRH vs DC - DC Won");

        Reports.captureScreenShot(driver);

        driver.quit();




    }
    }
