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
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        String onMainPage = driver.findElement(By.xpath("(((//tr)[7])//td[2]//p[1]/b)")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        String actualURL = driver.getCurrentUrl();
        assertEquals(actualURL, "https://www.sharelane.com/cgi-bin/shopping_cart.py", "Button Shopping Card doesn't work correct ");
        String booked = driver.findElement(By.xpath("((//tr)[8])//td[1]")).getText();
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        String onMainPageFirstBook = driver.findElement(By.xpath("(((//tr)[7])//td[2]//p[1]/b)")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("((//tr)[2])//td[1]//a")).click();
        driver.findElement(By.xpath("((//tr)[14])//td[1]/a")).click();
        String onMainPageSecondBook = driver.findElement(By.xpath("(((//tr)[7])//td[2]//p[1]/b)")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("((//tr)[2])//td[3]/a")).click();
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
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String password = driver.findElement(By.xpath("(//td)[17]")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'main')]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        String priceOnBookPage = driver.findElement(By.xpath("((((//tr)[7])//td[2]//p[3])//b[1])//font")).getText();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("((//tr)[2])//td[3]/a")).click();
        String priceInCart = driver.findElement(By.xpath("((//tr)[8]//td)[4]")).getText();
        boolean compareBookedAndInShoppingCart = priceOnBookPage.toLowerCase().contains(priceInCart.toLowerCase());
        assertTrue(compareBookedAndInShoppingCart, "Book that add to cart and book in cart are different");
        driver.close();
    }

    @Test
    public void priceOfTheBooksShouldBe1000CentsConvertedTooDollars() {
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
        String priceOnBookPage = driver.findElement(By.xpath("((((//tr)[7])//td[2]//p[3])//b[1])//font")).getText();
        String priceConvertedToDollars = "10.00";
        boolean comparePriceOnBookAndPriceInDataConvertedToDollars = priceOnBookPage.toLowerCase().contains(priceConvertedToDollars.toLowerCase());
        assertTrue(comparePriceOnBookAndPriceInDataConvertedToDollars, "Book that add to cart and book in cart are different");
        driver.close();
    }
}
