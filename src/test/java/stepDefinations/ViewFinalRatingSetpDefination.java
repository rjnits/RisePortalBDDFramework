package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ViewFinalRatingSetpDefination {
	
	public WebDriver driver;
	
	@Given("^user logged in Home page$")
	public void user_logged_in_Home_page() throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		try {
		Runtime.getRuntime().exec("C:\\Users\\raju.das\\Desktop\\Window\\WindowAuthScript.exe");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		driver.get("https://rise.trianz.com");
		Thread.sleep(5000);
	}

	@Then("^mouse hover to Apprisal and Click on My Apprisal link$")
	public void mouse_hover_to_Apprisal_and_Click_on_My_Apprisal_link()  {
	    
		WebElement apprisal =driver.findElement(By.xpath("//span[text()='APPRAISAL']"));
		Actions action =new Actions(driver);
		action.moveToElement(apprisal).perform();
		driver.findElement(By.xpath("//a[text()='My Appraisal']")).click();
	}

	@Then("^click on view final rating$")
	public void click_on_view_final_rating() throws InterruptedException  {
		
		driver.findElement(By.xpath("//label[contains(text(),' Annual Appraisal 2018-19' )]//parent::span[@class='display']//parent::td//following-sibling::td//a[text()='View Final Rating']")).click();
		Thread.sleep(5000);
	}

	@Then("^user move to the bottom of the page$")
	public void user_move_to_the_bottom_of_the_page()  {
	 
		JavascriptExecutor js = (JavascriptExecutor)driver;  //Create instance of Java Script executor
    	
        WebElement rating = driver.findElement(By.xpath("//label[text()='Final Rating']"));
        js.executeScript("arguments[0].scrollIntoView(true);",rating);
	}

	@Then("^verify that final rating is available$")
	public void verify_that_final_rating_is_available()  {
		
		String actual= driver.findElement(By.xpath("//span[text()='3-Meets Expectations' or text()='4-Exceeds Expectations' or text()='5-Exceeds All Expectations' ]")).getText();
		System.out.println(actual);
		Assert.assertTrue(actual.equals("3-Meets Expectations") || actual.equals("4-Exceeds Expectations") || actual.equals("5-Exceeds All Expectations"));
//	    driver.close();
	}

	@After("@third")
    public void tearDown() {
    	driver.close();
    }
}

