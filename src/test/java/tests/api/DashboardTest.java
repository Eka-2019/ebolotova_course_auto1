package tests.api;

import io.restassured.response.Response;
import models.dashboard.Dashboard;
import org.apache.log4j.Logger;
import config.EndPointUrl;
import org.junit.jupiter.api.*;
import utils.Constants;
import utils.DashboardTestUtils;

public class DashboardTest {
    private final Logger LOGGER = Logger.getLogger(DashboardTest.class);

    private String testDashboardId;
    private Dashboard testDashboard = new Dashboard("Demo Dashboard API" + System.currentTimeMillis(), "Demo Dashboard API", true);

    @BeforeEach
    private void createDashboardTest() {
        //create dashboard and get Id and name
        testDashboardId = DashboardTestUtils.getIdFromPostNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard);
        testDashboard = DashboardTestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard :" + testDashboard.toString() + " was created"+ Constants.LOGGER_PATTERN);
        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard with Id" + testDashboardId + " was created" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void updateDashboardTest() {
        Dashboard dashboardForUpdate = DashboardTestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        dashboardForUpdate.setDescription("Demo Dashboard API description updated");
        dashboardForUpdate.setShare(false);

        Response updateResponse = DashboardTestUtils.updateDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId), dashboardForUpdate)
                .extract().response();
        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully updated", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Dashboard with Id" + testDashboardId + " was updated" + Constants.LOGGER_PATTERN);

        //check updated Data
        Dashboard dashboardAfterUpdate = DashboardTestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        Assertions.assertEquals(dashboardForUpdate, dashboardAfterUpdate);
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was updated" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void creationDashboardWithSameIdTest() {
        Response createResponseDuplication = DashboardTestUtils.postNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard)
                .extract().response();
        Assertions.assertEquals(409, createResponseDuplication.getStatusCode(), createResponseDuplication.jsonPath().getString("message"));
        LOGGER.info(Constants.LOGGER_PATTERN + "creationDashboardWithSameIdTest was completed successfully with Status code 409" + Constants.LOGGER_PATTERN);
    }

    @AfterEach
    public void DeleteDashboardTest() {
        Response deleteResponse = DashboardTestUtils.deleteDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();

        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully deleted.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Dashboard with Id" + testDashboardId + " was deleted" + Constants.LOGGER_PATTERN);

        //check deleted data
        Response getDeletedResponse = DashboardTestUtils.getDashboardReguest(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();
        Assertions.assertEquals("Dashboard with ID '" + testDashboardId + "' not found on project 'default_personal'. Did you use correct Dashboard ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was deleted" + Constants.LOGGER_PATTERN);
    }
}
