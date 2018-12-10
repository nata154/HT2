package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject_ForFactory {
	private WebDriverWait wait;
	private WebDriver driver;

	String enter_username = "someuser";
	String enter_password = "somepassword";
	String enter_passwordAgain = "somepassword";
	String enter_fullName = "some Full Name";
	String enter_emailAdress = "some@addr.dom";

	public String getEnter_username() {
		return enter_username;
	}

	public void setEnter_username(String enter_username) {
		this.enter_username = enter_username;
	}

	// драйвер
	public PageObject_ForFactory(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

	// искомые элементы на странице

	// авторизация
	@FindBy(xpath = "//input[@id='j_username']")
	private WebElement input_name;

	@FindBy(xpath = "//input[@name='j_password']")
	private WebElement input_password;

	@FindBy(xpath = "//table/tbody/tr[3]/td[2]")
	private WebElement checkButton_rememberMe;

	@FindBy(xpath = "//button[@id='yui-gen1-button']")
	private WebElement button_enterAuth;

	@FindBy(xpath = "//a[contains(text(),'Включить автообновление страниц')]")
	private WebElement enterRefresh;

	// Manage Jenkins
	@FindBy(xpath = "//a[contains(text(),'Настроить Jenkins')]")
	private WebElement manageJenkins;

	@FindBy(xpath = "//a[@title='Управление пользователями']")
	private WebElement isTitleEqual;

	@FindBy(xpath = "//dt[contains(text(),'Управление пользователями')]")
	private WebElement dtManageUsers;

	@FindBy(xpath = "//dd[contains(text(),'Создание, удаление и модификция пользователей, имеющих право доступа к Jenkins')]")
	private WebElement ddModifyUsers;

	// Find create user
	@FindBy(xpath = "//div[@id='tasks']/div[3]/a[2]")
	private WebElement findCreateUser;

	// FormHas5Fields
	@FindBy(xpath = "//*[@id='username']")
	private WebElement nameField;

	@FindBy(xpath = "//div[@id='main-panel']/form/div[1]/table/tbody/tr[2]/td[2]/input[@type='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@id='main-panel']/form/div[1]/table/tbody/tr[3]/td[2]/input[@type='password']")
	private WebElement passwordFieldAgain;

	@FindBy(xpath = "//div[@id='main-panel']/form/div[1]/table/tbody/tr[4]/td[2]/input[@type='text']")
	private WebElement FIO;

	@FindBy(xpath = "//div[@id='main-panel']/form/div[1]/table/tbody/tr[5]/td[2]/input[@type='text']")
	private WebElement email;

	// Create new user
	@FindBy(xpath = "//button[@id='yui-gen4-button']")
	private WebElement buttonCreateUser;

	@FindBy(xpath = "//table[@id='people']/tbody/tr[3]")
	private WebElement lineNewUser;
	// "//table[@id='people']/tbody/tr[3]"

	@FindBy(xpath = "//*[@id='people']/tbody/tr[3]/td[2]/a")
	private WebElement lineNewUserName;

	// Delete user
	@FindBy(xpath = "//a[@href='user/someuser/delete']")
	private WebElement deleteUser;

	@FindBy(xpath = "//span[@id='yui-gen4']/span/button[@id='yui-gen4-button']")
	private WebElement deleteUserSure;

	@FindBy(xpath = "//div[@id='main-panel']/form[@name='delete']")
	private WebElement areYouSureAboutDeleting;

	@FindBy(xpath = "//table[@id='people']/tbody/tr[3]/td[4]/a[2]")
	private WebElement isAbsendDeleteUser;

	@FindBy(xpath = "//table[@id='people']/tbody/tr/td/a[@href='user/admin/delete']")
	private WebElement isAbsendDeleteAdmin;

	// реализация методов
	public boolean pageTextContains(String search_string) {
		return enterRefresh.getText().contains(search_string);
	}

	public boolean pageContains_dtManageUsers(String search_string) {
		return dtManageUsers.getText().contentEquals(search_string);
	}

	public boolean pageContains_ddModifyUsers(String search_string) {
		return ddModifyUsers.getText().contentEquals(search_string);
	}
	
	public boolean pageContains_AreYouSureAboutDeleting(String search_string) {
		return areYouSureAboutDeleting.getText().contentEquals(search_string);
	}

	public boolean pageContains_lineNewUserName(String enter_username) {
		try {
			lineNewUserName.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean pageAbsent_lineUserName() {
		try {
			lineNewUser.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean pageAbsent_isAbsentDeleteUser() {
		try {
			isAbsendDeleteUser.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean pageAbsent_isAbsentDeleteAdmin() {
		try {
			isAbsendDeleteAdmin.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Авторизация
	public PageObject_ForFactory autorise(String userName, String userPassword) {
		input_name.clear();
		input_name.sendKeys(userName);
		input_name.click();
		input_password.sendKeys(userPassword);
		input_password.click();
		checkButton_rememberMe.click();
		button_enterAuth.click();
		return this;
	}

	// Manage Jenkins
	public PageObject_ForFactory clickManageJenkins() {
		manageJenkins.click();
		// dtManageUsers.click();//&&&&
		// ddModifyUsers.click();//&&&&
		return this;
	}

	// Find create user
	public PageObject_ForFactory find_CreateUser() {
		dtManageUsers.click();
		findCreateUser.isEnabled();
		findCreateUser.click();
		return this;
	}

	public PageObject_ForFactory check_ValuableForm5Fields() {
		nameField.clear();
		passwordField.clear();
		passwordFieldAgain.clear();
		FIO.clear();
		email.clear();
		return this;
	}

	public PageObject_ForFactory enterDataInForm() {
		nameField.sendKeys(enter_username);
		passwordField.sendKeys(enter_password);
		passwordFieldAgain.sendKeys(enter_passwordAgain);
		FIO.sendKeys(enter_fullName);
		email.sendKeys(enter_emailAdress);
		buttonCreateUser.click();
		return this;
	}

	public PageObject_ForFactory deleteUser() {
		deleteUser.click();
		return this;
	}

	public PageObject_ForFactory deleteUserSure() {
		deleteUserSure.click();
		return this;
	}

}
