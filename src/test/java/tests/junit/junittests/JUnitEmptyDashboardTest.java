package tests.junit.junittests;

import model.User;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.ReportPortalMainPage;
import service.UserCreator;
import tests.junit.junitrunner.JUnitParallelized;
import tests.testng.testngtests.EmptyDashboardTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//@RunWith(Parameterized.class)
@RunWith(JUnitParallelized.class)
public class JUnitEmptyDashboardTest extends JUnitBaseTestingClass {
    private final User testUser = UserCreator.withCredentialsFromProperty();
    private final Logger LOGGER = Logger.getLogger(EmptyDashboardTest.class);

    public JUnitEmptyDashboardTest(String testBrowser, String url, String login, String password, Matcher<String> expected) {
        super(testBrowser, url, login, password, expected);
    }

    @Test
    public void testEmptyDashboard() {
        User testUser = new User(login, password);
        System.setProperty("url", url);
        ReportPortalMainPage reportPage = loginToPortalMainPageOld(testUser);

        assertThat(reportPage.getEmptyDashboard(), is("You have no dashboards"));
        LOGGER.info("There is no any dashboard: " + reportPage.getEmptyDashboard());
    }
}
