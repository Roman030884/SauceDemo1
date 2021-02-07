package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class PageYourCart extends BasePage {

    public static final By REMOVE_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[5]/div[2]/div[2]/button;");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
    public static final By CHECKOUT_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    public static final By PRODUCT_NAME1 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");
    public static final By PRODUCT_NAME2 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button");
    public static final By COUNTER = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public PageYourCart(WebDriver driver) {
        super(driver);
    }
    public void addProduct (){
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button ")).click();
    }

    public void openCart () {

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
    }

    public void remove () {
        driver.findElement(REMOVE_BUTTON).click();
    }
    public void moveProductPage(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
    public void moveCheckoutYourInformationPage(){
        driver.findElement(CHECKOUT_SHOPPING_BUTTON).click();
    }
    public void counterProducts(){
        String counterCart = driver.findElement(COUNTER).getText();
        int counter = Integer.parseInt(counterCart);
    }
}
