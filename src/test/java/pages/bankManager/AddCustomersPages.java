package pages.bankManager;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class AddCustomersPages extends ReusableLibrary {

    private By txt_firstName= By.xpath("//input[@placeholder='First Name']");
    private By txt_lastName=By.xpath("//input[@placeholder='Last Name']");
    private By txt_postCode=By.xpath("//input[@placeholder='Post Code']");
    private By btn_addCustomer=By.xpath("//button[text()='Add Customer' and @type='submit']");

/************************************************************************************************************************************/

    public void enterFirstName(String firstName) {
        seleniumUtils.enterData(txt_firstName,firstName,5,"First Name");
    }
    public void enterLastName(String lastName) {
        seleniumUtils.enterData(txt_lastName,lastName,5,"Last Name");
    }
    public void enterPostCode(String postCode){
    seleniumUtils.enterData(txt_postCode,postCode,5,"Post Code");
    }
    public AddCustomersPages addCustomers(){
        seleniumUtils.clickOnElement(btn_addCustomer,5,"Add Customer");
        return new AddCustomersPages();
    }
}
