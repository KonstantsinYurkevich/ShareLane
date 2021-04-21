package chrome.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSearchAuthorNameAndSurnameSeparate {
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=mark", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MARK", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toUpperCase().contains("MARK");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=MaRk", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=Mark", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Mark++", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("mark");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+M+a+r+k+", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+M%40ark%40%21%23", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(", "Search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=TWAIN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=TwAiN", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=Twain", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=++Twain++", "button " +
                "search doesn't work");
        String searchResult = driver.getPageSource();
        boolean acceptableSearch = searchResult.toLowerCase().contains("twain");
        assertTrue(acceptableSearch, "search result doesn't work correct");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=+T+w+a+i+n+", "button " +
                "search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(");
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
        String confirmSearch = driver.getCurrentUrl();
        assertEquals(confirmSearch, "https://www.sharelane.com/cgi-bin/search.py?keyword=%23%40%21Tw%40ain%23",
                "button search doesn't work");
        String searchResult = driver.findElement(By.cssSelector("[class=\"confirmation_message\"]")).getText();
        assertEquals(searchResult, "Nothing is found :(","Search result doesn't work correct");
        driver.close();
    }
}
