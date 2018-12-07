package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	private WebDriverWait wait;
	private WebDriver driver;
	
	String enter_username = "someuser";
	String enter_password = "somepassword";
	String enter_passwordAgain = "somepassword";
	String enter_fullName = "some Full Name";
	String enter_emailAdress = "some@addr.dom";
	
	// драйвер
	public PageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

	// искомые элементы на странице

	// авторизация
	By input_name = By.xpath("//input[@id='j_username']");
	By input_password = By.xpath("//input[@name='j_password']");
	By checkButton_rememberMe = By.xpath("//table/tbody/tr[3]/td[2]");
	By button_enterAuth = By.xpath("//button[@id='yui-gen1-button']");
	By enterRefresh = By.xpath("//a[contains(text(),'Включить автообновление страниц')]");
	
	//Manage Jenkins
	By manageJenkins = By.xpath("//a[contains(text(),'Настроить Jenkins')]");
	By isTitleEqual = By.xpath("//a[@title='Управление пользователями']");
	By dtManageUsers = By.xpath("//dt[contains(text(),'Управление пользователями')]");
	By ddModifyUsers = By.xpath("//dd[contains(text(),'Создание, удаление и модификция пользователей, имеющих право доступа к Jenkins')]");
	//	<a href="securityRealm/" title="Управление пользователями"><img src="/static/a9c90b93/images/48x48/user.png" alt="manage-option" class="icon"><dl><dt>Управление пользователями</dt><dd>Создание, удаление и модификция пользователей, имеющих право доступа к Jenkins</dd><dd></dd></dl></a>

	//Find create user
	By findCreateUser = By.xpath("//*[@id='tasks']/div[3]/a[2]");
	//By findCreateUser = By.xpath("//div[3]/div[1]/div[1]/div[3]/a[2]/b");
	//By findCreateUser = By.xpath("//div/div/div[@id='tasks']/div[3]/a[2]/b");
	//By findCreateUser = By.xpath("//b[contains(text(),'Создать пользователя')]");
	//By findCreateUser = By.xpath("//div[@class='task']/a[2]/b[contains(text(),'Создать пользователя')]");
	//By findCreateUser = By.xpath("//div/a[2]/b[contains(text(),'Создать пользователя')]");
	//By findCreateUser = By.xpath("//div[@class='task']/a[2]/b[contains(text(),'Создать пользователя')]");
	//By findCreateUser = By.xpath("//a[@href='addUser')]");
	//*[@id="tasks"]/div[3]/a[2]/b
	//By findCreateUser = By.xpath("//div[@id='tasks']/div[3]/a[2]/b");
	//By findCreateUser = By.cssSelector("#tasks > div:nth-child(3) > a.task-link > b");

	//FormHas5Fields
	By nameField = By.xpath("//*[@id='username']");
	By passwordField = By.xpath("//div[@id='main-panel']/form/div[1]/table/tbody/tr[2]/td[2]/input[@type='password']");
	By passwordFieldAgain = By.xpath("//div[@id='main-panel']/form/div[1]/table/tbody/tr[3]/td[2]/input[@type='password']");
	By FIO = By.xpath("//div[@id='main-panel']/form/div[1]/table/tbody/tr[4]/td[2]/input[@type='text']");
	By email = By.xpath("//div[@id='main-panel']/form/div[1]/table/tbody/tr[5]/td[2]/input[@type='text']");
	By buttonCreateUser = By.xpath("//button[@id='yui-gen4-button']");
	By lineNewUser = By.xpath("//table[@id='people']/tbody/tr[2]");
	By lineNewUserName = By.xpath("//*[@id='people']/tbody/tr[2]/td[2]/a");
	
	//Delete user
	//By deleteUser = By.xpath("//body/div[3]/div[2]/table[@id='people']/tbody/tr[2]/td[4]/a[2]");
	By deleteUser = By.xpath("//a[@href='user/someuser/delete']");
	//By deleteUser = By.xpath("//*[@id='people']/tbody/tr[2]/td[4]/a[2]");
	By deleteUserSure = By.xpath("//span[@id='yui-gen4']/span/button[@id='yui-gen4-button']");

	// Авторизация
	public PageObject autorise(String userName, String userPassword) {
		driver.findElement(input_name).clear();
		driver.findElement(input_name).sendKeys(userName);
		driver.findElement(input_name).click();
		driver.findElement(input_password).sendKeys(userPassword);
		driver.findElement(input_password).click();
		driver.findElement(checkButton_rememberMe).click();
		driver.findElement(button_enterAuth).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public boolean pageContains(String search_string) {
		return driver.findElement(enterRefresh).getText().contentEquals(search_string);
	}
	
	public boolean pageContains_dtManageUsers(String search_string) {
		return driver.findElement(dtManageUsers).getText().contentEquals(search_string);
	}
	
	public boolean pageContains_ddModifyUsers(String search_string) {
		return driver.findElement(ddModifyUsers).getText().contentEquals(search_string);
	}
	
	public boolean pageContains_lineNewUserName(String search_string) {
		return driver.findElement(lineNewUserName).getText().contentEquals(enter_username);
	}
	
	//Manage Jenkins
	public PageObject clickManageJenkins() {
		driver.findElement(manageJenkins).click();
		driver.findElement(dtManageUsers);
		driver.findElement(ddModifyUsers);
		return this;
	}
	
	//Find create user
	public PageObject find_CreateUser() {
		driver.findElement(dtManageUsers).click();
		driver.findElement(findCreateUser).isEnabled();
		driver.findElement(findCreateUser).click();
		return this;
	}
	
	public PageObject check_ValuableForm5Fields() {
		driver.findElement(nameField).clear();
		driver.findElement(passwordField).clear();
		driver.findElement(passwordFieldAgain).clear();
		driver.findElement(FIO).clear();
		driver.findElement(email).clear();
		return this;
	}
	
	public PageObject enterDataInForm() {
		driver.findElement(nameField).sendKeys(enter_username);
		driver.findElement(passwordField).sendKeys(enter_password);
		driver.findElement(passwordFieldAgain).sendKeys(enter_passwordAgain);
		driver.findElement(FIO).sendKeys(enter_fullName);
		driver.findElement(email).sendKeys(enter_emailAdress);
		driver.findElement(buttonCreateUser).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public PageObject deleteUser() {
		driver.findElement(deleteUser).click();
		driver.findElement(deleteUserSure).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	


}
