package testNGFundamentals09thApril;

import frameworks.PathUtils;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGAttribute {

    //Testng is a testing framework inspired from junit
    //testng is designed to test all category of tests, unit, functional , end to end, integration etc

    //problem with main method is only one main method can be present in a class
    //whereas with testng we do not need main method and we can have multiple test cases and run it without having main method

    //by default test cases are executed in the acsII order of method names
    //if we want to change the order of the execution we can use the priority attribute
    //priority ranges from -n to n
    //By default the priority test case is zero
    //execution of test cases will happen in the ascending order of the priority


    //description attrbute--> provides a brief information about the test case
    //it is a mandatory attribute not from the progamming persperctive but from the documentation perspective

    //suitname attribute --> represents the name of the suite

    //invocationCount attribute--> Determines how many times a test case should be executed
    //By default it will be 1

    //invocationTimeout attribute --> determines the time limit for the test case to be executed for the number of times
    //InvocationTimeOut will always work in conjuction with invocationCount

    //timeOut attribute--> determines the time limit for the test case to be executed
    //By defaut it will be 0
    // Here we pass the time in milliseconds
    //if the test case is not completed within time limit in that case it will throw a ThreadTimeOutException


    //if enable is true it will execute, if false it won't execute
    //what is the alternate way of skipping the test case execution?? we can use @Ignore as well or enable = flase

    //dependsOnMethods attribute --> It is used to determine the dependency of a test case on another test case
    //If the current test case is dependent on another test case then the dependent test case should be executed first


    //alwaysRun attribute--> It will execute irrespective of the status of the dependent test case

    //expectedException attributes--> It is used to determine the expected exception for a test case
    //if we know that the particular test case is prone to failure, and the dev team informs that we are working on the fix, please do not fail this test case since he is already working on fix
    //then we can use the expectedExecution attribute where it will not fail the test case

    //suppose if the test case is working as expected and we are using expectedException then test case will faild stating that the expected exception is not thrown


    //skipFailedInvocation--> it is used to skip the failed test cases
    // if the test case is having invocation count more than 1, and if the test case fails in the first run, then it will skip the remaining runs
    //it is used in conjuction with invocationCount
    //By default it will be false
    //


    @Ignore
    @Test(priority = 1, description = "sample test case one", suiteName = "Smoke",timeOut = 500, enabled = false)//represent a test case
    public void sampleTestOne()
    {
        PathUtils.applySleep(1000);
        System.out.println("this is a sample test case one ");
    }

    //if the execution is not completed within the time limit then it will throw exception
    @Test(priority = 3,description = "sample test case two", suiteName = "Sanity", invocationCount = 3, invocationTimeOut = 4000, dependsOnMethods ="loginToApplication", alwaysRun = true)
    public void sampleTestCaseTwo()
    {
        //PathUtils.applySleep(1000);
        System.out.println("this is a sample test case two ");
    }

    @Test(priority = -2,description = "sample test case three",suiteName = "Smoke",dependsOnMethods ="loginToApplication" )
    public void sampleTestCaseThree()
    {
        System.out.println("this is a sample test case three ");
    }

    @Test(priority = 2, description = "sample test case four",suiteName = "Regression", invocationCount = 3)
    public void sampleTestCaseFour()
    {
        System.out.println("this is a sample test case four ");
    }

    @Test(description = "Login to Application", suiteName = "sanity", expectedExceptions = RuntimeException.class)
    public void loginToApplication()
    {
        System.out.println("Logged In Successfully");
        throw new RuntimeException("login failed");
    }


    @Test(description = "searching for product", suiteName = "sanity", expectedExceptions = RuntimeException.class)
    public void searchproduct()
    {
        System.out.println("searching product for chiru......");
        throw new RuntimeException("login failed");
    }

    @Test(priority = 200, description = "sample text 6", suiteName = "regression", invocationCount = 3, skipFailedInvocations = true)
    public void sampleTestSix()
    {
        System.out.println("this is sample test 6");
        throw new RuntimeException("failing deliberately ");
    }

    //ignoreMissingDependencies attribute--> It is used to ignore the missing dependencies
    // if the dependsOnMethods is not present in the current class, but in future you will create the test case, then it will ignore the missing dependencies

    @Test(description = "sample test case 7th", priority = 5, suiteName = "Smoke", dependsOnMethods = "soonToBeCreated", ignoreMissingDependencies = true)
    public void sampleTestSeventh()
    {
        System.out.println("sample test case seventh");
    }
}
