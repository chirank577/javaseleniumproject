package april2ndActionChain;

import frameworks.*;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PerformDragAndDrop {
    public static void main(String[] args) {
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());

        ElementUtils elementUtils=new ElementUtils(driver);
        Reports reports=new Reports(driver);

        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);

        seleniumUtils.launchApps("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement drag= elementUtils.findElement(By.id("column-a"));
        WebElement drop= elementUtils.findElement(By.id("column-b"));

        Actions a1=new Actions(driver);

        seleniumUtils.dragAndDropAction(drag,drop);
        PathUtils.applySleep(3000);
        driver.quit();



    }
}
