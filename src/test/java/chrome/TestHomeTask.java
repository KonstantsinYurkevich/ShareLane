package chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestHomeTask {
    @Test
    public void testHomeTask(){
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.get("https://www.sharelane.com/cgi-bin/show_book.py?book_id=10");
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.get(" https://www.sharelane.com/cgi-bin/shopping_cart.py");
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).clear();
        driver.findElement(By.xpath("((//tr)[8]//td)[3]/input")).sendKeys("10");
        driver.findElement(By.xpath("((//tr)[10]//td)[1]/input")).click();
        String totalPriceReal = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        assertEquals(totalPriceReal, "10000.00", "Wrong calculation of total price");
        driver.close();
    }
}
