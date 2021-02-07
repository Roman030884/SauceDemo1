package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    YourCartPage yourCartPage;
    ProductsPage productsPage;
    LoginPage loginPage;

   @BeforeMethod
        public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        yourCartPage = new YourCartPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage = new LoginPage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
