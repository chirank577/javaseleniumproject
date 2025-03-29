package frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtils {
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
