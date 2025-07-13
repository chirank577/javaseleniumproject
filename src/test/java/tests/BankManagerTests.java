package tests;

import com.github.javafaker.Faker;
import com.google.gson.internal.bind.util.ISO8601Utils;
import frameworks.PathUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.bankManager.AddCustomersPages;
import pages.bankManager.BankManagerPages;
import pages.bankManager.CustomerPages;
import pages.bankManager.OpenAccountPages;

import java.util.Optional;

public class BankManagerTests extends TESTNGBase{

    BankManagerPages bankManagerPages;
    AddCustomersPages addCustomersPages;
    OpenAccountPages openAccountPages;
    CustomerPages customerPages;
    Faker faker=new Faker();
    String firstName;

    @Test(description = "Navigating to Bank Manager Login Screen",priority = 1,enabled = false)
    public void navigateToBankManagerLoginScreen(){
        bankManagerPages=homePage.clickOnBankManagerLogin();//Page Chaining

        // we go with the concept of Assertions to validate the test case
        //there are two types of assertion
        //1 soft assertion
        //2 hard assertion --> if the condition is not met then the test case will be failed and execution of test case will be stopped immediately

        boolean result = bankManagerPages.checkAllDisplayedButton();

        System.out.println("Button Display Check Result: " + result);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(bankManagerPages.checkAllDisplayedButton(),"All Buttons in bank manager page are not displayed");
        softAssert.assertAll(); // then it will validate all the assertions at once

    }
    @Test(description = "Adding new customer to the system",priority = 2)
    public void addNewCustomerToSystem(){

            bankManagerPages = homePage.clickOnBankManagerLogin();
            addCustomersPages= bankManagerPages.clickOnAddCustomer();

            firstName=faker.name().firstName();
            addCustomersPages.enterFirstName(firstName);
            addCustomersPages.enterLastName(faker.name().lastName());
            addCustomersPages.enterPostCode(faker.address().zipCode());
            addCustomersPages.addCustomers();

            //before accepting the alerts I want to print the test
        System.out.println(seleniumUtils.getAlertText());

        Assert.assertTrue(seleniumUtils.getAlertText().split(":").length>1,"Alert message is not displayed");
        seleniumUtils.acceptAlert();
    }
    @Test(description = "Opening account for customer",priority =3,dependsOnMethods = "addNewCustomerToSystem")
    public void openAccountForNewCustomers(){

        openAccountPages= bankManagerPages.clickOnOpenAccount();

       openAccountPages.selectCustomerName(firstName);
       openAccountPages.selectCurrency("");
       openAccountPages.clickOnProcess();

        Assert.assertTrue(seleniumUtils.getAlertText().split(":").length>1,"Alert message is not displayed");
        seleniumUtils.acceptAlert();
    }

    @Test(description = "Viewing Customer details",priority =4,dependsOnMethods = "addNewCustomerToSystem")
    public void viewingCustomerDetail(){

        customerPages= bankManagerPages.clickOnCustomers();

        customerPages.enterCustomerName(firstName);
        reports.captureScreenShot();
        Assert.assertTrue(customerPages.checkIfRowsOfDataArePresent(),"No rows of data are found");

    }



}
