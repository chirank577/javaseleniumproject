package frameworks;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
public class ElementUtils {


         WebDriver driver;

        public  WebElement findElement(By by)
        {
            try
            {return driver.findElement(by);}

            catch (StaleElementReferenceException s1)
            {
                throw new GenericExceptions("Element is stale, kindly check it");
            }
            catch (NoSuchElementException e1)
            {
               throw new GenericExceptions("Element is not found for the given Locator"+by);

            }
        }

    public WebElement findElement(By by,String labelName)
    {
        try
        {
            return driver.findElement(by);
        }
        catch (StaleElementReferenceException s1)
        {
            throw new GenericExceptions("Element is stale "+labelName+" kindly check it");
        }
    }


    public List<WebElement> findElements(By by)
    {
            return driver.findElements(by);
    }

    public List<WebElement> findElements(By by,String labelName)
    {
        try
        {
            return driver.findElements(by);
        }
        catch (NoSuchElementException e4){
            throw new GenericExceptions("Element is not found for the given locator" +labelName );
        }
        catch (StaleElementReferenceException s1)
        {
            throw new GenericExceptions("Element is stale "+labelName+" kindly check it");
        }
    }

    public List<WebElement> findElements(By by, int time, String labelName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

            List<WebElement> elements = driver.findElements(by);
            if (elements.isEmpty()) {
                throw new GenericExceptions("No elements found for locator: " + labelName);
            }
            return elements;

        } catch (NoSuchElementException e) {
            throw new GenericExceptions("Element not found for locator: " + labelName);
        } catch (StaleElementReferenceException e) {
            throw new GenericExceptions("Stale element error: " + labelName);
        } catch (TimeoutException e) {
            throw new GenericExceptions("Timed out after waiting " + time + " seconds for: " + labelName);
        }
    }


    public  WebElement findElement(By by, int time, String labelName)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (NoSuchElementException e2){
            throw new GenericExceptions("Element is not found for the given locator "+labelName);
        }
        catch (TimeoutException e3)
        {
            throw new GenericExceptions("Timed out waiting for element: " + labelName);
        }
    }

    public  List<WebElement> findElements(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
