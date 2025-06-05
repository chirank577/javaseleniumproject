package april8th2025ShadowDom;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDom {
    public static void main(String[] args) {

        //Inside a Shadow DOM, xpaths will not work, only CSS Selectors will work

        BrowserUtils.killExistingBrowsers();

        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());

        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);

        seleniumUtils.launchApps("https://selectorshub.com/shadow-dom-in-iframe/");

        seleniumUtils.switchToFrame("pact",5);
        PathUtils.applySleep(3000);

        WebElement txt_TeaBox=(WebElement)((JavascriptExecutor)driver).executeScript("return document.getElementById('snacktime').shadowRoot.querySelector('.uojl >.uoj > input')");

        seleniumUtils.enterData(txt_TeaBox,"Tea Box",500);
    }
}
