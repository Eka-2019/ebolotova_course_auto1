package tests;

import driver.DriverManager;
import io.qameta.allure.Step;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.EPAMLoginPage;
import pages.ReportLoginPage;
import pages.ReportPortalMainPage;


//@Listeners({TestListener.class})
public class BaseTest {

    protected DriverManager dm = new DriverManager();
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = dm.getDriver();

    }

    @Step("Login to Report Portal as normal User")
    public ReportPortalMainPage loginToPortalMainPage(User testUser) {
        return new ReportLoginPage(driver)
                .openPage()
                .loginToDashboardPage(testUser);
    }

    public ReportPortalMainPage loginToPortalMainPage_new(User testUser) {
        return new ReportLoginPage(driver)
                .openPage()
                .loginToDashboardPage(testUser);
    }

    @Step("Login to Report Portal as EPAM User")
    public EPAMLoginPage loginToPortalViaEPAMPage(User testUser) {
        return new ReportLoginPage(driver)
                .openPage()
                .loginViaEPAMLoginPage(testUser);
    }

    @AfterMethod
    public void stopBrowser() {
        if (driver != null) {
            dm.closeDriver();
            driver = null;
        }
    }

}
