package testNGApril14thAnnotation;

import org.testng.annotations.Test;

public class GroupingOfTestCases_PartTwo {

    @Test(description = "sample Test Case One",groups ="Smoke")
    public void sampleCaseSIx()
    {
        System.out.println("Sample test case Six ");
    }
    @Test(description = "sample Test Case Two",groups ="Smoke")
    public void sampleCaseSeven()
    {
        System.out.println("Sample test case Seven ");
    }

    @Test(description = "sample Test Case Three",groups ="Sanity")
    public void sampleCaseEight()
    {
        System.out.println("Sample test case Eight ");
    }

    @Test(description = "sample Test Case Four", groups = "Regression")
    public void sampleCaseNine()
    {
        System.out.println("Sample test case Nine");
    }
}
