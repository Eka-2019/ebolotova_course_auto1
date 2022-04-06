package tests;

import model.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ReportPortalMainPage;

import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest {

    @Test
    @Parameters({"url","login","password"})
    public void testLoginViaDocker(String url, String login, String password) throws URISyntaxException {
        User testUser = new User(login, password);
        System.setProperty("url",url);

        ReportPortalMainPage loginPage = loginToPortalMainPage(testUser);

        assertThat(loginPage.getCurrentPageURL().toString(), is(url.replaceFirst("login",login + "_personal/dashboard")));
        assertThat(loginPage.getAllDashboards().getText(), is("ALL DASHBOARDS"));

    }
}