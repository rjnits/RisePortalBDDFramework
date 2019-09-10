package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerifyMidYearApprisalStepDefinations {
	
	public static WebDriver driver;
	
	@Given("^user on Home page$")
	public void user_on_Home_page() throws InterruptedException {
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
	
	@Then("^mouse hover to Apprisal and Click on My Apprisal$")
	public void mouse_hover_to_Apprisal_and_Click_on_My_Apprisal() throws Throwable {
		
		WebElement apprisal =driver.findElement(By.xpath("//span[text()='APPRAISAL']"));
		Actions action =new Actions(driver);
		action.moveToElement(apprisal).perform();
		driver.findElement(By.xpath("//a[text()='My Appraisal']")).click();
		
	    
	}

	@Then("^click on latest self assement$")
	public void click_on_latest_self_assement() throws InterruptedException  {
		
		driver.findElement(By.xpath("//label[contains(text(),' Mid-year Assessment 2019-20' )]//parent::span[@class='display']//parent::td//following-sibling::td//a[text()='Self-Assessment']")).click();
		Thread.sleep(5000);
	}

	@Then("^move to the bottom of the page$")
	public void move_to_the_bottom_of_the_page()  {
		
		   JavascriptExecutor js = (JavascriptExecutor)driver;  //Create instance of Java Script executor
	    	
	        WebElement text1 = driver.findElement(By.xpath("//*[contains(text(),'Activity by')]"));
	        js.executeScript("arguments[0].scrollIntoView(true);",text1);
	}
	
	
	@Then("^verify the status of goal setting$")
	public void verify_the_status_of_goal_setting(){
		
		String actual= driver.findElement(By.xpath("//*[contains(text(),'Activity by')]")).getText();
		Assert.assertEquals(actual.substring(actual.length()-"Goal Setting Approved".length()),"Goal Setting Approved");
//		driver.close();
	}

	@After("@second")
    public void tearDown() {
    	driver.close();
    }
	
}
