package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class YourCartTest extends BaseTest {

    @Test
    public void checkCountingOfOrderedProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        yourCartPage.goInCheckoutPage();
        int numberOfOrders = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        String counterCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        int counter = Integer.parseInt(counterCart);
        Assert.assertEquals(numberOfOrders, counter, " The number of orders in the customer's list " +
                "does not match the number of orders in the cart counter");
    }

    @Test
    public void checkRemoveProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");
        yourCartPage.goInCheckoutPage();
        yourCartPage.remove();
        int numberOfOrders = driver.findElements(By.xpath("//button[text()='REMOVE']")).size();
        String counterCart = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        int counter = Integer.parseInt(counterCart);
        Assert.assertEquals(numberOfOrders, counter, " The number of orders in the customer's list " +
                "does not match the number of orders in the cart counter");
    }

    @Test
    public void checkButtonCheckout() {
        yourCartPage.openPageYourCart();
        yourCartPage.goInPageCheckoutYourInformation();
        String namePage = driver.findElement(By.id("first-name")).getAttribute("placeholder");
        Assert.assertEquals("First Name", namePage, "The transition to a new " +
                "page (Checkout: Your Information) was not completed");
    }

    @Test
    public void checkButtonContinueShopping() {
        yourCartPage.openPageYourCart();
        yourCartPage.returnInPageProducts();
        String namePage = driver.findElement(By.className("product_label")).getText();
        Assert.assertEquals("Products", namePage, "The transition to a new " +
                "page (Products) was not completed");
    }

    @Test
    public void goToTheProductDescriptionPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        yourCartPage.goInCheckoutPage();
        driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).click();
        String namePage = driver.findElement(By.className("inventory_details_back_button")).getText();
        Assert.assertEquals("<- Back", namePage, "The transition to a new " +
                "page (Description of product) was not completed");
    }
}