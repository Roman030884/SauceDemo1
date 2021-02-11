package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCartPage extends BasePage {

    public static final By REMOVE_BUTTON = By.xpath("//button[text()='REMOVE']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[1]");
    public static final By CHECKOUT_SHOPPING_BUTTON = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    public static final By ICON_CART = By.tagName("path");

    public YourCartPage(WebDriver driver) {

        super(driver);
    }

    public void goInCheckoutPage() {

        driver.findElement(ICON_CART).click();
    }

    public void remove() {

        driver.findElement(REMOVE_BUTTON).click();
    }

    public void goInPageCheckoutYourInformation() {

        driver.findElement(CHECKOUT_SHOPPING_BUTTON).click();
    }

    public void openPageYourCart() {

        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void returnInPageProducts() {

        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

}