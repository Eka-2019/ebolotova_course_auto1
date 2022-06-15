package tests.api;

import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.EndPointUrl;

import static org.hamcrest.Matchers.*;

public class LoginAndTestContent {
    private final Logger LOGGER = Logger.getLogger(LoginAndTestContent.class);

    @Test
    public void LoginAndCheckContentTest() {
        ValidatableResponse response = DashboardTestUtils.getDashboardReguest(EndPointUrl.DASHBOARD.getPath());

        response.statusCode(200)
                .body("content.get(0).id", equalTo(24))
                .body("content.get(0).widgets.widgetId", hasItems(12, 13, 14, 15, 16, 17, 18))
        ;
        LOGGER.info("*****   LoginAndCheckContentTest was completed successfully   *****");
    }



}
