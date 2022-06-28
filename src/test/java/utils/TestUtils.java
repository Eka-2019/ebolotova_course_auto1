package utils;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import models.dashboard.Dashboard;
import models.widget.Widget;
import org.apache.log4j.Logger;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.GetBaseURL.BASE_URI;

public class TestUtils {
    final static String TOKEN = utils.GetToken.getToken();
    private static final Logger LOGGER = Logger.getLogger(TestUtils.class);

    public static ValidatableResponse getReguest(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .get(path)
                .then();
    }

    public static ValidatableResponse getDashboardReguest(String path) {
        return getReguest(path);
    }

    public static ValidatableResponse getWidgetReguest(String path) {
        return getReguest(path);
    }

    public static Widget getWidget(String path) {
        return getWidgetReguest(path).extract()
                .jsonPath().getObject(".", Widget.class);
    }

    public static Dashboard getDashboard(String path) {
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

    public static ValidatableResponse postNewObject(String path, Object obj) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(obj)
                .when()
                .post(path)
                .then();
    }

    public static ValidatableResponse postNewDashboard(String path, Dashboard dashboard) {
        return postNewObject(path, dashboard);
    }

    public static ValidatableResponse postNewWidget(String path, Widget widget) {
        return postNewObject(path, widget);
    }

    public static ValidatableResponse postNewJSON(String path, String json) {
        return postNewObject(path, json);
    }

    public static String getIdFromPostNewWidget(String path, Widget widget) {
        ValidatableResponse vr = postNewWidget(path, widget);
        LOGGER.info(vr.extract().response().jsonPath().getString("message"));
        return vr
                .statusCode(201)
                .extract()
                .response()
                .jsonPath()
                .getString("id");
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

    public static ValidatableResponse updateObject(String path, Object object) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .header("Content-type", "application/json")
                .body(object)
                .when()
                .put(path)
                .then();
    }

    public static ValidatableResponse updateDashboard(String path, Dashboard dashboard) {
        return updateObject(path, dashboard);
    }

    public static ValidatableResponse updateWidget(String path, Widget widget) {
        return updateObject(path, widget);
    }

    public static ValidatableResponse deleteObject(String path) {
        RestAssured.baseURI = BASE_URI;
        return given()
                .auth()
                .oauth2(TOKEN)
                .when()
                .delete(path)
                .then();
    }

}
