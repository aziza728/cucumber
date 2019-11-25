package testmeapp;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	ExtentReports extent;
	ExtentTest logger;
  @BeforeTest
  public void beforeTest() {
	  driver=UtilityClass.openBrowser("chrome");
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	// driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Reports.html", true);
		extent.addSystemInfo("Host Name", "TestMe");
		extent.addSystemInfo("Environment", "Selenium Testing");
		extent.addSystemInfo("User Name", "Aziza Suganthi");
  }
  public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshot/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
  @Test(priority=1)
  public void testRegistration() {
	  logger = extent.startTest("testRegistration");
	  driver.findElement(By.linkText("SignUp")).click();
	  Assert.assertEquals("Sign Up", driver.getTitle());
	 
	  driver.findElement(By.name("userName")).sendKeys("lalitha");
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
	  driver.findElement(By.name("firstName")).click();
	  WebElement username=driver.findElement(By.name("userName"));
	 username.click();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  String value=username.getAttribute("value");
	  //WebElement e=driver.findElement(By.xpath("//*[@id=\"err\"]"));
	 
	  System.out.println(value);
	  if(value.isEmpty()) {
		  WebElement e=driver.findElement(By.xpath("//*[@id=\"err\"]"));
		  String error=e.getText();
		  System.out.println(error);
		  Assert.assertEquals("Name Already Exists", error);
		  
		  driver.findElement(By.name("userName")).sendKeys("onetoonneget");
		  driver.findElement(By.name("firstName")).click();
		  //System.out.println("empty");
		  WebElement e1=driver.findElement(By.xpath("//*[@id=\"err\"]"));
		  String err=e1.getText();
		  System.out.println(err);
		  
		  //driver.findElement(By.name("userName")).sendKeys("mssanthi");
		  
		  //driver.findElement(By.name("userName")).sendKeys("medavakkamche");
			 // driver.findElement(By.xpath("//*[@id=\"err\"]"));
			  //driver.findElement(By.xpath("//*[@id=\"err\"]"));
		   wait=new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstName")));
			  driver.findElement(By.name("firstName")).sendKeys("mary");
			  driver.findElement(By.name("lastName")).sendKeys("santhi");
			  driver.findElement(By.name("password")).sendKeys("santhi123");
			  driver.findElement(By.name("confirmPassword")).sendKeys("santhi123");
			  driver.findElement(By.xpath("//input[@value='Female']")).click();
			  driver.findElement(By.name("emailAddress")).sendKeys("santhi123@gmail.com");
			  driver.findElement(By.name("mobileNumber")).sendKeys("9377579348");
			  driver.findElement(By.name("dob")).sendKeys("11/15/1998");
			  driver.findElement(By.name("address")).sendKeys("accenture,chennai");
			  Select sel=new Select(driver.findElement(By.name("securityQuestion")));
			  sel.selectByValue("411011");
			  driver.findElement(By.name("answer")).sendKeys("green");
			  driver.findElement(By.name("Submit")).click();
			  Assert.assertEquals("Login", driver.getTitle());
			  logger.log(LogStatus.PASS, "User Registered Succesfully !!");
	  }
	 
	  
	  
	  
  }
  @Test(priority=2)
  public void testLogin() {
	 // driver.findElement(By.linkText("SignIn")).click();
	  logger = extent.startTest("testLogin");
	  driver.findElement(By.name("userName")).sendKeys("lalitha");
	  driver.findElement(By.name("password")).sendKeys("Password123");
	  driver.findElement(By.name("Login")).click();
	  Assert.assertEquals("Home", driver.getTitle());
	  logger.log(LogStatus.PASS, "Login has Passed !!");
	 // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);--->implicit wait
	 //explicit wait 
	 // WebDriverWait wait=new WebDriverWait(driver,30);
	// wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Login")));
	  
  }
  @Test(priority=3)
  public void testCart() {
	  logger = extent.startTest("testCart");
	  act=new Actions(driver);
	  act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).build().perform();
	 // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  act.moveToElement(driver.findElement(By.linkText("Electronics"))).click();
	  act.moveToElement(driver.findElement(By.linkText("Electronics"))).build().perform();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  WebElement web=driver.findElement(By.linkText("Travel Kit"));
	  act.moveToElement(driver.findElement(By.linkText("Travel Kit"))).click();
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Travel Kit")));
	  //act.moveToElement(driver.findElement(By.linkText("Travel Kit"))).build().perform();
	  web.click();
	 
	 // driver.navigate().refresh();
	  //Assert.assertEquals("Search", driver.getTitle());
	  //Add to cart
	 WebElement a= driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"));
	a.click();
	  Assert.assertEquals("Search", driver.getTitle());
	  
		
	  //cart link is numbered
	  
	  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	  Assert.assertEquals("View Cart", driver.getTitle());
	  driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
	  Assert.assertEquals("Cart Checkout", driver.getTitle());
	  driver.findElement(By.name("ShippingAdd")).sendKeys("coimbatore");
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	  wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/h3")));
	  Assert.assertEquals("Payment Gateway", driver.getTitle());
	  logger.log(LogStatus.PASS, "Add to cart has Passed !!");
	  
	  
	  
	  
  }
  @Test(priority=4)
  public void testPayment() {
	  logger = extent.startTest("testPayment");
	  
	  wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Andhra Bank']")));
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	 // wait=new WebDriverWait(driver,30);
	 // wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Continue")));
	  driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	  driver.findElement(By.name("username")).sendKeys("123456");
	  driver.findElement(By.name("password")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  Assert.assertEquals("Order Details", driver.getTitle());
	 // driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
	 // driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  //SignOut
	 // driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
	  //Home
	  driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[1]")).click();
	  wait=new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/a")));
	Assert.assertEquals("Home", driver.getTitle());
	logger.log(LogStatus.PASS, "Payment SUCCESSFUL !!");
	  
	  
  }
  @AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getThrowable());
			String screenshotPath = OnlineShoppingTest.getScreenshot(driver, result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
	  driver.close();
  }

}
