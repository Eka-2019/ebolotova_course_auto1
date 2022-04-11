package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewDashboartPopUp {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
    private WebElement nameField;

    @FindBy(xpath = "//textarea[@placeholder='Enter dashboard description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[contains(@class, \"inputBigSwitcher\")]")
    private WebElement shareSwitch;

    @FindBy(xpath = "//button[contains(text(), \"Add\")]")
    private WebElement addButton;

    public NewDashboartPopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public ReportPortalMainPage fillNameFiled(String dashboardName, String description) throws InterruptedException {
        nameField.sendKeys(dashboardName);
        descriptionField.sendKeys(description);
        addButton.click();
        Thread.sleep(2000);
        return new ReportPortalMainPage(driver);
    }

}
