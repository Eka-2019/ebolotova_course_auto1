package tests;

import model.User;
import org.testng.annotations.Test;
import pages.NewDashboartPopUp;
import pages.ReportPortalMainPage;
import service.UserCreator;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DashboardTests extends BaseTest {

    private final User testUser = UserCreator.withCredentialsFromProperty();

    @Test(priority = 1)
    public void testEmptyDashboard() {
        ReportPortalMainPage reportPage = loginToPortalMainPage(testUser);

        assertThat(reportPage.getEmptyDashboard(), is("You have no dashboards"));
    }

    @Test(priority = 2)
    public void testAddNewDeleteDashboard() throws InterruptedException, URISyntaxException {
        ReportPortalMainPage reportPage = loginToPortalMainPage(testUser);
        NewDashboartPopUp popupWindow = reportPage.displayPopup();
        ReportPortalMainPage reportPageAfterPopUp = popupWindow.fillNameFiled("test dashboard name", "test dashboard name");

        assertThat(reportPageAfterPopUp.getDashboardTitleName().getText(), is("TEST DASHBOARD NAME"));
        assertThat(reportPageAfterPopUp.getCurrentPageURL().getHost(), is(reportPage.getCurrentPageURL().getHost()));

        reportPageAfterPopUp.deleteDashboardfromDashboardScreen()
                .confirmDashboardDeletion()
                .waitForXpath(200,"//*[contains(text(), 'You have no dashboards')]");

        assertThat(reportPage.getEmptyDashboard(), is("You have no dashboards"));
        System.out.print(reportPage.getEmptyDashboard());
    }

}
