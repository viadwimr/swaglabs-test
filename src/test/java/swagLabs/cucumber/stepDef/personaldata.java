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

public class personaldata {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user is on personal data page")
    public void user_is_on_personal_data_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String pageName = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageName, "Products");
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
    }
    @And("user has entered first name")
    public void user_has_entered_first_name(){
        driver.findElement(By.id("first-name")).sendKeys("Via");
    }

    @And("user has entered last name")
    public void user_has_entered_last_name(){
        driver.findElement(By.id("last-name")).sendKeys("Dwi");
    }

    @And("user has entered zipcode")
    public void user_has_entered_zipcode(){
        driver.findElement(By.id("postal-code")).sendKeys("123456");
    }
    @When("user click the continue button")
    public void user_click_the_continue_button(){
        driver.findElement(By.id("continue")).click();
    }
    @Then("user will see the overview page")
    public void user_will_see_the_overview_page(){
        driver.findElement(By.xpath("//*[contains(text(),'Checkout: Overview')]"));
    }
}
