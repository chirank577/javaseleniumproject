package april4thBrowserAutheniticPop_up;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

public class HandlingBrowserAuthentication {
    public static void main(String[] args) {
        BrowserUtils.killExistingBrowsers();
        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());

        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver, elementUtils);

        //if Alert is not present the first way to handle this situation is
        //passing the credential in the URL admin:admin@ username and password
         seleniumUtils.launchApps("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Drawback of this approach is: if there are any special character in the username or password, it will not be able to handle
        //passing the credentials in the URL is not a recommended way

        // 2nd way:
        //Using selenium 4 function: HasAuthentication
        ((HasAuthentication)driver).register(UsernameAndPassword.of("admin","admin"));
        seleniumUtils.launchApps("https://the-internet.herokuapp.com/basic_auth");
        System.out.println(seleniumUtils.getElementText(By.tagName("p")));
        PathUtils.applySleep(3000);
        driver.quit();
    }
}
