package tests.api;

import config.EndPointUrl;
import io.restassured.response.Response;
import models.dashboard.Dashboard;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.DashboardData;
import utils.Constants;
import utils.TestUtils;

public class DashboardTest {
    private final Logger LOGGER = Logger.getLogger(DashboardTest.class);

    private String testDashboardId;
    private Dashboard testDashboard = DashboardData.dashboardDataToPost();

    @BeforeEach
    private void createDashboardTest() {
        //create dashboard and get Id and name
        testDashboardId = TestUtils.getIdFromPostNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard);
        testDashboard = TestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard :" + testDashboard.toString() + " was created" + Constants.LOGGER_PATTERN);
        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard with Id" + testDashboardId + " was created" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void updateDashboardTest() {
        Dashboard dashboardForUpdate = TestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        dashboardForUpdate.setDescription("Demo Dashboard API description updated");
        dashboardForUpdate.setShare(false);

        Response updateResponse = TestUtils.updateDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId), dashboardForUpdate)
                .extract().response();
        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully updated", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Dashboard with Id" + testDashboardId + " was updated" + Constants.LOGGER_PATTERN);

        //check updated Data
        Dashboard dashboardAfterUpdate = TestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        Assertions.assertEquals(dashboardForUpdate, dashboardAfterUpdate);
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was updated" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void creationDashboardWithSameIdTest() {
        Response createResponseDuplication = TestUtils.postNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard)
                .extract().response();
        Assertions.assertEquals(409, createResponseDuplication.getStatusCode(), createResponseDuplication.jsonPath().getString("message"));
        LOGGER.info(Constants.LOGGER_PATTERN + "creationDashboardWithSameIdTest was completed successfully with Status code 409" + Constants.LOGGER_PATTERN);
    }

    @AfterEach
    public void DeleteDashboardTest() {
        Response deleteResponse = TestUtils.deleteObject(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();

        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully deleted.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Dashboard with Id" + testDashboardId + " was deleted" + Constants.LOGGER_PATTERN);

        //check deleted data
        Response getDeletedResponse = TestUtils.getDashboardReguest(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();
        Assertions.assertEquals("Dashboard with ID '" + testDashboardId + "' not found on project 'default_personal'. Did you use correct Dashboard ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was deleted" + Constants.LOGGER_PATTERN);
    }
}
