package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ReportPortalMainPage extends BasePage {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(ReportPortalMainPage.class));

    @FindBy(xpath = "//*[contains(text(), 'You have no dashboards')]")
    private WebElement noDashboardText;

    @FindBy(xpath = "//a[contains(@class, \"pageBreadcrumbs__page\")]")
    private WebElement allDashBoardTitle;

    @FindBy(xpath = "//button[contains(@class, \"ghostButton\")][1]")
    private WebElement buttonAddNewDashboard;

    @FindBy(xpath = "//span[contains(text(), \"All Dashboards\")]")
    private WebElement allDashboards;

    @FindBy(xpath = "//span[contains(text(), \"Logout\")]")
    private WebElement userLogout;

    @FindBy(xpath = "//span[contains(@title, \"test dashboard name\")]")
    private WebElement dashboardTitleName;

    @FindBy(xpath = "//a[contains(@class, \"gridCell\") and contains(text(), \"test dashboard name\")]")
    private WebElement dashboardName;

    @FindBy(xpath = "//span[contains(text(), \"Add new widget\")]")
    private WebElement addNewWidgetButton;

    @FindBy(xpath = "//i[contains(@class, \"icon-delete\")][1]")
    private WebElement deleteDashboardIcon;

    @FindBy(xpath = "//span[contains(text(), \"Delete\")]")
    private WebElement deleteDashboardButton;

    @FindBy(xpath = "//button[contains(@type, \"button\") and contains(@class, \"bigButton__color-tomato\")]")
    private WebElement deleteDashboardButtonConfirmation;

    @FindBy(xpath = "//a[contains(@class, \"gridCell\")]")
    private WebElement dashboardRowName;

    public ReportPortalMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ReportPortalMainPage openPage() {
        //https://reportportal.epam.com/ui/#eka_2022_personal/dashboard
        driver.navigate().to(base_url.replaceFirst("login",System.getProperty("login") + "_personal/dashboard"));
        return this;
    }

    @Step("Get Empty Dahsboard")
    public String getEmptyDashboard() {
        return noDashboardText.getText();
    }

    @Step("Get New Dashboard Pop up window")
    public NewDashboartPopUp displayPopup() {
        buttonAddNewDashboard.click();
        return new NewDashboartPopUp(driver);
    }


    public ReportPortalMainPage deleteDashboardfromDashboardList(){
        deleteDashboardIcon.click();
        return this;
    }

    @Step("Delete Dashboard from Dashboard Screen")
    public ReportPortalMainPage deleteDashboardfromDashboardScreen(){
        deleteDashboardButton.click();
        waitForXpath(200,"//button[contains(@type, \"button\") and contains(@class, \"bigButton__color-tomato\")]");
        return this;
    }

    @Step("Confirm Dashboard Deletion")
    public ReportPortalMainPage confirmDashboardDeletion() {
        deleteDashboardButtonConfirmation.click();
        //waitForXpath(20,"//footer");
        return this;
    }

    @Step("Get Dashboard Name")
    public String  getDashboardRowName(){
        return dashboardRowName.getText();
    }

    @Step("Get particular Dashboard")
    public ReportPortalMainPage getParticularDashboardPage(){
        dashboardName.click();
        return this;
    }

    @Step("Logout User")
    public ReportLoginPage userLogout() {
        userLogout.click();
        return new ReportLoginPage(driver);
    }

}
