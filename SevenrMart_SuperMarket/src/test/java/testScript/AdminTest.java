package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import constants.Constants;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminTest extends Base {
	public HomePage homepage;
	public AdminPage admin;

	@Test
	@Parameters({ "username", "password", "newUsername", "newPassword","newUserType" })

	public void verifyAddingNewUser(String username, String password, String newUsername, String newPassword,String newUserType)
			throws IOException {
//		String username=ExcelUtility.getStringData(0, 1, "LoginPage1");
//		String password=ExcelUtility.getStringData(1, 1, "LoginPage1");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginPage.clickSignInButton();
		admin = homepage.clickAdminUserModule();
		admin.clickManageUserModuleAdminPage();
		admin.clickNewUserButton();
		admin.enterUserName(newUsername);
		admin.enterPassword(newPassword);
		admin.selectUserType(newUserType);
		admin.clickSaveButton();
		boolean alertDisplay = admin.isAlertDisplay();
		assertTrue(alertDisplay, Constants.ERRORMESSAGEFORLOGINPAGE);

	}

}
