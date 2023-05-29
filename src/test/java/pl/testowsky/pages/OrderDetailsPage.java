package pl.testowsky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//div[@class = 'woocommerce-order']//p")
    private WebElement orderNotice;

    @FindBy(xpath ="//td[@class = 'woocommerce-table__product-name product-name']//a")
    private  WebElement productName;


    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }

    public WebElement getProductName() {
        return productName;
    }
}
