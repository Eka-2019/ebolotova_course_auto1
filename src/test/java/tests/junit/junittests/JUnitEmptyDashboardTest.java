package tests.junit.junittests;

import model.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import pages.ReportPortalMainPage;
import service.UserCreator;
import tests.testng.testngtests.EmptyDashboardTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JUnitEmptyDashboardTest extends JUnitBaseTestingClass {
    private final User testUser = UserCreator.withCredentialsFromProperty();
    private final Logger LOGGER = Logger.getLogger(EmptyDashboardTest.class);

    @Test
    public void testEmptyDashboard() {
        ReportPortalMainPage reportPage = loginToPortalMainPageOld(testUser);

        assertThat(reportPage.getEmptyDashboard(), is("You have no dashboards"));
        LOGGER.info("There is no any dashboard: " + reportPage.getEmptyDashboard());
    }
}
