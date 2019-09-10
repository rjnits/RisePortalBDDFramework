package stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.AfterClass;
import org.junit.Assert;

public class VerifyHomaPageStepDefination {
	
	public WebDriver driver;
	
	@Before
	public void setUp() {
		
	}
	
	@Given("^user on login page$")
	public void user_on_login_page() {
		
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
//		driver = new HtmlUnitDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     }
	
	
	@When("^user enters username and password and click submit button$")
	public void user_enters_username_and_password_and_click_submit_button() throws IOException  {
		
		Runtime.getRuntime().exec("C:\\Users\\raju.das\\Desktop\\Window\\WindowAuthScript.exe");
		driver.get("https://rise.trianz.com");
	    }

	@Then("^verify user is on home page$")
	public void user_is_on_home_page() {
		
		String actual_title= driver.getTitle();
	    System.out.println(actual_title);
	    Assert.assertEquals(actual_title,"Performance Management");
	}

	@After("@first")
    public void tearDown() {
    	driver.close();
    }
	
}

