package tests;

import org.junit.Test;
import pages.YourCartPage;

public class TestYourCart extends BaseTest {

      @Test
    public void removeProduct (){
          yourCartPage = new YourCartPage(driver);
          yourCartPage.openPageProduct();
          yourCartPage.addProduct("Sauce Labs Bolt T-Shirt");
          yourCartPage.addProduct("Sauce Labs Fleece Jacket");
          yourCartPage.openCart();
          yourCartPage.remove();

      }
}