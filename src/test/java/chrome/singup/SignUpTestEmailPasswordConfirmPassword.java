package chrome.singup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTestEmailPasswordConfirmPassword {
    @Test
    public void emailShouldAcceptEmailWithDotInEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3s_t1.ya@g-2_f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email name can't " +
                "contain dots )");
        driver.close();
    }

    @Test
    public void emailShouldAcceptEmailWithSomeDotsInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko.3s_t1.ya@g-.2_f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email domain can't " +
                "contain  some dots)");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithoutDotsInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3s_t1.ya@g-2_fcom");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email domain can be without dot(s))");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithSpacesInEmailNAme() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3 s_t1.ya@g-2_f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email name  can contain space)");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithSpacesInDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("ko3s_t1.ya@g-2_f. com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email domain can contain space)");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithoutEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("@g-2_f.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email name can be missed)");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithoutDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("Kostya123");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email domain can be missed)");
        driver.close();
    }

    @Test
    public void emailShouldAcceptEmailWithSymbolsInEmailName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("Ko$ty#a@gmail.com");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Email name can't " +
                "contain symbols)");
        driver.close();
    }

    @Test
    public void emailShouldNotAcceptEmailWithSymbolAtTheEndOfDomain() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Sam");
        driver.findElement(By.name("last_name")).sendKeys("Obama");
        driver.findElement(By.name("email")).sendKeys("Kostya123@gmail.com;");
        driver.findElement(By.name("password1")).sendKeys("1234");
        driver.findElement(By.name("password2")).sendKeys("1234");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Email domain can contain symbols in the end)");
        driver.close();
    }

    @Test
    public void passwordShouldBeRequired() {
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
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("12345678912345678912");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Password can be missed)");
        driver.close();
    }

    @Test
    public void confirmPasswordShouldBeRequired() {
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
        driver.findElement(By.name("password1")).sendKeys("1234321");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Confirm Password can be missed)");
        driver.close();
    }

    @Test
    public void passwordShouldNotAcceptFieldWith3Digits() {
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
        driver.findElement(By.name("password1")).sendKeys("123");
        driver.findElement(By.name("password2")).sendKeys("123");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Password can contain 3 digits)");
        driver.close();
    }

    @Test
    public void passwordShouldAcceptFieldWith20Digits() {
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
        driver.findElement(By.name("password1")).sendKeys("12345678912345678912");
        driver.findElement(By.name("password2")).sendKeys("12345678912345678912");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Password should be " +
                "less than 20 digits)");
        driver.close();
    }

    @Test
    public void passwordShouldAcceptFieldWithSymbols() {
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
        driver.findElement(By.name("password1")).sendKeys("123!@#$%^&*(");
        driver.findElement(By.name("password2")).sendKeys("123!@#$%^&*(");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String accountCreated = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        Assert.assertEquals(accountCreated, "Account is created!", "Error massage (Password can't " +
                "contain symbols)");
        driver.close();
    }

    @Test
    public void registrationShouldNotBeWithNotEqualsPasswordAndConfirmPassword() {
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
        driver.findElement(By.name("password1")).sendKeys("123!@#$%^&*(");
        driver.findElement(By.name("password2")).sendKeys("123321");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        Assert.assertEquals(error, "Oops, error on page. Some of your fields have invalid data or email was " +
                "previously used", "Error massage (Password and Confirm Password can be different)");
        driver.close();
    }
}
