package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class loginFailed {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User masuk ke login page Swaglabs")
    public void user_masuk_ke_login_page_swaglabs() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @And("User memasukkan invalid username")
    public void user_memasukkan_invalid_username(){
        driver.findElement(By.id("user-name")).sendKeys("username_random");
    }
    @And("User memasukkan invalid password")
    public void user_memasukkan_invalid_password(){
        driver.findElement(By.id("password")).sendKeys("password_random");
    }
    @When("User mengklik login button")
    public void user_mengklik_login_button(){
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User gagal melihat halaman products")
    public void user_gagal_melihat_halaman_products(){
        driver.findElement(By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
    }
}
