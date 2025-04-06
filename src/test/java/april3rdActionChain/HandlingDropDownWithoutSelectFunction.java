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

import java.util.List;

public class HandlingDropDownWithoutSelectFunction {
    public static void main(String[] args) {
        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        ElementUtils elementUtils=new ElementUtils(driver);
        SeleniumUtils seleniumUtils=new SeleniumUtils(driver,elementUtils);
        seleniumUtils.launchApps("https://demo.automationtesting.in/Register.html");

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)");

         seleniumUtils.clickOnElement(By.xpath("//div[@id='msdd']"),"dropdown");

         List <WebElement> languageList=elementUtils.findElements(By.xpath("//ul/following::li[@class='ng-scope']"),10);
//        List <WebElement> languageList=elementUtils.findElements(By.xpath("//label[text()='Languages']/follwoing::multi-select/div[contains@style,'block')"),10);

        System.out.println(languageList.size());

        //selecting only one option from the dropdown
         languageList.stream().filter(s->s.getText().equalsIgnoreCase("Arabic"))//filtering the options based on the language
                 //.findany() means checks if there is any checks if any opton with Italian. if it is present then click on the element
                         .findAny().ifPresent(s-> seleniumUtils.clickOnElement(s,"Arabic"));

         /*for (WebElement language : languageList) {
    if (language.getText().equalsIgnoreCase("Hindi")) {
        seleniumUtils.clickOnElement(language, "Hindi");
        break; // stop once found
    }
}
*/       languageList.stream().filter(s->s.getText().equalsIgnoreCase("Arabic") || s.getText().equalsIgnoreCase("Hindi"))//filtering the options based on the language
                //.findany() means checks if there is any checks if any opton with Italian. if it is present then click on the element
                .findAny().ifPresent(s-> seleniumUtils.clickOnElement(s,"Hindi"));
        languageList.stream().filter(s->s.getText().equalsIgnoreCase("Italian") || s.getText().equalsIgnoreCase("English"))//filtering the options based on the language
                //.findany() means checks if there is any checks if any opton with Italian. if it is present then click on the element
                .forEach(s-> seleniumUtils.clickOnElement(s,s.getText()));//clicking on the filtered option

        seleniumUtils.launchApps("https://demo.automationtesting.in/Register.html");
        seleniumUtils.clickOnElement(By.xpath("//div[@id='msdd']"),"dropdown");


        List <WebElement> languageListlanguageList=elementUtils.findElements(By.xpath("//ul/following::li[@class='ng-scope']"),10);

        languageListlanguageList.stream().forEach(s->
        {
            PathUtils.applySleep(1000);
            seleniumUtils.clickOnElement(By.linkText(s.getText()), seleniumUtils.getElementText(s));
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
        });

        PathUtils.applySleep(3000);

        driver.quit();


    }
}
