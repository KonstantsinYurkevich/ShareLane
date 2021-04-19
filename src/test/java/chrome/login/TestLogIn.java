package chrome.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;


public class TestLogIn {
    @Test
    public void LogInShouldAcceptDataFromRegistration() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        sleep(1000);
        String confirmLogIn = driver.getCurrentUrl();
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py");
        driver.close();
    }
    @Test
    public void InLoginEmailShouldBeRequired() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Email" +
                " can be missed");
        driver.close();
    }

    @Test
    public void InLoginPasswordShouldBeRequired() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Password" +
                " can be missed");
        driver.close();
    }

    @Test
    public void InLoginEmailShouldBeRegisteredInSystem() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys("obama@gmail.com");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Can be used" +
                " Email that are not registered in system");
        driver.close();
    }

    @Test
    public void InLoginForEmailCanNotBeUsedWrongPassword() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Can be used" +
                " Password that doesn't  match Password attached to the Email  in system");
        driver.close();
    }

    @Test
    public void CanNotLogInWithEmailAndPasswordThatAreNotRegisteredInSystem() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys("Obama@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Can be used" +
                " Email and Password that are not registered in system");
        driver.close();
    }
    @Test
    public void LogInShouldNotAcceptEmailAndPasswordViceVersa() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("12345");
        driver.findElement(By.name("password2")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(accountCreated, "Account is created!", "Account doesn't created");
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(password);
        driver.findElement(By.name("password")).sendKeys(email);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error. Email and/or password don't match our records", "Can be used" +
                " Email and Password that are not registered in system");
        driver.close();
    }
}
