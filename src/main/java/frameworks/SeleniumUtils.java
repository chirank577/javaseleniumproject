package frameworks;

import lombok.AllArgsConstructor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor // based on the variables declared, it will create a parameterized constructor during the execution time
public class SeleniumUtils {

    WebDriver driver;
    ElementUtils elementUtils;
//    public  SeleniumUtils(WebDriver driver){
//        this.driver=driver;
//    }
    public  void clickOnElement(WebElement element, String labelName)
    {
        try
        {if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.click();}

        catch (ElementNotInteractableException e2)
        {
            throw new GenericExceptions("Element is not interactable for "+ labelName+" please check it ");
        }
    }

    public  void clickOnElement(By by, String labelName)
    {
        try
        {WebElement element=elementUtils.findElement(by,labelName);
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.click();}

        catch (ElementNotInteractableException e2)
        {
            throw new GenericExceptions("Element is not interactable for "+ labelName+" please check it ");
        }
        catch (StaleElementReferenceException s1)
        {
            throw new GenericExceptions("Your page refreshed"+labelName+" Stale");
        }
    }

    public  void enterData(WebElement element, String data, String labelName)
    {
        if(element==null)
            throw new RuntimeException("Unable to find the element for "+labelName);
        element.sendKeys(data);

    }

    public void enterData(WebElement element, String value, int timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);

    }

    public String getElementText(WebElement element)
    {
        if(element==null)
            throw new GenericExceptions("Unable to find the element for ");
        return element.getText();

    }

    public String getElementText(By by)
    {

        WebElement element=elementUtils.findElement(by);
        if(element==null)
            throw new GenericExceptions("Unable to find the element for ");
        return element.getText();



    }
    public String getElementText(By by,int time)
    {
        WebElement element=elementUtils.findElement(by,time);
        if(element==null)
            throw new GenericExceptions("Unable to find the element for ");
        return element.getText();

    }


    public String getElementText(By by, String labelName)
    {
        WebElement element=elementUtils.findElement(by);
        if(element==null)
            throw new GenericExceptions("Unable to find the element for "+labelName);
        return element.getText();

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

        if(url.isBlank() || url.isEmpty())

            throw new GenericExceptions("Given URL is blank or empty");
        else if (!url.contains("https"))
            throw new GenericExceptions("Given URL does not contain https:");

        else if (!url.startsWith("https"))
        throw new GenericExceptions("Given URL does not start with https:");


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


    public Optional<Alert> checkIfAlertIsPresent(int sec)
    {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            //Optional.ofNullable --> check if the given object is returning null or not
            return Optional.ofNullable(wait.until(ExpectedConditions.alertIsPresent()));
        }
        catch (TimeoutException t1)
        {
            throw new GenericExceptions("Alert is not present");
        }
    }
    public void acceptAlert()
    {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> alert.accept(),()->{
            throw new GenericExceptions("Alert is not present");
        });
    }
    public void dismissAlerts() {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> alert.dismiss(), () -> {
            throw new GenericExceptions("Alert is not present");
        });
    }
    public void enterDataInAlert(String data) {
        checkIfAlertIsPresent(5).ifPresentOrElse(alert -> {
            alert.sendKeys(data);
            alert.accept();
        }, () -> {
            throw new GenericExceptions("Alert is not present");
        });
    }
    public String getAlertText()
    {
        return checkIfAlertIsPresent(5).map(Alert::getText)
                .orElseThrow(()-> new GenericExceptions("Alert is not resent"));
    }

    public Alert checkIfAlertIsPresentMyMethod(int sec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            return null;
        }
    }

    // Accepts the alert
    public void acceptAlertMyMethod() {
        Alert alert = checkIfAlertIsPresentMyMethod(5);
        if (alert != null) {
            alert.accept();
        } else {
            throw new RuntimeException("Alert is not present");
        }
    }

    // Dismisses the alert
    public void dismissAlert() {
        Alert alert = checkIfAlertIsPresentMyMethod(5);
        if (alert != null) {
            alert.dismiss();
        } else {
            throw new RuntimeException("Alert is not present");
        }
    }

    // Enters data into alert input box and accepts it
    public void enterDataInAlertMyMethod(String data) {
        Alert alert = checkIfAlertIsPresentMyMethod(5);
        if (alert != null) {
            alert.sendKeys(data);
            alert.accept();
        } else {
            throw new RuntimeException("Alert is not present");
        }
    }
    public String getAlertTextMyMethod() {
        Alert alert = checkIfAlertIsPresentMyMethod(5);
        if (alert != null) {
            return alert.getText();
        } else {
            throw new RuntimeException("Alert is not present");
        }
    }

    public void performMouseHover(WebElement element)
    {
        Actions a1=new Actions(driver);
        a1.moveToElement(element).build().perform();
    }
    public void dragAndDropAction(WebElement source,WebElement destination)
    {
        Actions a1=new Actions(driver);
        a1.pause(3000).dragAndDrop(source, destination).build().perform();
    }
    public void performMouseHover(By by)
    {
        WebElement element=elementUtils.findElement(by);
        Actions a1=new Actions(driver);
        a1.moveToElement(element).build().perform();
    }
    public void dragAndDropAction(By source,By destination)
    {
        WebElement sourcePath=elementUtils.findElement(source);
        WebElement destinataionPath=elementUtils.findElement(destination);
        Actions a1=new Actions(driver);
        a1.pause(3000).dragAndDrop(sourcePath, destinataionPath).build().perform();
    }
    public void performMouseHover(By by,int time)
    {
        WebElement element=elementUtils.findElement(by,time);
        Actions a1=new Actions(driver);
        a1.moveToElement(element).build().perform();
    }
    public void dragAndDropAction(By source,By destination,int time)
    {
        WebElement sourcePath=elementUtils.findElement(source,time);
        WebElement destinataionPath=elementUtils.findElement(destination,time);
        Actions a1=new Actions(driver);
        a1.pause(3000).dragAndDrop(sourcePath, destinataionPath).build().perform();
    }
    public void performRightClick(WebElement element)
    {
        Actions a1=new Actions(driver);
        a1.pause(3000).contextClick(element).build().perform();
    }

    public void performRightClick(By by)
    {
        WebElement element=elementUtils.findElement(by);
        Actions a1=new Actions(driver);
        a1.pause(3000).contextClick(element).build().perform();
    }
    public void performRightClick(By by,int time)
    {
        WebElement element=elementUtils.findElement(by,time);
        Actions a1=new Actions(driver);
        a1.pause(3000).contextClick(element).build().perform();
    }
    public void doubleClick(WebElement element)
    {
        Actions a1=new Actions(driver);
        a1.pause(3000).doubleClick(element).build().perform();
    }

    public void doubleClick(By by)
    {
        WebElement element=elementUtils.findElement(by);
        Actions a1=new Actions(driver);
        a1.pause(3000).doubleClick(element).build().perform();
    }
    public void doubleClick(By by,int time)
    {
        WebElement element=elementUtils.findElement(by,time);
        Actions a1=new Actions(driver);
        a1.pause(3000).doubleClick(element).build().perform();
    }
    public void switchToFrame(String nameOrID)
    {
        try
        {
            driver.switchTo().frame(nameOrID);
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+nameOrID);
        }

    }
    public void switchToFrame(WebElement element, String labelName)
    {
        try
        {
            driver.switchTo().frame(element);
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+labelName);
        }

    }

    public void switchToFrame(WebElement element, String labelName, int time)
    {
        try
        {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
            Optional.ofNullable(wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(element))))
                    .orElseThrow(()-> new GenericExceptions("Unable to switch to the frmae with Name or ID" +labelName));
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+labelName);
        }

    }
    public void switchToFrame(By  by, String labelName)
    {
        WebElement element=elementUtils.findElement(by);
        try
        {
            driver.switchTo().frame(element);
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+labelName);
        }

    }
    public void switchToFrame(By  by, String labelName, int time)
    {
        WebElement element=elementUtils.findElement(by);
        try
        {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
            Optional.ofNullable(wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(element))))
                    .orElseThrow(()-> new GenericExceptions("Unable to switch to the frmae with Name or ID" +labelName));

        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+labelName);
        }

    }


    public void switchToFrame(String nameOrID, int time)
    {
        try
        {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
            Optional.ofNullable(wait.until((ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID))))
                    .orElseThrow(()-> new GenericExceptions("Unable to switch to the frmae with Name or ID" +nameOrID));
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+nameOrID);
        }

    }
    public void switchToParentFrame()
    {
        driver.switchTo().parentFrame();
    }
    public void switchOutOFAllFrame()
    {
        driver.switchTo().defaultContent();
    }

    public void switchToFrameByIndex(int index)
    {
        try
        {
            driver.switchTo().frame(index);
        }
        catch (NoSuchElementException e1)
        {
            throw new GenericExceptions("Unable to switch to the frmae with Name or ID"+index);
        }
    }

    public void selectValueFromDropDown(WebElement element, String option, String labelName)
    {
        Select s1=new Select(element);
        if(option.isBlank() || option.isEmpty())
        {
            List<WebElement> options=s1.getOptions();
            //ThreadLocalRandom.current().nextInt(0, options.size()-1) --> This is a function we select a random number between 0, options.size()-1
            s1.selectByIndex(ThreadLocalRandom.current().nextInt(0, options.size()-1));
        }

        else
        {
            try
            {
                s1.selectByVisibleText(option);
            }

            catch (NoSuchElementException r5)
            {
                try
                {
                    s1.selectByContainsVisibleText(option);
                }

                catch (NoSuchElementException r6)
                {
                    try
                    {
                        s1.selectByValue(option);
                    }

                    catch (NoSuchElementException r7)
                    {
                        try
                        {
                            s1.selectByIndex(Integer.parseInt(option));
                        }

                        catch (NoSuchElementException r8)
                        {
                            throw new GenericExceptions("Unable to select the value from the dropdown for "+labelName);
                        }

                    }
                }
            }
        }
    }

    public void selectValueFromDropDown(By by, String option, String labelName)
    {
        WebElement element=elementUtils.findElement(by);
        Select s1=new Select(element);
        if(option.isBlank() || option.isEmpty())
        {
            List<WebElement> options=s1.getOptions();
            //ThreadLocalRandom.current().nextInt(0, options.size()-1) --> This is a function we select a random number between 0, options.size()-1
            s1.selectByIndex(ThreadLocalRandom.current().nextInt(0, options.size()-1));
        }

        else
        {
            try
            {
                s1.selectByVisibleText(option);
            }

            catch (NoSuchElementException r5)
            {
                try
                {
                    s1.selectByContainsVisibleText(option);
                }

                catch (NoSuchElementException r6)
                {
                    try
                    {
                        s1.selectByValue(option);
                    }

                    catch (NoSuchElementException r7)
                    {
                        try
                        {
                            s1.selectByIndex(Integer.parseInt(option));
                        }

                        catch (NoSuchElementException r8)
                        {
                            throw new GenericExceptions("Unable to select the value from the dropdown for "+labelName);
                        }

                    }
                }
            }
        }
    }


}
