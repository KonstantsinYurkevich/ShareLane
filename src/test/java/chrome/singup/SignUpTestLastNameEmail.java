package chrome.singup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTestLastNameEmail {
    @Test
    public void LastNameCanContainHyphen() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Jane");
        driver.findElement(By.name("last_name")).sendKeys("Potter-Malfoy");
        driver.findElement(By.name("email")).sendKeys("Obama@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Last Name can't " +
                "contain Hyphen)");
        driver.close();
    }

    @Test
    public void LastNameShouldNotContainSpaces() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Tom");
        driver.findElement(By.name("last_name")).sendKeys("O b a m a ");
        driver.findElement(By.name("email")).sendKeys("Obama@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Last Name can contain Spaces)");
        driver.close();
    }

    @Test
    public void LastNameShouldNotContainDigits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("Obama54");
        driver.findElement(By.name("email")).sendKeys("Obama@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Last Name can contain Digits)");
        driver.close();
    }

    @Test
    public void LastNameShouldNotAcceptSymbols() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Ann");
        driver.findElement(By.name("last_name")).sendKeys("!Obama$$<>");
        driver.findElement(By.name("email")).sendKeys("Obama@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Last Name can contain Symbols)");
        driver.close();
    }

    @Test
    public void EmailShouldBeRequired() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email can be missed)");
        driver.close();

    }

    @Test
    public void EmailShouldNotAcceptFieldWithoutAddressSign() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("kostyagmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email can be without address sign)");
        driver.close();

    }

    @Test
    public void EmailShouldAcceptEmailInUpperCase() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("KOSTYA@GMAIL.COM");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email can't be in " +
                "Upper Case)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailInLowerCase() {
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
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email can't be " +
                "in lower case)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithDigitsInEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3st1ya@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email name can't " +
                "contain digits in email name)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithDigitsInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3st1ya@g2f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email domain can't" +
                " contain digits)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithHyphenInEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3st-1ya@g2f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email name can't " +
                "contain hyphen)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithHyphenInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3st1ya@g-2f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email domain " +
                "can't contain hyphen)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithUnderscoreInEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3s_t1ya@g-2f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email name can't " +
                "contain underscore)");
        driver.close();
    }

    @Test
    public void EmailShouldAcceptEmailWithUnderscoreInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3s_t1ya@g-2_f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email domain can't " +
                "contain underscore)");
        driver.close();
    }
}
