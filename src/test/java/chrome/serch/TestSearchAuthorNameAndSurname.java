package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark twain"), "Search result doesn't work correct");
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
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark twain"), "Search result doesn't work correct");
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
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameToLowerCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("mark");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameToUpperCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MARK");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameByCamelCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MaRk");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameWithCapitalLetter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Mark");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorNameWithSpace() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Mark  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("mark"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldNotAcceptByAuthorNameWithSpaceForEveryLetter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys(" M a r k ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }

    @Test
    public void searchShouldNotAcceptByAuthorNameWithSymbols() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("M@ark@!#");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorSurnameToLowerCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("twain"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorSurnameToUpperCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("TWAIN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("twain"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorSurnameByCamelCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("TwAiN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("twain"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorSurnameWithCapitalLetter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("twain"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldAcceptByAuthorSurnameWithSpace() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Twain  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td " +
                "> table:nth-child(1)")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        assertTrue(driver.getPageSource().toLowerCase().contains("twain"), "Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void searchShouldNotAcceptByAuthorSurnameWithSpaceForEveryLetter() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys(" T w a i n ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }

    @Test
    public void searchShouldNotAcceptByAuthorSurnameWithSymbols() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("#@!Tw@ain#");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
    @Test
    public void searchShouldNotAcceptByAuthorThatDoesNotExistInData() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Tolstoy");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        boolean testResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).isDisplayed();
        assertTrue(testResult, "Search doesn't work");
        driver.close();
    }
}
