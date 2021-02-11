import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logging {
    @Test
    public void shouldBeRegisteredClient() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        login.click();
        String actualUrl = "https://www.saucedemo.com/";
        String expectedUrl = driver.getCurrentUrl();
        driver.quit();
    }

}
