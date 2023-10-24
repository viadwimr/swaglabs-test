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

public class checkoutNoproduct {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User is on products page")
    public void User_is_on_products_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String pageName = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageName, "Products");
    }

    @And("User click cart simbol button")
    public void User_click_cart_simbol_button(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("User click checkout button")
    public void User_click_checkout_button(){
        driver.findElement(By.id("checkout")).click();
    }

    @And("User send personal data")
    public void User_send_personal_data(){
        driver.findElement(By.id("first-name")).sendKeys("Via");
        driver.findElement(By.id("last-name")).sendKeys("Dwi");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
    }
    @When("User click the finish button")
    public void User_click_the_finish_button(){
        driver.findElement(By.xpath("//*[contains(text(),'Checkout: Overview')]"));
        driver.findElement(By.id("finish")).click();
    }
    @Then("User will see the success message")
    public void user_will_see_the_success_message(){
        driver.findElement(By.xpath("//*[contains(text(),'Thank you for your order!')]"));
    }
}
