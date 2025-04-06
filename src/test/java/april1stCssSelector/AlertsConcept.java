package april1stCssSelector;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AlertsConcept {
    @SneakyThrows
    public static void main(String[] args) {
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);

        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);

        seleniumUtils.launchApps("https://practice-automation.com/popups/");

        //syntax of finding an element on the basis of CSS selector:
        //driver.findElement(By.cssSelector(Value));



        By btn_Showalert=By.cssSelector("button[onclick='alertPopup()']");

        WebElement element=elementUtils.findElement(btn_Showalert);
        seleniumUtils.clickOnElement((element),"show");


        driver.switchTo().alert().accept();//accept the popup message
        Thread.sleep(1000);

        seleniumUtils.clickOnElement(By.cssSelector("button[onclick='confirmPopup()']"),"show");
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);

        seleniumUtils.clickOnElement(By.cssSelector("button[onclick='promptPopup()']"),"show");

        //enters the data into pop up
        driver.switchTo().alert().sendKeys("chiru");
        driver.switchTo().alert().accept();
        String result=seleniumUtils.getElementText(By.cssSelector("#promptResult"),"promptResult");
        System.out.println(result);



        driver.quit();



    }
}
