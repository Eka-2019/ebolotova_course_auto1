package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class NewDashboartPopUp extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
    private WebElement nameField;

    @FindBy(xpath = "//textarea[@placeholder='Enter dashboard description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//div[contains(@class, \"inputBigSwitcher\")]")
    private WebElement shareSwitch;

    @FindBy(xpath = "//div[contains(@class, \"modalFooter__buttons-block--14nRL\")]//div[2]//button")
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
    public ReportPortalMainPage FillPopUp (String dashboardName, String description) {
        nameField.sendKeys(dashboardName);
        descriptionField.sendKeys(description);
        addButton.click();
        ReportPortalMainPage resultPage = new ReportPortalMainPage(driver);

        Utils.waitForXpath(driver, 2000, "//a[contains(@class, \"pageBreadcrumbs__page\")]");
//        resultPage.waitForXpath(2000, "//a[contains(@class, \"pageBreadcrumbs__page\")]");
    return resultPage;
    }
}
