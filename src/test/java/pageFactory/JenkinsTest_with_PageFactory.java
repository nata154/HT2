package pageFactory;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JenkinsTest_with_PageFactory {

	String base_url = "localhost:8080";
	String userName = "nata154";
	String userPassword = "j7j42jj8";
	StringBuilder verificationErrors = new StringBuilder();
	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"c:/Program Files/eclipse-workspace/HT2/src/test/resources/chromedriver.exe");
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
	public void tst_JenkinsPageFactory() {
		driver.get(base_url);
		PageObject_ForFactory page = PageFactory.initElements(driver, PageObject_ForFactory.class);
		page.autorise(userName, userPassword);
		Assert.assertTrue(page.pageTextContains("Включить автообновление страниц"));

		// Manage Jenkins
		page.clickManageJenkins();
		Assert.assertTrue(page.pageContains_dtManageUsers("Управление пользователями"),
				"Can't find line dt while ManageUsers");
		Assert.assertTrue(
				page.pageContains_ddModifyUsers(
						"Создание, удаление и модификция пользователей, имеющих право доступа к Jenkins"),
				"Can't find line dd while ModifyUsers");

		// 2. Click ManageUser, available CreateUser
		page.find_CreateUser();
		page.check_ValuableForm5Fields();

		// 4. Enter data in form to create new user
		page.enterDataInForm();
		Assert.assertEquals(page.pageContains_lineNewUserName(), "someuser");

		// 5. Delete user
		page.deleteUser();
		Assert.assertEquals(page.pageContains_AreYouSureAboutDeleting(),
				"Вы уверены, что хотите удалить пользователя из Jenkins?");
		page.deleteUserSure();
		Assert.assertFalse(page.pageAbsent_lineUserName(), "Was found NewUser line while DeleteUser");// не падает, когда строка есть cтрока
		Assert.assertFalse(page.pageAbsent_isAbsentDeleteUser(), "Was found DeleteUser line while DeleteUser");// не падает, когда строка есть cтрока
		Assert.assertFalse(page.pageAbsent_isAbsentDeleteAdmin(), "Was found DeleteUserAdmin line while DeleteUser");// не падает, когда строка есть cтрока
	}

}
