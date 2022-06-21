package utils;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;
import models.Dashboard;
import models.Widget;
import org.apache.log4j.Logger;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.GetBaseURL.BASE_URI;

public class DashboardTestUtils {
    private static final Logger LOGGER = Logger.getLogger(DashboardTestUtils.class);

    final static String TOKEN = utils.GetToken.getToken();
    //final static String BASE_URI = "http://localhost:8080/api/v1/default_personal";

    public static ValidatableResponse getDashboardReguest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(path)
                .then();
    }

    public static ValidatableResponse getWidgetReguest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(path)
                .then();
    }

    public static Dashboard getDashboard(String path){
        return getDashboardReguest(path).extract()
                .jsonPath().getObject(".", Dashboard.class);
    }

    public static List<Dashboard> getDashboards(String path) {
           return getDashboardReguest(path).extract()
                   .jsonPath().getList("content.", Dashboard.class);
    }

    public static String getDashboardNameById(String path) {
        ValidatableResponse vr = getDashboardReguest(path);
        return vr
                .extract()
                .response()
                .jsonPath()
                .getString("name");
    }

    public static ValidatableResponse postNewDashboard(String path, String json) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post(path)
                .then();
    }

    public static ValidatableResponse postNewWidget(String path, Widget wiget) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(wiget)
                .when()
                .post(path)
                .then();
    }

    public static String getIdFromPostNewWidget(String path, Widget widget) {
        ValidatableResponse vr = postNewWidget(path, widget);
        LOGGER.info(vr.extract().response().jsonPath().getString("message"));
        return vr
                .statusCode(201)
                .extract()
                .response()
                .jsonPath()
                .getString("widgetId");

    }

    public static ValidatableResponse postNewDashboard(String path, Dashboard dashboard) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(dashboard)
                .when()
                .post(path)
                .then();
    }

    public static ValidatableResponse putNewDashboard(String path, Dashboard dashboard) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(dashboard)
                .when()
                .post(path)
                .then();
    }

    public static String getIdFromPostNewDashboard(String path, Dashboard dashboard) {
        ValidatableResponse vr = postNewDashboard(path, dashboard);
        return vr
                .statusCode(201)
                .extract()
                .response()
                .jsonPath()
                .getString("id");
    }

    public static ValidatableResponse updateDashboard(String path, Dashboard dashboard) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(dashboard)
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
