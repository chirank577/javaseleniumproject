package testNGApril14thAnnotation;

import org.testng.annotations.*;

public class TESTNGAnnotations {

    //Order of the execution:
    //BeforeSuite --> BeforeTest --> BeforeClass --> BeforeMethod --> Test --> AfterMethod --> AfterClass --> AfterTest --> AfterSuite

    //There are around 9 annotations in TESTNG:
    //1. BeforeSuite --> Gets executed before the start of the suite execution
    //Ex: Killing all the existing browsers, Setting up all the required connections
    //2. AfterSuite --> Gets executed after the completion of the test suite
    //Ex: Generation of Excel Reports, Summarized Reports, Triggering an email about the execution results

    //3. BeforeTest --> Rarely Used (Set of activities that are required, before triggering the test suite from the XML File)
    //4. AfterTest ---> Rarely Used (Set of activities that are required, after completion of the  test suite from the XML File)

    //5. BeforeClass --> Gets executed before the start of the test cases in the given class
    //Ex: Setting up of browser Drivers, Setting up of Framework objects

    //6. AfterClass --> Gets executed after the completion of test cases in the given class
    //Ex: Generate the extent or allure reports for all the test cases that we have written
    //Ex: Updating the results to the excel file

    //7. BeforeMethod --> Gets executed before the start of each and every test case
    //Ex: Launch the application, Logging into the application

    //8. AfterMethod --> Gets executed after the completion of each and every test cases
    //Ex: Logout of the application, Closing the application

    //9. Test --> This is where we write the actual business/test case of the application


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Executing before the execution of the test suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Executing after the execution of the test suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Executing before the execution of the test cases in the current class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Executing after the execution of the test cases in the current class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Executing before each and every test case");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Executing after each and every test case");
    }


    @Parameters({"A","B"})
    @Test
    public void test1(String a, String b)
    {
        System.out.println(a+"-----"+b);
        System.out.println("Executing test1");
    }

    @Test
    public void test2() {
        System.out.println("Executing test2");
    }

    @Test
    public void test3() {
        System.out.println("Executing test3");
    }}