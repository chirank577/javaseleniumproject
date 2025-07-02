package pages;

import frameworks.PathUtils;
import frameworks.ReusableLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPages extends ReusableLibrary {

    //page object model is designed pattern, where we maintain all the locators with respect to that page
    //Then we write the function/ actions that we need to perform on that particular web element

    private By txt_UserName= By.id("username");
    private By txt_Password=By.id("password");
    private By btn_Login=By.xpath("//button[text()='Submit']");

    /**************************************************************************************************/

    public void enterUserName(String userName){
        seleniumUtils.enterData(txt_UserName,userName,"Username");
    }
    public void enterPassword(String password){
        seleniumUtils.enterData(txt_Password,password,"Password");
    }

    public void clickOnLogin(){
        seleniumUtils.clickOnElement(btn_Login,"Login");
    }



}
