package april7th2025RelativeLocators;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HandleCalendar {
    public static void main(String[] args) {


        WebDriver driver = BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils = new ElementUtils(driver);
        SeleniumUtils seleniumUtils = new SeleniumUtils(driver, elementUtils);
        seleniumUtils.launchApps("https://demoqa.com/automation-practice-form");

//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,70)");

        seleniumUtils.clickOnElement(By.cssSelector("#dateOfBirthInput"),"Date of birth");

        String date="07-March-2000";

        String month=date.split("-")[1];
        String year=date.split("-")[2];
        String day=date.split("-")[0];



        seleniumUtils.selectValueFromDropDown(By.xpath("//select[contains(@class,'month-select')]"),month,"month");
        seleniumUtils.selectValueFromDropDown(By.xpath("//select[contains(@class,'year-select')]"),year,"year");

//        seleniumUtils.clickOnElement(By.xpath("//div[contains(@class,'datepicker__day--') and text()=7 and contains(@aria-label,'April')]"));
        seleniumUtils.clickOnElement(By.xpath("//div[contains(@class,'datepicker__day--') and text()="+day+" and contains(@aria-label,'"+month+"')]"),"Date");

        driver.quit();


    }

}
