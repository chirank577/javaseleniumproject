package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class SeleniumUtils {

    WebDriver driver;
    public  SeleniumUtils(WebDriver driver){
        this.driver=driver;
    }
    public  void clickOnElement(WebElement element, String labelName)
    {
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.click();
    }

    public  void enterData(WebElement element, String data, String labelName)
    {
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.sendKeys(data);

    }


    public  void closeRespectiveTaborWindow(String urlOrTitle) throws InterruptedException {
        Set<String> handles=driver.getWindowHandles();

        for(String handle : handles)
        {
            driver.switchTo().window(handle);

            if(driver.getCurrentUrl().contains(urlOrTitle) || driver.getTitle().contains(urlOrTitle))
            {
                driver.close();
            }
            Thread.sleep(1000);
        }
    }

    public  void switchToAllTheTabsAndWindow() throws InterruptedException{
        Set<String> handles=driver.getWindowHandles();

        for(String handle : handles)
        {
            driver.switchTo().window(handle);
            Thread.sleep(1000);
        }
    }

    public  String launchApps(String url) {

        driver.get(url);
        driver.manage().window().maximize();

        return driver.getWindowHandle();
    }

    public  String createNewTabAndLaunchApp(String url) {

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);

        return driver.getWindowHandle();
    }
    public  String createNewWindowAndLaunchApps(String url)
    {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
        return driver.getWindowHandle();
    }
}
