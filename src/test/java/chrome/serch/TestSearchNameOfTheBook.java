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
    public void searchShouldAcceptBookNameToLowerCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("great expectations");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great expectations"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptBookNameToUpperCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("GREAT EXPECTATIONS");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldAcceptBookNameCamelCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("GrEaT ExPeCtAtIoNs");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldAcceptBookNameIfItContainWthMoreThanOneWordViceVersa() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("expectations great");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("great expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldAcceptOneWordFromBookName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("expectations");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldNotAcceptBookNameWithDigits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("exp1ect21atio3ns3");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
    @Test
    public void searchShouldNotAcceptBookNameWithDSymbols() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("gr!ea;t");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
    @Test
    public void searchShouldAcceptWithSymbolsInTheEnd() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("expectations!@#$%^&*");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldAcceptWithSymbolsInTheBeginning() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("!@#$%^&*expectations");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("expectations"), "Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void searchShouldNotAcceptWithSpaceInEachLetter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("g r e a t");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
    @Test
    public void searchShouldNotAcceptWithCyrillicLetters() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        // letter a,p,c from Cyrillic
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("greаt exрeсtations");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
}
