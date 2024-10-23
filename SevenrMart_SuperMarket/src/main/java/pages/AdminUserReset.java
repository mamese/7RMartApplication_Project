package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

import java.util.List;
import org.openqa.selenium.By;

public class AdminUserReset {
    public WebDriver driver;
    private PageUtility pageUtilities;

    public AdminUserReset(WebDriver driver) {
        this.driver = driver;
        this.pageUtilities = new PageUtility(driver);
        PageFactory.initElements(driver, this);
    }

  
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
    WebElement userTable;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//select[@id='user_type']")
    WebElement userTypeDropDown;

    @FindBy(xpath = "//h5[text()=' Alert!']")
    WebElement alert;

    

    public AdminUserReset updateUser(String username, String newUsername, String newPassword, String newUserType) {
        List<WebElement> rows = userTable.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr"));

        for (WebElement row : rows) {
            if (row.findElement(By.xpath("td[1]")).getText().contains(username)) {
                WebElement updateButton = row.findElement(By.xpath(".//i[@class='fas fa-edit']"));
                updateButton.click();

                updateUsernameField(newUsername);
                updatePasswordField(newPassword);
                pageUtilities.selectByValue(userTypeDropDown, newUserType) ;// Using PageUtilities

                WebElement updateSubmitButton = driver.findElement(By.xpath("//button[@name='Update']"));
                updateSubmitButton.click();
                break;
            }
        }
		return this;
    }

    public AdminUserReset updateUsernameField(String newUsername) {
        usernameField.clear();
        usernameField.sendKeys(newUsername);
		return this;
    }

    public AdminUserReset updatePasswordField(String newPassword) {
        passwordField.clear();
        passwordField.sendKeys(newPassword);
		return this;
    }

    public boolean isAlertDisplayed() {
        return alert.isDisplayed(); // Using PageUtilities
    }
}