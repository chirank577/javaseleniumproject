package pages;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;
import pages.bankManager.BankManagerPages;

public class HomePage extends ReusableLibrary {

    private By btn_Home= By.xpath("//button[contains(@class,'home')]");
    private By btn_Customer_Login=By.xpath("//button [text()='Customer Login']");
    private By btn_Bank_Manager_Login=By.xpath("//button [text()='Bank Manager Login']");
    /******************************************************************************************************************************/

    public void clickOnHome(){
        seleniumUtils.clickOnElement(btn_Home,"Home");
    }
    public void clickOnCustomerLogin(){
        seleniumUtils.clickOnElement(btn_Customer_Login,10,"Customer Login");
    }
    public BankManagerPages clickOnBankManagerLogin(){
        seleniumUtils.clickOnElement(btn_Bank_Manager_Login,5,"Bank Manager Login");
        return new BankManagerPages();
    }
}
