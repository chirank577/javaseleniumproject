package pages.customer;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class WithdrawalPage extends ReusableLibrary {

    private By withdrawal_Amount= By.xpath("//input[@placeholder='amount']");
    private By ddl_SelectAccount=By.cssSelector("#accountSelect");
    private By btn_Withdrawal=By.xpath("//button[text()='Withdraw']");

    /**********************************************************************************************************************/

    public void amountWithdrawal(String amount){
        seleniumUtils.enterData(withdrawal_Amount,amount,"Withdrawal Amount");
    }
    public void selectAccountType(String account){
        seleniumUtils.selectValueFromDropDown(ddl_SelectAccount,account,"Account");
    }
    public void clickOnWithdrawal(){
        seleniumUtils.clickOnElement(btn_Withdrawal,"Withdraw");
    }
}
