package april8th2025ShadowDom;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;

public class ShadowDom_complicated {
    public static void main(String[] args) {

        BrowserUtils.killExistingBrowsers();
        WebDriver driver=BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver, elementUtils);

        driver.get("chrome://downloads/");

        WebElement search_btn_txt=(WebElement) ((JavascriptExecutor)driver).executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('cr-toolbar').shadowRoot.querySelector('#centeredContent > cr-toolbar-search-field').shadowRoot.querySelector('#content > #searchTerm > Input')");

        search_btn_txt.sendKeys("coffee roast");
        PathUtils.applySleep(500);

        driver.quit();


    }
}
