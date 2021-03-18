import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckingCart {
    @Test
    public void shouldBeAddProductsInCart() {

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
        WebElement product1 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        product1.click();
        WebElement product2 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button"));
        product2.click();
        WebElement iconCart = driver.findElement(By.tagName("path"));
        iconCart.click();
        int numberOfOrders = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        String counterCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        int counter = Integer.parseInt(counterCart);
        Assert.assertEquals(numberOfOrders, counter, " The number of orders in the customer's list " +
                "does not match the number of orders in the cart counter");
        driver.quit();
    }


}
