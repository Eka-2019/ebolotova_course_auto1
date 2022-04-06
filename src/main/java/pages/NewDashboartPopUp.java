package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewDashboartPopUp extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(NewDashboartPopUp.class));

    @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
    private WebElement nameField;

    @FindBy(xpath = "//textarea[@placeholder='Enter dashboard description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[contains(@class, \"inputBigSwitcher\")]")
    private WebElement shareSwitch;

    @FindBy(xpath = "//button[contains(text(), \"Add\")]")
    private WebElement addButton;

    @Override
    protected BasePage openPage() {
        return null;
    }

    public NewDashboartPopUp(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    @Step("Login to Report Portal Main Page")
    public ReportPortalMainPage fillNameFiled(String dashboardName, String description) throws InterruptedException {
        nameField.sendKeys(dashboardName);
        descriptionField.sendKeys(description);
        addButton.click();
        ReportPortalMainPage resultPage = new ReportPortalMainPage(driver);
        resultPage.waitForXpath(2000, "//a[contains(@class, \"pageBreadcrumbs__page\")]");
    return resultPage;
    }

}
