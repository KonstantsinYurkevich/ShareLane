package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSearchAuthorNameAndSurname {
    @Test
    public void searchShouldAcceptByAuthorNameAndSurnameToLowerCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("mark twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=mark+twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameAndSurnameToUpperCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MARK TWAIN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MARK+TWAIN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldNotAcceptByAuthorNameAndSurnameWithoutSpace() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("marktwain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=marktwain", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(", "Search result doesn't work correct");
        driver.close();
    }

}
