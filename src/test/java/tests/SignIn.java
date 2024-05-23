package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.base.BaseClass;
import pom.pages.SignInPage;
import pom.timeout.TimeSleep;

public class SignIn extends BaseClass {

    @Test
    public void signIn_test(){
        TimeSleep.timeout();
        SignInPage sign = new SignInPage(driver);
        sign.set_your_username("Admin");
        sign.verify_username();
        TimeSleep.timeout();
        sign.set_your_password("admin123");
        sign.verify_password();
        TimeSleep.timeout();
        sign.click_on_submitBtn();
        TimeSleep.timeout();
        sign.clickOnSearchBar();
        TimeSleep.timeout();
        System.out.println("Successfully Login");
    }
}
