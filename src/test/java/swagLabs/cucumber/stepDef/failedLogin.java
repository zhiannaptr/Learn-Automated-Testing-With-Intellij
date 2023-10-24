package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class failedLogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";
    @Given("the User Launch the Web Application {string} on the Device")
    public void the_User_Launch_the_Web_Application_on_the_Device(String string) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(500);
    }
    @When("the User Enters Unregistered Username and Password")
    public void the_User_Enters_Unregistered_Username_and_Password() throws InterruptedException {
        String username = "standa";
        String password = "secre_sauce";
        driver.findElement(By.id("user-name")).sendKeys( username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(500);
    }
    @When("the User Click Green {string} Button")
    public void the_User_Click_Green_Button(String string) {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User get error message")
    public void User_get_error_message() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        driver.close();
    }
}