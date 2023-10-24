package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class successLogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";

    @Given("the User Launch the Web Application")
    public void the_User_Launch_the_Web_Application() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(500);
    }
    @When("the User Enters Registered Username and Password")
    public void the_User_Enters_Registered_Username_and_Password() throws InterruptedException {// Write code here that turns the phrase above into concrete actions
        String password = "secret_sauce";
        String username = "standard_user";
        driver.findElement(By.id("user-name")).sendKeys( username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(500);
    }
    @When("the User Click the {string} Button")
    public void the_User_Click_the_Button(String string) {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("the user is on Product Page {string}")
    public void the_user_is_on_Product_Page(String string) {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        driver.close();
    }
}
