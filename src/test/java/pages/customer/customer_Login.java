package pages.customer;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class customer_Login extends ReusableLibrary {

    private By ddl_CustomerName= By.cssSelector("#userSelect");
    private By btn_Login=By.xpath("//button[text()='Login']");
    private By btn_Transactions=By.xpath("//button[normalize-space(text())='Transactions']");
    private By btn_Depost=By.xpath("//button[normalize-space(text())='Deposit']");
    private By btn_Withdrawal=By.xpath("//button[normalize-space(text())='Withdrawl']");
    private By btn_Logout=By.xpath("//button[text()='Logout']");
    /********************************************************************************************************************/

    public void selectCustomerName(String customerName)
    {
        seleniumUtils.selectValueFromDropDown(ddl_CustomerName,customerName,"Customer Name");
    }

    public void clickLogin(){
        seleniumUtils.clickOnElement(btn_Login,"Login");
    }
    public void clickOnTransactions(){
        seleniumUtils.clickOnElement(btn_Transactions,"Transactions");
    }
    public void clickOnDeposit(){
        seleniumUtils.clickOnElement(btn_Depost,"Deposit");
    }
    public void clickOnWithdrawal(){
        seleniumUtils.clickOnElement(btn_Withdrawal,"Withdrawal");
    }
    public void clickLogout(){
        seleniumUtils.clickOnElement(btn_Logout,"Logout");
    }
}
