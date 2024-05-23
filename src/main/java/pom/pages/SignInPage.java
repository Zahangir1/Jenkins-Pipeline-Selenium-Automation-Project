package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pom.locator.Locators;

public class SignInPage {
    WebDriver driver = null;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void set_your_username(String u_name){
        driver.findElement(Locators.username).sendKeys(u_name);
    }
    public void verify_username(){
        WebElement uname_verify = driver.findElement(Locators.userName_Assert);
        //To check/verify the placeholder
        Assert.assertEquals(uname_verify.getAttribute("placeholder"),"Username");
        String username_placeholder = uname_verify.getAttribute("placeholder");
        System.out.println(username_placeholder);
        //To validate text entered or not in textBox
        String get_username= uname_verify.getAttribute("value");
        System.out.println("Username: " + get_username);

        /*//To check/verify the placeholder
        if (plcaehld.equals("Username"))
        {
            System.out.println("Valid Place holder");
        }
        else
        {
            System.out.println("invalid place holder");
        }

        //To Check that text box is empty or not
        *//*String clearText_box =uname_verify.getAttribute("value");
        if(clearText_box.isEmpty())
        {
            System.out.println(" Yes Text box is clear");
        }
        else
        {
            System.out.println("No Text box is not clear");
        }*//*

        //To validate text entered or not in textBox
        if (get_username.contains("Admin"))
        {
            System.out.println("Yes text is entered ");
        }
        else
        {
            System.out.println("Text is not entered ");
        }*/
    }

    public void set_your_password(String pass){
        driver.findElement(Locators.password).sendKeys(pass);
    }

    public void verify_password(){
        WebElement password_verify = driver.findElement(Locators.password_Assert);
        //To check/verify the placeholder
        Assert.assertEquals(password_verify.getAttribute("placeholder"),"Password");
        String password_placeholder = password_verify.getAttribute("placeholder");
        System.out.println(password_placeholder);
        //To validate text entered or not in textBox
        String get_password= password_verify.getAttribute("value");
        System.out.println("Password: " + get_password);
    }

    public void click_on_submitBtn(){
        driver.findElement(Locators.submitBtn).click();
    }

    public void verify_dashboard(){
        WebElement dashboard_verify = driver.findElement(Locators.dashboard_Assert);
//        Assert.assertEquals(dashboard_verify.getAttribute(""),"Dashboard");
        String ActualText = dashboard_verify.getAttribute("value");
        String ExpectedText = "Dashboard";
        Assert.assertEquals(ExpectedText, ActualText);
        System.out.println("Dashboard: " + ActualText);
    }

    public void clickOnSearchBar(){
        driver.findElement(Locators.searchBar).click();
    }

}
