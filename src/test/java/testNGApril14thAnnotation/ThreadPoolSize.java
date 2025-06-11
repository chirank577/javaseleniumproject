package testNGApril14thAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize {

    //ThreadPoolSize --> Determines how many threads need to be used this particular test case
    //It is used in conjuction with innovation counter

    @Test(description = "Launch Application",invocationCount = 4, threadPoolSize = 2)
    public void launchAppliaction()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.linkedin.com/");
    }

}
