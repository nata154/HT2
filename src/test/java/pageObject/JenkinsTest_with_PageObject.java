package pageObject;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JenkinsTest_with_PageObject {
	
	StringBuilder verificationErrors = new StringBuilder();
	WebDriver driver = null;
	
	String base_url = "localhost:8080";
	String userName = "nata154";
	String userPassword = "j7j42jj8";
	

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "c:/Program Files/eclipse-workspace/HT2/src/test/resources/chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches", Arrays.asList("--homepage=about:blank"));
		driver = new ChromeDriver(capabilities);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}

	@Test
	public void openPage() {
		driver.get(base_url);
		PageObject page = new PageObject(driver);
		page.autorise(userName, userPassword);
		Assert.assertTrue(page.pageContains("Включить автообновление страниц"));
	}

}
