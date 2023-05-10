package pl.testowsky.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testowsky.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void LoginTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .loginValidData("test1@test.pl", "test@test.pl")
                .getDashboardLink();


        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void loginWithInvalidPassword() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidData("test1@test.pl", "tes@test.pl")
                .getError();


        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "expected error text doesnt't match");
    }
}
