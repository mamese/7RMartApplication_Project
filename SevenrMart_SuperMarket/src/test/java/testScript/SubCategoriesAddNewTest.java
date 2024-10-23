package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoriesAddNewPage;
import utilities.ExcelUtility;

public class SubCategoriesAddNewTest extends Base{
	@Test
	
	public void verifyAddingSubCategoryWithValidDetails() throws IOException
	{
		
			String username = ExcelUtility.getStringData(0, 1, "LoginPage1");
			String password = ExcelUtility.getStringData(1, 1, "LoginPage1");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserNameField(username);
			loginpage.enterPasswordField(password);
			loginpage.clickSignInButton();
	// Initialize the page class
	        SubCategoriesAddNewPage subCategoriesPage = new SubCategoriesAddNewPage(driver);
	        subCategoriesPage.clickSubCategory();
	        String filePath = ExcelUtility.getStringData(0, 1, "Images");  // Get file path from Excel
	        subCategoriesPage.clickAddNewButton();
	        subCategoriesPage.selectCategory("167");
	        subCategoriesPage.enterSubCategory("ChickenLeg");
	        subCategoriesPage.chooseFile(filePath);
	        subCategoriesPage.clickSaveButton();
	        //String filePath
	}
	

}
