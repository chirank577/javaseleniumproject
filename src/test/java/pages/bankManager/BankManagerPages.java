package pages.bankManager;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BankManagerPages extends ReusableLibrary {

    private By btn_All_The_Option=By.xpath("//button[contains(@ng-class,'btnClass')]");
    private By btn_Add_Customer= By.xpath("//button[normalize-space(text())='Add Customer']");
    private By btn_Open_Account=By.xpath("//button[normalize-space(text())='Open Account']");
    private By btn_Customer=By.xpath("//button[normalize-space(text())='Customers']");

    /*************************************************************************************************************************************************/
    public boolean checkAllDisplayedButton(){
         List <WebElement> buttons=elementUtils.findElements(btn_All_The_Option, 10,"All Buttons are Displayed");
         if (buttons==null|| buttons.isEmpty())
             return false;

         for(WebElement button:buttons){
             if(!button.isDisplayed()){
                 return false;
             }
         }
         return true;
    }
    public AddCustomersPages clickOnAddCustomer(){
        seleniumUtils.clickOnElement(btn_Add_Customer,10,"Add Customer");
        return new AddCustomersPages();
    }

    public OpenAccountPages clickOnOpenAccount(){
        seleniumUtils.clickOnElement(btn_Open_Account,10,"Open Account");
        return new OpenAccountPages();
    }

    public CustomerPages clickOnCustomers()
    {
        seleniumUtils.clickOnElement(btn_Customer,10,"Customers");
        return new CustomerPages();
    }




}
