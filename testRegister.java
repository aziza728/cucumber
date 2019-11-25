package testmeapp.casestudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
//import testmeapp.UtilityClass;

public class testRegister {
	WebDriver driver;
	@Given("^User is in the sign up page$")
public void user_is_in_the_sign_up_page() throws Throwable {
		  driver=UtilityClass.openBrowser("chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.findElement(By.linkText("SignUp")).click();
		  Assert.assertEquals("Sign Up", driver.getTitle());
}

@Given("^user enters the user name \"([^\"]*)\"$")
public void user_enters_the_user_name(String arg1) throws Throwable {
	  driver.findElement(By.name("userName")).sendKeys(arg1);
}

@Given("^user enters the first name \"([^\"]*)\"$")
public void user_enters_the_first_name(String arg1) throws Throwable {
	 driver.findElement(By.name("firstName")).sendKeys(arg1);
}

@Given("^user enters the last name \"([^\"]*)\"$")
public void user_enters_the_last_name(String arg1) throws Throwable {
	 driver.findElement(By.name("lastName")).sendKeys(arg1);
}
@Given("^user enters password and confirm password \"([^\"]*)\" && \"([^\"]*)\"$")
public void user_enters_password_and_confirm_password(String arg1, String arg2) throws Throwable {
	 driver.findElement(By.name("password")).sendKeys(arg1);
	  driver.findElement(By.name("confirmPassword")).sendKeys(arg2);
}
@Given("^user selects the gender$")
public void user_selects_the_gender() throws Throwable {
	  driver.findElement(By.xpath("//input[@value='Female']")).click();
}

@Given("^user enters the contact email and mobile number \"([^\"]*)\" && \"([^\"]*)\"$")
public void user_enters_the_contact_email_and_mobile_number(String arg1, String arg2) throws Throwable {
	 driver.findElement(By.name("emailAddress")).sendKeys(arg1);
	  driver.findElement(By.name("mobileNumber")).sendKeys(arg2);
}

@Given("^user enters the dob \"([^\"]*)\"$")
public void user_enters_the_dob(String arg1) throws Throwable {
	  driver.findElement(By.name("dob")).sendKeys(arg1);
}

@Given("^user enters the address \"([^\"]*)\"$")
public void user_enters_the_address(String arg1) throws Throwable {
	 driver.findElement(By.name("address")).sendKeys(arg1);
}

@Given("^user selects the security question and enters the answer \"([^\"]*)\"$")
public void user_selects_the_security_question_and_enters_the_answer(String arg1) throws Throwable {
	 Select sel=new Select(driver.findElement(By.name("securityQuestion")));
	  sel.selectByValue("411011");
	  driver.findElement(By.name("answer")).sendKeys(arg1);
}

@When("^User click on the signUp button$")
public void user_click_on_the_signUp_button() throws Throwable {
	 driver.findElement(By.name("Submit")).click();
}

@Then("^User navigated to login page$")
public void user_navigated_to_login_page() throws Throwable {
	 Assert.assertEquals("Login", driver.getTitle());
}




}
