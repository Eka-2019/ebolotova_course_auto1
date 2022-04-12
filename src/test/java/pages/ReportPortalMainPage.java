package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPortalMainPage extends AbstractPage{
    private final String BASE_URL = "https://reportportal.epam.com/ui/#eka_2022_personal/dashboard";

    @FindBy(xpath = "//*[contains(text(), 'You have no dashboards')]")
    private WebElement noDashboardText;

    @FindBy(xpath = "//span[contains(text(), \"Add New Dashboard\")][1]")
    private WebElement buttonAddNewDashboard;

    @FindBy(xpath = "//a[contains(text(), \"All Dashboards\")]")
    private WebElement allDashboards;

    @FindBy(xpath = "//span[contains(text(), \"Logout\")]")
    private WebElement userLogout;

    @FindBy(xpath = "//span[contains(text(), \"test dashboard name\")]")
    private WebElement dashboardName;

    @FindBy(xpath = "//span[contains(text(), \"Add new widget\")]")
    private WebElement addNewWidgetButton;

    public ReportPortalMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ReportPortalMainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getEmptyDashboardText() {
        return noDashboardText.getText();
    }

    public NewDashboartPopUp displayPopup() {
        buttonAddNewDashboard.click();
        return new NewDashboartPopUp(driver);
    }



    public String getDashboardName(){
        return dashboardName.getText();
    }

    public ReportLoginPage userLogout() throws InterruptedException {
        userLogout.click();
        return new ReportLoginPage(driver);
    }


}
