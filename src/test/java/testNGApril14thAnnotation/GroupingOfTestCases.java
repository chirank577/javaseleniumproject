package testNGApril14thAnnotation;

import org.testng.annotations.Test;

public class GroupingOfTestCases {

    @Test(description = "sample Test Case One",groups = "Smoke")
    public void sampleCaseOne()
    {
        System.out.println("Sample test case one ");
    }
    @Test(description = "sample Test Case Two",groups = "Smoke")
    public void sampleCaseTwo()
    {
        System.out.println("Sample test case Two ");
    }

    @Test(description = "sample Test Case Three",groups = "Sanity")
    public void sampleCaseThree()
    {
        System.out.println("Sample test case Three ");
    }

    @Test(description = "sample Test Case Four", groups = "Regression")
    public void sampleCaseFour()
    {
        System.out.println("Sample test case Four");
    }

    @Test(description = "Login of test case",groups = "Login")
    public void login_Test()
    {
        System.out.println("Trying to login");

    }
}
