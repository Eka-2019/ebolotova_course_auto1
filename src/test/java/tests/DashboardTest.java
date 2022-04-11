package tests;

import model.User;
import org.testng.annotations.Test;
import pages.NewDashboartPopUp;
import pages.ReportPortalMainPage;
import service.UserCreator;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DashboardTest extends CommonConditions{

    private User testUser = UserCreator.withCredentialsFromProperty();


    @Test
    public void testEmptyDashboard() throws InterruptedException {

        ReportPortalMainPage reportPage = loginToPortalMainPage(testUser);
        Thread.sleep(2000);
        assertThat(reportPage.getEmptyDashboardText(), is("You have no dashboards"));

    }

    @Test
    public void testAddNewDashboard() throws InterruptedException, URISyntaxException {
        ReportPortalMainPage reportPage = loginToPortalMainPage(testUser);
        Thread.sleep(2000);
        NewDashboartPopUp popupWindow = reportPage.displayPopup();
        ReportPortalMainPage reportPageAfterPopUp = popupWindow.fillNameFiled("test dashboard name", "test description");

        assertThat(reportPageAfterPopUp.getDashboardName(), is("TEST DASHBOARD NAME"));
        assertThat(reportPageAfterPopUp.getCurrentPageURL().getHost(), is(reportPage.getCurrentPageURL().getHost()));

    }

    @Test
    public void testDeleteDashboard() throws InterruptedException {
        ReportPortalMainPage reportPage = loginToPortalMainPage(testUser);
        Thread.sleep(2000);


    }

}
