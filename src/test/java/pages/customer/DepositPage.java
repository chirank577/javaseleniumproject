package pages.customer;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class DepositPage extends ReusableLibrary {

    private By deposit_Amount= By.xpath("//input[@placeholder='amount']");
    private By ddl_SelectAccount=By.cssSelector("#accountSelect");
    private By btn_Deposit=By.xpath("//button[text()='Deposit']");

    /**********************************************************************************************************************/

    public void amountDeposit(String amount){
        seleniumUtils.enterData(deposit_Amount,amount,"Deposit Amount");
    }
    public void selectAccountType(String account){
        seleniumUtils.selectValueFromDropDown(ddl_SelectAccount,account,"Account");
    }
    public void clickDeposit(){
        seleniumUtils.clickOnElement(btn_Deposit,"Deposit");
    }
}
