package tests.junit.junittests;

import model.User;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.NewDashboartPopUp;
import pages.ReportPortalMainPage;
import service.UserCreator;
import tests.junit.junitrunner.JUnitParallelized;
import tests.testng.testngtests.AddDeleteDashboardTest;
import utils.Utils;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(JUnitParallelized.class)
public class JUnitAddDeleteDashboardTest extends JUnitBaseTestingClass {

    private final User testUser = UserCreator.withCredentialsFromProperty();
    private final Logger LOGGER = Logger.getLogger(AddDeleteDashboardTest.class);

    public JUnitAddDeleteDashboardTest(String testBrowser, String url, String login, String password, Matcher<String> expected) {
        super(testBrowser, url, login, password, expected);
    }

    @Test
    public void testAddNewDeleteDashboard() throws URISyntaxException {
        ReportPortalMainPage reportPage = loginToPortalMainPageOld(testUser);
        NewDashboartPopUp popupWindow = reportPage.displayPopup();
        ReportPortalMainPage reportPageAfterPopUp = popupWindow.FillPopUp("test dashboard name", "test dashboard name");

        assertThat(reportPageAfterPopUp.getDashboardTitleName().getText(), is("TEST DASHBOARD NAME"));
        LOGGER.info(reportPageAfterPopUp.getDashboardTitleName().getText());
        assertThat(reportPageAfterPopUp.getCurrentPageURL().getHost(), is(reportPage.getCurrentPageURL().getHost()));
        LOGGER.info(reportPageAfterPopUp.getCurrentPageURL().getHost());

        reportPageAfterPopUp.deleteDashboardfromDashboardScreen()
                .confirmDashboardDeletion();
        Utils.waitForXpath(reportPageAfterPopUp.getDriver(), 200, "//*[contains(text(), 'You have no dashboards')]");

        assertThat(reportPage.getEmptyDashboard(), is("You have no dashboards"));
        LOGGER.info(reportPage.getEmptyDashboard());
    }
}
