package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.PageUtility;

public class SubCategoriesAddNewPage {
public	WebDriver driver;

public SubCategoriesAddNewPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);	
}
@FindBy(xpath = "//p[text()='Sub Category']")
WebElement subCategory;
@FindBy(xpath = "//a[@onclick='click_button(1)']")
WebElement addNewButton;
@FindBy(xpath = "//select[@name='cat_id']")
WebElement selectCategory;
@FindBy(xpath = "//input[@id='subcategory']")
WebElement subCategoryField;
@FindBy(xpath = "//input[@name='main_img']")
WebElement chooseFile;
@FindBy(xpath = "//button[text()='Save']")
WebElement saveButton;


public void clickSubCategory() {
	subCategory.click();
}
public void clickAddNewButton() {
	addNewButton.click();
}
public void selectCategory(String value) {
	PageUtility pg=new PageUtility(driver);
	pg.selectByValue(selectCategory, value);
}
public void enterSubCategory(String subCatgory) {
	subCategoryField.sendKeys(subCatgory);
}
public void chooseFile(String filepath) {
	chooseFile.sendKeys(filepath);
}
public void uploadFileUsingRobot(String filePath) throws AWTException {
    chooseFile.click();  // Open the file upload dialog

    // Use Robot class to type the file path and upload
    FileUploadUtility fileUploadUtil = new FileUploadUtility();
    fileUploadUtil.fileUploadUsingRobotClass(chooseFile, filePath);
}
public void clickSaveButton() {
	saveButton.click();
}
}

