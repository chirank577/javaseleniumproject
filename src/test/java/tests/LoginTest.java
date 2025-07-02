package tests;

import dataProviders.Login_DataProvider;
import frameworks.PathUtils;
import org.testng.annotations.Test;
import pages.LoginPages;

import java.util.Map;

public class LoginTest extends TESTNGBase{


    @Test(description = "Performing Login Scenarios", dataProvider = "testDataExecution", dataProviderClass = Login_DataProvider.class)
    public void performLogin(Map<String ,String > loginData)
    {
        LoginPages loginPages=new LoginPages();

        loginPages.enterUserName(loginData.get("UserName"));
        loginPages.enterPassword(loginData.get("Password"));
        loginPages.clickOnLogin();
    }
}
