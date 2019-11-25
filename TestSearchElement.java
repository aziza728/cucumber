package testmeapp.casestudy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
//import test.example1.UtilityClass;

public class TestSearchElement {
	WebDriver driver;
	@Given("^user is in the home page$")
	public void login() throws Throwable {
		driver=UtilityClass.openBrowser("Chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		  driver.findElement(By.name("userName")).sendKeys("lalitha");
		  driver.findElement(By.name("password")).sendKeys("Password123");
		  driver.findElement(By.name("Login")).click();
		  Assert.assertEquals("Home", driver.getTitle());
	}

	@When("^user enter  the product$")
	public void product() throws Throwable {
		WebElement ele=driver.findElement(By.name("products"));
		  ele.sendKeys("carr");
		
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  ele.sendKeys(Keys.BACK_SPACE);
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"myInputautocomplete-list\"]/div[1]"))).sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	@When("^click on find details$")
	public void find_details() throws Throwable {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	   
	}

	@Then("^user is in the search page$")
	public void search_page() throws Throwable {
	   Assert.assertEquals("Search", driver.getTitle());
	   driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	}


}
