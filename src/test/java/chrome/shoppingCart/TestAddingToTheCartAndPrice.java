package chrome.shoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestAddingToTheCartAndPrice {
    @Test
    public void addToCartFailWithoutLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        String error = driver.findElement(By.cssSelector("[class=\"error_message\"]")).getText();
        assertEquals(error, "Oops, error. You must log in", "Error, no need to be login");
        driver.close();
    }

    @Test
    public void addToCarAcceptWithLogin() {
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
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        String error = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(error, "Book was added to the Shopping Cart", "not equal confirming massage");
        driver.close();
    }

    @Test
    public void addedBookSameAsInShoppingCart() {
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
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/a")).click();
        String onMainPage = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td > " +
                "table > tbody > tr > td:nth-child(2) > p:nth-child(1) > b")).getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        String booked = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]")).getText();
        boolean compareBookedAndInShoppingCart = booked.toLowerCase().contains(onMainPage.toLowerCase());
        assertTrue(compareBookedAndInShoppingCart, "Book that add to cart and book in cart are different");
        driver.close();
    }

    @Test
    public void addingTwoDifferentBooksToTheShoppingCart() {
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
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/t" +
                "d/a")).click();
        String onMainPageFirstBook = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > " +
                "td > table > tbody > tr > td:nth-child(2) > p:nth-child(1) > b")).getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/" +
                "a")).click();
        String onMainPageSecondBook = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > " +
                "td > table > tbody > tr > td:nth-child(2) > p:nth-child(1) > b")).getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();

        String booked = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]")).getText();
        boolean compareFirstBookedAndInShoppingCart = booked.toLowerCase().contains(onMainPageFirstBook.toLowerCase());
        assertTrue(compareFirstBookedAndInShoppingCart, "First book not added to the shopping cart");
        boolean compareSecondBookedAndInShoppingCart = booked.toLowerCase().contains(onMainPageSecondBook.toLowerCase());
        assertTrue(compareSecondBookedAndInShoppingCart, "Second book not added to the shopping cart");
        driver.close();
    }
    @Test
    public void priceOfTheBookShouldEqualsPriceInCart() {
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
        String email = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > b")).getText();
        String password = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > " +
                "table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(6) > td > table > tbody > " +
                "tr:nth-child(2) > td > p > a")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/a")).click();
        String priceOnBookPage = driver.findElement(By.cssSelector("body > center > table > tbody > tr:nth-child(5) > td >" +
                " table > tbody > tr > td:nth-child(2) > p:nth-child(3) > b > font")).getText();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        String priceInCart = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[4]")).getText();
        boolean compareBookedAndInShoppingCart = priceOnBookPage.toLowerCase().contains(priceInCart.toLowerCase());
        assertTrue(compareBookedAndInShoppingCart, "Book that add to cart and book in cart are different");
        driver.close();
    }
}
