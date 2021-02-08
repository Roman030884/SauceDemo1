package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.CheckoutYourInformationPage.CHECKOUT_OVERVIEW_PAGE_NAME_;
import static pages.CheckoutYourInformationPage.YOUR_CART_PAGE_NAME_;

public class CheckoutYourInformationTest extends BaseTest {
    @Test
    public void checkGoInCheckoutOverviewPage() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", "Ivanov", "789");
        String namePage = driver.findElement(CHECKOUT_OVERVIEW_PAGE_NAME_).getText();
        Assert.assertEquals("Checkout: Overview", namePage, "The transition to a new " +
                "page (Checkout: Overview) was not completed");
    }

    @Test
    public void checkReturnYourCartPage() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.returnYourCartPage();
        Assert.assertEquals("Your Cart",checkoutYourInformationPage.elementCheckoutOverview(),
                "The transition to a new page (Your Cart) was not completed");
    }

    @Test
    public void checkFormFieldFirstNameEmpty() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("", "Ivanov", "789");
        Assert.assertEquals("Error: First Name is required", checkoutYourInformationPage.getErrorMessage(),
                "The error notification doesn't work");
    }

    @Test
    public void checkFormFieldLastNameEmpty() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", "", "789");
        Assert.assertEquals("Error: Last Name is required", checkoutYourInformationPage.getErrorMessage(),
                "The error notification doesn't work");
    }

    @Test
    public void checkFormFieldPostalCodeEmpty() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", "Ivanov", "");
        Assert.assertEquals("Error: Postal Code is required", checkoutYourInformationPage.getErrorMessage(),
                "The error notification doesn't work");
    }
    @Test
    public void checkFormFieldPostalCodeSpace() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", "Ivanov", " ");
        Assert.assertEquals("Checkout: Overview", checkoutYourInformationPage.elementCheckoutOverview(),
                "The error notification work");
    }
    @Test
    public void checkFormFieldFirstNameSpace() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData(" ", "Ivanov", "789");
        Assert.assertEquals("Checkout: Overview", checkoutYourInformationPage.elementCheckoutOverview(),
                "The error notification work");
    }
    @Test
    public void checkFormFieldLasttNameSpace() {
        checkoutYourInformationPage.openCheckoutYourInformationPage();
        checkoutYourInformationPage.inputData("Roman", " ", "789");
        Assert.assertEquals("Checkout: Overview", checkoutYourInformationPage.elementCheckoutOverview(),
                "The error notification work");
    }
}