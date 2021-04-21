package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSearchNameOfTheBook {
    @Test
    public void searchAuthorNameToLowerCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
       driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Great  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Great++", "button " +
                "search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great"), "search result doesn't work correct");
        driver.close();
    }
}
