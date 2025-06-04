package april7th2025RelativeLocators;

import frameworks.BrowserUtils;
import frameworks.ElementUtils;
import frameworks.PathUtils;
import frameworks.SeleniumUtils;
import frameworks.constants.BrowsersTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HandleCalendar_MakeMyTrip {
    public static void main(String[] args) {


        String date="14-April-2025";



        //div[@class='DayPicker-Month']/descendant::div[text()!='']

        String monthAndYear=date.split("-")[1]+" "+date.split("-")[2];
        String day=date.split("-")[0];

        BrowserUtils.killExistingBrowsers();

        WebDriver driver= BrowserUtils.getDriver(BrowsersTypes.CHROME.getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.makemytrip.com/");

        By btn_NextMonth=By.xpath("//span[@aria-label='Next Month']");

        By btn_DepartureDate=By.xpath("//p[@data-cy='departureDate']");

        PathUtils.applySleep(10000);

        driver.findElement(btn_DepartureDate).click();

        List<WebElement> expectedMonths=driver.findElements(By.xpath("//div[@class='DayPicker-Month']/descendant::div[text()!='']"))
                .stream().filter(element -> element.getText().contains(monthAndYear)).collect(Collectors.toList());

        while (expectedMonths.isEmpty()){
            driver.findElement(btn_NextMonth).click();
            expectedMonths=driver.findElements(By.xpath("//div[@class='DayPicker-Month']/descendant::div[text()!='']"))
                    .stream().filter(element -> element.getText().contains(monthAndYear)).collect(Collectors.toList());
        }

        driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::div[text()='"+monthAndYear+"']/following::div[@class='dateInnerCell']/p[text()='"+day+"']/..")).click();
    }
}

