package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.service.FakerIDN;

import constants.Constants;
import pages.AdminUserReset;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtilities;

public class AdminUserResetTest extends Base {
	HomePage homepage;
	AdminPage adminuserpage;
	AdminUserReset adminreset;
	FakerUtilities faker;

	@Test
	@Parameters({ "usernameToUpdate", "newPassword","newUsername", "newUserType" })
	public void verifyUpdatingUser(String usernameToUpdate,String newPassword,String newUsername, String newUserType)
			throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(ExcelUtility.getStringData(0, 1, "LoginPage1"))
				.enterPasswordField(ExcelUtility.getStringData(1, 1, "LoginPage1"));
		homepage = loginpage.clickSignInButton();

		adminuserpage = homepage.clickAdminUserModule();
		adminuserpage.clickManageUserModuleAdminPage();

		adminreset = homepage.adminClickResetButton();// Click the reset button
		adminreset.updateUser(usernameToUpdate,newPassword,newUsername,newUserType); // Update user details
		boolean alertDisplayed = adminreset.isAlertDisplayed();
		assertTrue(alertDisplayed, Constants.UNABLETOADDERRORMSG);
	}
}
