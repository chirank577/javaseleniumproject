package frameworks;

import lombok.Data;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;

import java.security.PrivateKey;

//main agenda of this class is to ensure that the framework objects need not be created again and again
//only one copy/instance of object is maintained
//purpose of this lass is to maintain all the framework related objects

@Data // Is a combination of getter and setter
public class TestUtil {

    private WebDriver driver;
    private ExcelUtils excelUtils;
    private SeleniumUtils seleniumUtils;
    private JSFunctions jsFunctions;
    private PathUtils pathUtils;
    private PropertiesUtil propertiesUtil;
    private ElementUtils elementUtils;
    private Reports reports;

}
