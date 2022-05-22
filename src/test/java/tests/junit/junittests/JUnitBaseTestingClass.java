package tests.junit.junittests;

import driver.DriverManager;
import model.User;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;

import pages.ReportLoginPage;
import pages.ReportPortalMainPage;


public class JUnitBaseTestingClass {

    protected DriverManager dm = new DriverManager();
    protected WebDriver driver;

//    @Before
//    public void setUp() {
//        driver = dm.getDriver();
//    }

    public ReportPortalMainPage loginToPortalMainPageOld(User testUser) {
        driver = dm.getDriver();
        return new ReportLoginPage(driver)
                .openPage()
                .loginToDashboardPage(testUser);
    }

    public ReportPortalMainPage loginToPortalMainPage(User testUser, String browser) {
        driver = dm.getDriver(browser);
        return new ReportLoginPage(driver)
                .openPage()
                .loginToDashboardPage(testUser);
    }

    @After
    public void stopBrowser() {
        if (driver != null) {
            dm.closeDriver();
            driver = null;
        }
    }
}
