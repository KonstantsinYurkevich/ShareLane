package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great"), "Search result doesn't work correct");
        driver.close();
    }
}
