package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void setUpProductsTest(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

    }

    @Test (retryAnalyzer = Retry.class)
    public void productsShouldBeAvailableInCart() {
        productsPage.buyProduct("Sauce Labs Bolt T-Shirt");
        productsPage.buyProduct("Sauce Labs Fleece Jacket");

    }

}

