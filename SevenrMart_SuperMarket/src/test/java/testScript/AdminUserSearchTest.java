package testScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.AdminUserSearchPage;
import pages.AdminPage;
import pages.LoginPage;

public class AdminUserSearchTest extends Base {
	@Test
	public void verifySearchingAnExistingUserAndTypeCombination() {
	String username = "admin";
	String password = "admin";
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNameField(username);
	loginpage.enterPasswordField(password);
	loginpage.clickSignInButton();
	AdminUserSearchPage adminUsersPage = new AdminUserSearchPage(driver);
	adminUsersPage.clickAdminUserSearchButton();
	adminUsersPage.clickAdminUserSearchButton();
	AdminUserSearchPage adminUserSearchPage=new AdminUserSearchPage(driver);
	adminUserSearchPage.clickAdminUserSearchButton();
	adminUserSearchPage.enterUserName("Douglass");
	adminUserSearchPage.selectUserType(2);
	adminUserSearchPage.clickSerachButton();
	// Check if the value is present in the table
	        boolean isPresent = adminUserSearchPage.isValuePresentInTable("Douglass");
	        // Assert to verify the presence of the value
	        assertTrue(isPresent, "User value not found in the search results table.");
	}
	}



