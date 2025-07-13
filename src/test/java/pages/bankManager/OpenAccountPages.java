package pages.bankManager;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class OpenAccountPages extends ReusableLibrary {
    private By ddl_Customer= By.cssSelector("#userSelect");
    private By ddl_Currency= By.cssSelector("#currency");
    private By btn_Process=By.xpath("//button[text()='Process']");

    /************************************************************************************************************************/

    public void selectCustomerName(String customerName){
        seleniumUtils.selectValueFromDropDown(ddl_Customer,customerName,10,"Customer Name");
    }
    public void selectCurrency(String currency){
        seleniumUtils.selectValueFromDropDown(ddl_Currency,currency,10,"Currency");
        if(seleniumUtils.getSelectedValueFromDropDown(ddl_Currency).contains("Currency"))//If the dropdown is selecting a default value instead of other option then select the currency again
            selectCurrency(currency);

    }
    public void clickOnProcess(){
        seleniumUtils.clickOnElement(btn_Process,"Process Button");
    }

}
