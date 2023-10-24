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

public class sortProduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";
    @Given("the User Success Login")
    public void the_User_Success_Login() throws InterruptedException {
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
    @When("the User Clicks the Sorting Features \\(A to Z)")
    public void the_User_Clicks_the_Sorting_Features_A_to_Z() throws InterruptedException {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
    }
    @When("the User Clicks Products by Price \\(High to Low)")
    public void the_User_Clicks_Products_by_Price_High_to_Low() throws InterruptedException {
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
        Thread.sleep(500);
    }
    @Then("Products Will Display by Price \\(High to Low)")
    public void Products_Will_Display_by_Price_High_to_Low() {
        Assert.assertEquals("$49.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.close();
    }
}