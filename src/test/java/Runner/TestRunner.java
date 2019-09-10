package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)				
@CucumberOptions(
			features="C:\\Users\\raju.das\\eclipse-workspace\\RisePortalBDDFramework\\src\\main\\java\\Features\\verifyHomePageTitle.feature",
	        glue={"stepDefinations"},
			format= {"pretty","html:test-output"},
			plugin={"com.cucumber.listener.ExtentCucumberFormatter:test-output/ExtentReport.html"},
			monochrome=true,
			dryRun=false
			        
)						

public class TestRunner {
	
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
//	Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "Raju Das");
	Reporter.setSystemInfo("Application Name", "Rise Performance management portal");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}

}




