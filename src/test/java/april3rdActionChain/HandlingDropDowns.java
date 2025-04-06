package april3rdActionChain;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingDropDowns {
    public static void main(String[] args) {
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);

        seleniumUtils.launchApps("https://demo.automationtesting.in/Register.html");

        //Scroll Down the page:
        //using JavaScript commands
        //(JavaScriptExecutor)--> Helps us in executing the Javascript commands
        //(JavaScriptExecutor)driver--> helps us in executing the javascript commands onto the browser
        //((JavaScriptExecutor)driver).executeScript()--> Hels us in executing the desired Javascript commands onto the browser

        //scrolling the page vertically down
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");


        WebElement ddl_Skill= elementUtils.findElement(By.xpath("//select[@id='Skills']"));

        Select s1=new Select(ddl_Skill);

        //1. selecting the value from the dropdown on the basis of text;
        s1.selectByVisibleText("Engineering");

        //2. selecting the value from the dropdown on the basis of partial text
        s1.selectByContainsVisibleText("Data");

        //3.selecting the value from the dropdown based on the value attribute

        s1.selectByValue("Troubleshooting");

        //4.selecting the value from the dropdown based on the Index position

        s1.selectByIndex(2);

        //gets the selected option
        System.out.println(s1.getFirstSelectedOption().getText());

        //retruns the list of options that are present in the dorpdown
        //returns a list of webelement

        List<WebElement> optionList=s1.getOptions();
        optionList.stream().map(s->s.getText()).forEach(System.out::println);

        //retruns true if the dropdown allows multiple selection
        //else return false
        System.out.println(s1.isMultiple());

        PathUtils.applySleep(3000);
        driver.quit();



    }
}
