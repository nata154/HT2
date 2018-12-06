package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
	private WebDriverWait wait;
	private WebDriver driver;

	// искомые элементы на странице

	// авторизация
	By input_name = By.xpath("//input[@id='j_username']");
	By input_password = By.xpath("//input[@name='j_password']");
	By checkButton_rememberMe = By.xpath("//table/tbody/tr[3]/td[2]");
	By button_enterAuth = By.xpath("//button[@id='yui-gen1-button']");
	By enterRefresh = By.xpath("//a[contains(text(),'Включить автообновление страниц')]");

	//

	// драйвер
	public PageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
	}

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
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public boolean pageContains(String search_string) {
		return driver.findElement(enterRefresh).getText().contentEquals(search_string);
	}

}
