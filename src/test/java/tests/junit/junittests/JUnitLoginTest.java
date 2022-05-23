package tests.junit.junittests;

import model.User;
import org.apache.log4j.Logger;
import org.hamcrest.Matcher;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import pages.ReportPortalMainPage;
import tests.junit.junitrunner.JUnitParallelized;
import tests.testng.testngtests.LoginTest;

import java.net.URISyntaxException;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

//@RunWith(Parameterized.class)
@RunWith(JUnitParallelized.class)
public class JUnitLoginTest extends JUnitBaseTestingClass {
    private final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    public JUnitLoginTest(String testBrowser, String url, String login, String password, Matcher<String> expected) {
        super(testBrowser, url, login, password, expected);
    }

    @Parameterized.Parameters(name = "{index}: Test with testBrowser={0}, url={1}, login={2}, password={3}, result: {4}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"chrome","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("ALL DASHBOARDS")},
                {"firefox","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("ALL DASHBOARDS")}
              //  {"ie","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("ALL DASHBOARDS")},
              //  {"edge","https://rp.epam.com/ui/#login", "eka_2022", "Qweasd_123?", is("ALL DASHBOARDS")},
        });
    }

    @Test
    public void testLogin() throws URISyntaxException {
        User testUser = new User(login, password);
        System.setProperty("url", url);
        LOGGER.info("User login and password: " + login + ", " + password);
        ReportPortalMainPage loginPage = loginToPortalMainPage(testUser, testBrowser);

        assertThat("https://" + loginPage.getCurrentPageURL().getHost() + "/ui/#login", is(url));
        LOGGER.info("Tests run: " + loginPage.getCurrentPageURL().getHost());
        assertThat(loginPage.getAllDashboards().getText(), is(expected));
        LOGGER.info("Header of page: " + loginPage.getAllDashboards().getText());
    }
}