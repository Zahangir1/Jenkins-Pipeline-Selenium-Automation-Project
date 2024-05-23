package pom.locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {
    WebDriver driver;
    public Locators(WebDriver driver){
        this.driver = driver;
    }

    public static String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static By username = By.xpath("//input[@name = 'username']");
    public static By userName_Assert = By.xpath("//input[@name='username']");
    public static By password = By.xpath("(//input)[3]");
    public static By password_Assert = By.xpath("//input[@name='password']");
    public static By submitBtn = By.xpath("(//button)[1]");
    public static By dashboard_Assert = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']//h6[1]");
    public static By searchBar = By.xpath("(//input)[1]");

}
