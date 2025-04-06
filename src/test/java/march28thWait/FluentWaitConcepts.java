package march28thWait;

import frameworks.BrowserUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaitConcepts {
    public static void main(String[] args) {

        //fluent wait is more advanced verison of explicit wait
        //Fluent wait can be applied for browser level or non browser level
        //Fluent wait given you the ability the customize the polling time(polling time means keep on checking after certain time).

        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        driver.get("https://www.google.com");
        FluentWait<WebDriver> fluentWait=new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .withMessage("Element is not Found");

        fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnI")));
        driver.quit();
    }
}
