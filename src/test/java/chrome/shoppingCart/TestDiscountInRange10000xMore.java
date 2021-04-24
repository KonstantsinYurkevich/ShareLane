package chrome.shoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestDiscountInRange10000xMore {
    @Test
    public void rightValueOfDiscountInRangeFrom10000AndMoreShouldBe8PercentDiscountValue10000() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).clear();
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).sendKeys("10000");
        driver.findElement(By.xpath("((//tr)[10]//td)[1]/input")).click();
        String discountPercent= driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        assertEquals(discountPercent,"8","Wrong value of discount");
        driver.close();
    }
    @Test
    public void rightValueOfDiscountInRangeFrom10000AndMoreShouldBe8PercentDiscountValue10000000() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).clear();
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).sendKeys("10000000");
        driver.findElement(By.xpath("((//tr)[10]//td)[1]/input")).click();
        String discountPercent= driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        assertEquals(discountPercent,"8","Wrong value of discount");
        driver.close();
    }
}
