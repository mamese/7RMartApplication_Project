package testScript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@DataProvider(name="credentials",indices = {0,1})
	public Object[][] testData() {// data provider
		Object[][] input = new Object[2][2];
		input[0][0] = "admin";
		input[0][1] = "admin";
		input[1][0] = "admin@123";
		input[1][1] = "admin123";
		return input;
		}
	@Test
	public void verifyUserIsAbleToLoginInUsingValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 1,"LoginPage1");
		String password =ExcelUtility.getStringData(1, 1,"LoginPage1");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username);
		loginPage.enterPasswordField(password);
		loginPage.clickSignInButton();
		boolean isHomePageLoaded = loginPage.isDashboardDisplayed();
		assertTrue(isHomePageLoaded,Constants.ERRORMESSAGEFORLOGINPAGE);
	}
@Test
	public void verifyUserIsNotAbleToLoginInUsingInValidPassword() {
		String username = "admin";
		String password = "Megha123";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username);
		loginPage.enterPasswordField(password);   
		loginPage.clickSignInButton();
		//boolean isHomePageLoaded = loginPage.isDashboardDisplayed();
		//assertFalse(isHomePageLoaded, "Home Page not loaded due to invalid credentials");
		boolean isAlertLoaded = loginPage.isAlertDisplayed();
		assertTrue(isAlertLoaded, "Home Page not loaded due to invalid credentials");
	}
@Test(dataProvider = "credentials")
public void verifyUserIsNotAbleToLoginInUsingInValidUsername(String username,String password) {
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterUserNameField(username);
	loginPage.enterPasswordField(password);   
	loginPage.clickSignInButton();
	//boolean isHomePageLoaded = loginPage.isDashboardDisplayed();
	//assertFalse(isHomePageLoaded, "Home Page not loaded due to invalid credentials");
	boolean isAlertLoaded = loginPage.isAlertDisplayed();
	assertTrue(isAlertLoaded, "Home Page not loaded due to invalid credentials");
}
@Test(groups = {"smoke"})
@Parameters({"username","password"})
public void verifyUserIsNotAbleToLoginInUsingInValidCredentials(String username,String password) {
	LoginPage loginPage = new LoginPage(driver);
	loginPage.enterUserNameField(username);
	loginPage.enterPasswordField(password);   
	loginPage.clickSignInButton();
	//boolean isHomePageLoaded = loginPage.isDashboardDisplayed();
	//assertFalse(isHomePageLoaded, "Home Page not loaded due to invalid credentials");
	boolean isAlertLoaded = loginPage.isAlertDisplayed();
	assertTrue(isAlertLoaded, "Home Page not loaded due to invalid credentials");
}


}
