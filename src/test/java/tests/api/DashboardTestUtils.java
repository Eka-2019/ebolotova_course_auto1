package tests.api;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import static io.restassured.RestAssured.given;

public class DashboardTestUtils {
    private final Logger LOGGER = Logger.getLogger(DashboardTestUtils.class);

    final static String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTUzMDc2OTgsInVzZXJfbmFtZSI6ImRlZmF1bHQiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMjYzNjdlMDAtNzI2OS00OGU1LWFlOTctOGNjZTllNGM2OTliIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.lZU1N5-vw_k7CA6R4QDMvhcF_XnK9Flc_9g6BwS0c8g";
    final static String BASE_URI = "http://localhost:8080/api/v1/default_personal";

    public static ValidatableResponse getDashboardReguest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(path)
                .then();
    }

    public static String getDashboardNameById(String path) {
        ValidatableResponse vr = getDashboardReguest(path);
        return vr
                .extract()
                .response()
                .jsonPath()
                .getString("name");
    }

    public static ValidatableResponse postNewDashboard(String path, String body) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(path)
                .then();
    }

    public static String getIdFromPostNewDashboard(String path, String body) {
        ValidatableResponse vr = postNewDashboard(path, body);
        return vr
                .extract()
                .response()
                .jsonPath()
                .getString("id");
    }

    public static ValidatableResponse updateDashboard(String path, String body) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .put(path)
                .then();
    }

    public static ValidatableResponse deleteDashboard(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete(path)
                .then();
    }
}
