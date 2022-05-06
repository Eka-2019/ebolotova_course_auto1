package steps;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import model.User;
import pages.ReportLoginPage;
import pages.ReportPortalMainPage;
import service.UserCreator;
import utils.Utils;

@AllArgsConstructor
public class LoginPageSteps {

    private ReportLoginPage page;

    @Step("Open Login Page")
    public void openLoginPage () {
        page.openPage();
    }

    @Step("Enter User Credentials")
    public void enterUserCredentials(User user) {
        page.getLoginField().sendKeys(user.getLogin());
        page.getPasswordField().sendKeys(user.getPassword());
    }

    @Step("Click Login Button")
    public void clickLoginButton() {
        page.getLogin().click();
    }

    @Step("Get Report Portal Main Page")
    public ReportPortalMainPage getReportPortalMainPage() {
        ReportPortalMainPage pageAfterLogin = new ReportPortalMainPage(page.getDriver());
        //pageAfterLogin.waitForXpath(2000, "//footer");
        Utils.waitForXpath(page.getDriver(), 2000, "//footer");
        return pageAfterLogin;
    }

    @Step("Login into Report Portal")
    public ReportPortalMainPage loginIntoReportPortal(ReportLoginPage page) {
        User testUser = UserCreator.withCredentialsFromProperty();
        page.openPage();
        page.getLoginField().sendKeys(testUser.getLogin());
        page.getPasswordField().sendKeys(testUser.getPassword());
        page.getLogin().click();
        ReportPortalMainPage pageAfterLogin = new ReportPortalMainPage(page.getDriver());
        Utils.waitForXpath(pageAfterLogin.getDriver(), 2000, "//footer");
        return pageAfterLogin;
    }
}
