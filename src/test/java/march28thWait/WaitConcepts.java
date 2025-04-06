package march28thWait;

import frameworks.BrowserUtils;
import frameworks.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitConcepts {

    public static void main(String[] args) {
        //wait:
        //1. static wait--> Thread.sleep(2000);
        //2. Dynamic wait --> Implicit wait, Explicity wait, fluent wait;

        BrowserUtils.killExistingBrowsers();

        RemoteWebDriver driver=new ChromeDriver();
        System.out.println(driver.getCapabilities());


        //default wait time of selenium
        //implicit wait time -0s
        //Pageload Timeout- 300sec
        //Script rimeout -30 sex

        //Implicit wait;
        //if the element is not found immediately, then it will wait for stipulated for the element to be visible or loaded
        //it is applied at a driver /global level


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.target.com");

       WebElement n1= driver.findElement(By.cssSelector("a[aria-label='pickup and delivery']"));



        //Explicit WAIt:
        //We are here to wait for a stipulated amount of time until the condition is satisfied
        //we have a lot of predefined coditons in the selenium library

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(n1)).click();

        //if we use a combination of implicit and explicit wait:
        //Total wait time --> Implicit+explicit wait time
        //Sometimes the waiting mechanism wil kick into overdriver
        driver.quit();

        //Explicit wait (applied at a element level)
        //gives you the ability to apply different types of waits for different elements by maintaining different times

        //what happens when we use the combination of imlicit and explicit wait together??
        //Total time taken will be: Implicit wait + explicit wait
        //Sometimes the wait mechanism will kick into overdrive

        //Standard practice that we need to follow is that we have to apply either of the waits not a combination of waits
        //Explicit wait is used most of the time rather than implicit wait



    }
}
