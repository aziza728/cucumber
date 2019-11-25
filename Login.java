package testmeapp.casestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
//import testmeapp.UtilityClass;

public class Login {
	WebDriver driver;
	WebDriverWait wait;
	@Given("^User has registered and is in Login page$")
	public void user_has_registered_and_is_in_Login_page() throws Throwable {
		 driver=UtilityClass.openBrowser("chrome");
		 driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	}

	@When("^User enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_the_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.name("userName")).sendKeys(arg1);
		  driver.findElement(By.name("password")).sendKeys(arg2);
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
		 driver.findElement(By.name("Login")).click();
	}

	@Then("^User must be logged in successfully$")
	public void user_must_be_logged_in_successfully() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  Assert.assertEquals("Home", driver.getTitle());
	}

	

}
