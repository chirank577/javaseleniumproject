package frameworks;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@AllArgsConstructor
public class ElementUtils {


         WebDriver driver;

        public  WebElement findElement(By by)
        {
            return driver.findElement(by);
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
        catch (StaleElementReferenceException s1)
        {
            throw new GenericExceptions("Element is stale "+labelName+" kindly check it");
        }
    }

    public  WebElement findElement(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public  List<WebElement> findElements(By by,int time)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
