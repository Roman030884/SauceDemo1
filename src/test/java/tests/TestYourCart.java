package tests;

import org.junit.Test;

public class TestYourCart extends BaseTest {

      @Test
    public void removeProduct (){
          pageYourCart.addProduct();
          pageYourCart.openCart();
          pageYourCart.remove();

      }
}