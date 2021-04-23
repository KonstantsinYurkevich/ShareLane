package chrome.shoppingCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestDiscountInPercentDiscountInMoneyAndTotalPrice {
    @Test
    public void FieldsDiscountAndTotalPriceShouldHaveRightCalculations() {
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
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        String totalPrice = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[7]")).getText();
        String discountPercent= driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[6]")).getText();
        String priceValue = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[4]")).getText();
        double priseDouble = Double.parseDouble(priceValue);
        double discountDouble = Double.parseDouble(discount);
        Double discountPercentDouble = Double.valueOf(discountPercent);
        Double totalPriceDouble = Double.valueOf(totalPrice);
        Double discountDoubleValuePercent = (priseDouble / 100);
        Double discountDoubleValue = discountDoubleValuePercent * discountPercentDouble;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String discountDoubleValueResult = decimalFormat.format(discountDoubleValue);
        boolean trueCalculations;
        double discountDoubleValueResultDouble = Double.parseDouble(discountDoubleValueResult);
        trueCalculations = discountDoubleValueResultDouble == discountDouble;
        assertTrue(trueCalculations,"Calculation of discount in field discount,$ - WRONG!");
        Double totalValueWithDiscount = priseDouble - discountDouble;
        assertEquals(totalPriceDouble, totalValueWithDiscount,"Calculation of total price with discount - WRONG!");
        driver.close();
    }
    @Test
    public void rightCalculationsOfDiscountInRangeFrom20to49ShouldBe2PercentDiscount() {
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
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[3]/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/input")).sendKeys("10");
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        String discountPercent= driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        int actualDiscount = Integer.parseInt(discountPercent);
        int expectedDiscount = 2;
        boolean comperingActualAndExpected;
        comperingActualAndExpected = actualDiscount==expectedDiscount;
        assertTrue(comperingActualAndExpected,"Percent discount word wrong");

        driver.close();
    }
}
