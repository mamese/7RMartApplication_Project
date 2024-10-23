package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	public WebDriver driver;


	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	WebElement AdminUserModule;
	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement ManageUserModule;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement NewUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement UserNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement UserTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement SaveButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

	
	public AdminPage clickManageUserModuleAdminPage() {
		ManageUserModule.click();
		return this;

	}
	public AdminPage clickNewUserButton() {
		NewUserButton.click();
		return this;
	}

	public AdminPage enterUserName(String username) {
		UserNameField.sendKeys(username);
		return this;
	}

	public  AdminPage  enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminPage selectUserType(String usertype) {
//		Select select=new Select( UserTypeDropDown);
//		select.selectByValue(usertype);
		PageUtility page=new PageUtility(driver);
		page.selectByValue(UserTypeDropDown, usertype);
		return this;
	}
	
	public  AdminPage clickSaveButton() {
		SaveButton.click();
		return this;
	}
	
	public boolean isAlertDisplay()
	
	{
		return alert.isDisplayed();
				
				
	}

}

