package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSearch {
    @Test
    public void SearchShouldAcceptByAuthorNameToLowerCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("mark");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=mark", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorNameToUpperCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MARK");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MARK", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toUpperCase().contains("MARK");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorNameByCamelCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MaRk");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MaRk", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }

    @Test
    public void SearchShouldAcceptByAuthorNameWithCapitalLetter() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Mark");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=Mark", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorNameWithSpace() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Mark  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Mark++", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldNotAcceptByAuthorNameWithSpaceForEveryLetter() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys(" M a r k ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+M+a+r+k+", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(");
        driver.close();
    }
    @Test
    public void SearchShouldNotAcceptByAuthorNameWithSymbols() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("M@ark@!#");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+M%40ark%40%21%23", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(","Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorSurnameToLowerCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorSurnameToUpperCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("TWAIN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=TWAIN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorSurnameByCamelCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("TwAiN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=TwAiN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorSurnameWithCapitalLetter() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=Twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorSurnameWithSpace() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Twain  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Twain++", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldNotAcceptByAuthorSurnameWithSpaceForEveryLetter() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys(" T w a i n ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+T+w+a+i+n+", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(");
        driver.close();
    }
    @Test
    public void SearchShouldNotAcceptByAuthorSurnameWithSymbols() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("#@!Tw@ain#");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=%23%40%21Tw%40ain%23",
                "button search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(","Search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorNameAndSurnameToLowerCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("mark twain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=mark+twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldAcceptByAuthorNameAndSurnameToUpperCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("MARK TWAIN");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MARK+TWAIN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
        driver.close();
    }
    @Test
    public void SearchShouldNotAcceptByAuthorNameAndSurnameWithoutSpace() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("marktwain");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=marktwain", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(","Search result doesn't work correct");
        driver.close();
    }

    @Test
    public void SearchthorNameToLowerCase() throws InterruptedException {
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
        assertEquals(confirmLogIn, "https://www.sharelane.com/cgi-bin/main.py", "Not login");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("  Great  ");
        driver.findElement(By.cssSelector("[value=Search]")).click();
        sleep(1500);
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Great++", "button " +
                "search doesn't work");
        assertTrue(driver.getPageSource().contains("Great"), "search result doesn't work correct");
        driver.close();
    }
}
