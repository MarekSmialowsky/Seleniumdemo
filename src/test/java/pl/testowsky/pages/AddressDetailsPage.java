package pl.testowsky.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import pl.testowsky.models.Customer;
import pl.testowsky.utils.SeleniumHelper;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private  WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;

    @FindBy(id = "billing_city")
    private  WebElement billingCityInput;

    @FindBy(id = "billing_postcode")
    private  WebElement billingPostCodeInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private  WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(id = "place_order")
    private  WebElement placeOrderButton;

    @FindBy(xpath = "html[@class='js js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage no-websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients no-cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers no-applicationcache svg inlinesvg smil svgclippaths']")
    private WebElement errorMakerFF;

    @FindBy(xpath = "//html[@class= 'js js flexbox flexboxlegacy canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers no-applicationcache svg inlinesvg smil svgclippaths']")
    private  WebElement errorMakerChrome;


    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostCodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        //errorMakerFF.click();
        //errorMakerChrome.click();
        SeleniumHelper.waitForClickable(placeOrderButton,driver);
        placeOrderButton.click();
        return new OrderDetailsPage(driver);
    }

}
