package tests;

import model.User;
import org.testng.annotations.Test;
import pages.EPAMLoginPage;
import pages.ReportLoginPage;
import service.UserCreator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.net.URISyntaxException;

public class LoginTest extends CommonConditions {

    @Test
    public void testLoginToEPAMLoginPage() throws URISyntaxException {
        User testUser = UserCreator.withCredentialsFromProperty();

        EPAMLoginPage loginPage = new ReportLoginPage(driver)
                .openPage()
                .loginToEPAMLoginPage(testUser);

        assertThat(loginPage.getCurrentPageURL().getScheme(), is("https"));
        assertThat(loginPage.getCurrentPageURL().getHost(), is("login.epam.com"));
        assertThat(loginPage.getLogoText(), is("EPAM Systems"));
        System.out.println(loginPage.getLogoText());

    }
}