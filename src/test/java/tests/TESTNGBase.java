package tests;

import frameworks.*;
import frameworks.constants.AppConstants;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TESTNGBase {

    private TestUtil testUtil=new TestUtil();
    private WebDriver driver;
    private SeleniumUtils seleniumUtils;
    private PropertiesUtil propertiesUtil;
    private ExcelUtils excelUtils;
    @BeforeSuite
    public void killExistingBrowsers()
    {
        BrowserUtils.killExistingBrowsers();
    }

    @BeforeClass
    public void setUpFrameWorkObjects()
    {
        //for every browser that we launch we need to have a seperate framework object
        if(ReusableLibrary.testUtilThread.get()==null)
        {
            testUtil.setPropertiesUtil(new PropertiesUtil());
            testUtil.setDriver(BrowserUtils.getDriver(testUtil.getPropertiesUtil().getBrowser()));
            testUtil.setExcelUtils(new ExcelUtils());
            testUtil.setElementUtils(new ElementUtils(testUtil.getDriver()));
            testUtil.setSeleniumUtils(new SeleniumUtils(testUtil.getDriver(), testUtil.getElementUtils()));
            testUtil.setReports(new Reports(testUtil.getDriver()));
            testUtil.setJsFunctions(new JSFunctions(testUtil.getDriver()));

            ReusableLibrary.testUtilThread.set(testUtil);
        }
        else {
            testUtil=ReusableLibrary.testUtilThread.get();
        }
        driver= testUtil.getDriver();
        seleniumUtils=testUtil.getSeleniumUtils();
        propertiesUtil=testUtil.getPropertiesUtil();
        excelUtils =testUtil.getExcelUtils();

    }
    @BeforeMethod
    public void launchApplication()
    {
        seleniumUtils.launchApps(propertiesUtil.getURL());
    }

    @AfterMethod
    public void afterExecution(ITestResult testResult)
    {
//        System.out.println(testResult.getStatus());//this will let us know whether the test case is passed/failed/skipped
//        System.out.println(testResult.getMethod().getMethodName());//This will let us know what is the current method that we are executing

        if(testResult.getStatus() == ITestResult.SUCCESS)
        {
            excelUtils.writeDataToTheFile(PathUtils.getTestDataFolder()+"Sample_Execution.xlsx", AppConstants.INDEX_SHEET,"Execution Status","PASSED","Test Case Name-"+testResult.getMethod().getMethodName());
        } else if (testResult.getStatus()==ITestResult.FAILURE) {
            excelUtils.writeDataToTheFile(PathUtils.getTestDataFolder()+"Sample_Execution.xlsx", AppConstants.INDEX_SHEET,"Execution Status","FAILED","Test Case Name-"+testResult.getMethod().getMethodName());

        }
    }
}
