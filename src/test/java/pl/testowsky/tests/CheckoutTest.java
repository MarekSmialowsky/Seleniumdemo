package pl.testowsky.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowsky.models.Customer;
import pl.testowsky.pages.HomePage;
import pl.testowsky.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {
        Customer customer = new Customer();
        customer.setEmail("terefer@gmail.com");

        /* customer.setFirstName("Marco");
        customer.setLastName("Polo");
        customer.setCompanyName("TestowaComapania");
        customer.setCountry("Poland");
        customer.setStreet("Wrocławska");
        customer.setFlatNumber("22/3");
        customer.setZipCode("01-455");
        customer.setCity("Warszawa");
        customer.setPhone("222333444");
        customer.setEmail("test@test.pl");*/

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer,"random test comments");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver");


    }


}
