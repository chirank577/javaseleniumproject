package pages.bankManager;

import frameworks.ReusableLibrary;
import org.openqa.selenium.By;

public class CustomerPages extends ReusableLibrary {
    private By searchForCustomerName= By.xpath("//input[@placeholder='Search Customer']");
    private By fld_RowsOfData=By.xpath("//table/descendant::tbody/tr");

    /*************************************************************************************************/

    public void enterCustomerName(String customerName){
        seleniumUtils.enterData(searchForCustomerName,customerName,20,"Customer Name");
    }

    public boolean checkIfRowsOfDataArePresent(){
        return elementUtils.findElements(fld_RowsOfData).size()>0;
    }

}
