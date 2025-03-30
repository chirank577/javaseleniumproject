package frameworks;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//In this class, every method is static
// we want to ensure that no one creates an object of this class
 //Ensures that all the methods in this class are static and no one will be able to create the object of this class
//it ensures that all the variable are static in nature
@UtilityClass
public class BrowserUtils {

    @SneakyThrows
    public void killExistingBrowsers()
    {
        //Runtime.getRuntime()--> This is similar to run command in window, mac ets
        Runtime.getRuntime().exec("pkill -f chromedriver");

        // Kill Google Chrome
        Runtime.getRuntime().exec("pkill -f 'Google Chrome'");

        // Kill Firefox
        Runtime.getRuntime().exec("pkill -f firefox");

        // Kill Safari
        Runtime.getRuntime().exec("pkill -f Safari");

        // Kill Microsoft Edge (if installed)
        Runtime.getRuntime().exec("pkill -f 'Microsoft Edge'");

        System.out.println("Existing browsers have been killed.");
    }
    //Killing all the existing browsers
    public static WebDriver getDriver(String browserName)
    {
        return switch (browserName.toUpperCase()) {
            case "CHROME" -> new ChromeDriver();
            case "FIREFOX" -> new FirefoxDriver();
            case "EDGE" -> new EdgeDriver();
            case "SAFARI" -> new SafariDriver();
            default -> throw new RuntimeException("Invalid browser: " + browserName);
        };

    }

}
