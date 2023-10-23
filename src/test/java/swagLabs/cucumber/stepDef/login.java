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
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User masuk ke halaman login Swaglabs")
    public void halaman_login(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        ChromeOptions opt = new ChromeOptions();
//        opt.setHeadless(false);
//
//        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @And("User memasukkan \"username\"")
    public void username_input(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @And("User memasukkan \"password\"")
    public void password_input(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("User mengklik tombol \"login\"")
    public void login_button(){
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User berhasil dapat melihat halaman \"products\"")
    public void products_page(){
        String pageName = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageName, "Products");
    }
}
