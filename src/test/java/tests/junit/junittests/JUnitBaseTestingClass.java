package tests.junit.junittests;

import driver.DriverManager;
import model.User;
import org.hamcrest.Matcher;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.junit.After;

import pages.ReportLoginPage;
import pages.ReportPortalMainPage;
import tests.junit.junitrunner.JUnitParallelized;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;

@RunWith(JUnitParallelized.class)
public class JUnitBaseTestingClass {

    protected DriverManager dm = new DriverManager();
    protected WebDriver driver;

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

    protected final String testBrowser;
    protected final String url;
    protected final String login;
    protected final String password;
    protected Matcher<String> expected;

    public JUnitBaseTestingClass(String testBrowser, String url, String login, String password, Matcher<String> expected) {
        this.testBrowser = testBrowser;
        this.url = url;
        this.login = login;
        this.password = password;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Test with testBrowser={0}, url={1}, login={2}, password={3}, result: {4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"chrome","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("You have no dashboards")},
                {"firefox","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("You have no dashboards")}
                //  {"ie","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("You have no dashboards")},
                //  {"edge","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("You have no dashboards")},
        });
    }

    @After
    public void stopBrowser() {
        if (driver != null) {
            dm.closeDriver();
            driver = null;
        }
    }
}
