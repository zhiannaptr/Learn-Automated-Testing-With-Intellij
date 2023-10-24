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

public class viewProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";
    @Given("the User Success Login saucedemo")
    public void the_User_Success_Login_saucedemo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }
    @When("the User Clicks on the Desired Product")
    public void the_User_Clicks_on_the_Desired_Product() throws InterruptedException {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']")).click();
        Thread.sleep(500);
    }
    @Then("Product Detail Will Appear on the Page")
    public void Product_Detail_Will_Appear_on_the_Page() {
        Assert.assertEquals("Sauce Labs Bike Light",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        driver.close();
    }
}