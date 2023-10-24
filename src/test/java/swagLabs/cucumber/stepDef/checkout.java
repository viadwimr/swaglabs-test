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

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user is on products page")
    public void user_is_on_products_page(){
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
    @And("user click add cart button on one of product")
    public void user_click_add_cart_button_on_one_of_product(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @And("user click cart simbol button")
    public void user_click_cart_simbol_button(){
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @And("user click checkout button")
    public void user_click_checkout_button(){
        driver.findElement(By.id("checkout")).click();
    }

    @And("user send personal data")
    public void user_send_personal_data(){
        driver.findElement(By.id("first-name")).sendKeys("Via");
        driver.findElement(By.id("last-name")).sendKeys("Dwi");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
    }
    @When("user click the finish button")
    public void user_click_the_finish_button(){
        driver.findElement(By.xpath("//*[contains(text(),'Checkout: Overview')]"));
        driver.findElement(By.id("finish")).click();
    }
    @Then("user will see the success message")
    public void user_will_see_the_success_message(){
        driver.findElement(By.xpath("//*[contains(text(),'Thank you for your order!')]"));
    }
}
