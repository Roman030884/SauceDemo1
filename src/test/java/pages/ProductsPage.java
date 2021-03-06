package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CARD = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void buyProduct(String productName) {

        driver.findElement(By.xpath(String.format(ADD_TO_CARD, productName))).click();
    }

}
