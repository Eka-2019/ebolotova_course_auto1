package tests.api;

import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApiLoginTest {
    private final Logger LOGGER = Logger.getLogger(ApiLoginTest.class);

    @Test
    public void testLogin() throws URISyntaxException {
        //RestAssured.baseURI = URL_KEY;
        RestAssured.baseURI = "http://localhost:8080/ui";
        //RestAssured.authentication = basic("username", "password");

        RestAssured.useRelaxedHTTPSValidation();
        given()
                .when()
                .get(baseURI + "/#login").time()
                then()
                .
        given()
                .auth()
                .basic("default", "1q2w3e")
        .then()
                .statusCode(200)
                .header("title", "Report Portal")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .body("copyright", equalTo("Stanislav Volskiy"));


//        assertThat("https://"+loginPage.getCurrentPageURL().getHost()+"/ui/#login", is(url));
//        //assertThat(loginPage.getCurrentPageURL().toString(), is(url.replaceFirst("login", login + "_personal/dashboard")));
//        LOGGER.info("Tests run: "+ loginPage.getCurrentPageURL().getHost());
//        assertThat(loginPage.getAllDashboards().getText(), is("ALL DASHBOARDS"));
//        LOGGER.info("Header of page: " + loginPage.getAllDashboards().getText());
    }

}
