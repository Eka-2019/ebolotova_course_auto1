package tests;

import model.User;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.EPAMLoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LoginTestWithEPAM extends BaseTest {


    @Test
    @Parameters({"url","login","password"})
    public void testLoginViaEPAMLoginPage(String url, String login, String password)  {
        User testUser = new User(login, password);
        System.setProperty("url",url);

        EPAMLoginPage loginPage = loginToPortalViaEPAMPage(testUser);

        assertThat(loginPage.getLogoText(), is("EPAM Systems"));
    }
}