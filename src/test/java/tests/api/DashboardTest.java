package tests.api;

import config.EndPointUrl;
import io.restassured.response.Response;
import models.dashboard.Dashboard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.DashboardData;
import utils.ApiRequests;
import utils.Constants;

public class DashboardTest {

    private String testDashboardId;
    private Dashboard testDashboard = DashboardData.dashboardDataToPost();

    @BeforeEach
    private void createDashboardTest() {
        //create dashboard and get Id and name
        testDashboardId = ApiRequests.getIdFromPostNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard);
        testDashboard = ApiRequests.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        System.out.println(Constants.PRINT_PATTERN + "TestDashboard :" + testDashboard.toString() + " was created" + Constants.PRINT_PATTERN);
        System.out.println(Constants.PRINT_PATTERN + "TestDashboard with Id" + testDashboardId + " was created" + Constants.PRINT_PATTERN);
    }

    @Test
    public void updateDashboardTest() {
        Dashboard dashboardForUpdate = ApiRequests.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        dashboardForUpdate.setDescription("Demo Dashboard API description updated");
        dashboardForUpdate.setShare(false);

        Response updateResponse = ApiRequests.updateDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId), dashboardForUpdate)
                .extract().response();
        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully updated", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Dashboard with Id" + testDashboardId + " was updated" + Constants.PRINT_PATTERN);

        //check updated Data
        Dashboard dashboardAfterUpdate = ApiRequests.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
        Assertions.assertEquals(dashboardForUpdate, dashboardAfterUpdate);
        System.out.println(Constants.PRINT_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was updated" + Constants.PRINT_PATTERN);
    }

    @Test
    public void creationDashboardWithSameIdTest() {
        Response createResponseDuplication = ApiRequests.postNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard)
                .extract().response();
        Assertions.assertEquals(409, createResponseDuplication.getStatusCode(), createResponseDuplication.jsonPath().getString("message"));
        System.out.println(Constants.PRINT_PATTERN + "creationDashboardWithSameIdTest was completed successfully with Status code 409" + Constants.PRINT_PATTERN);
    }

    @AfterEach
    public void DeleteDashboardTest() {
        Response deleteResponse = ApiRequests.deleteObject(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();

        Assertions.assertEquals("Dashboard with ID = '" + testDashboardId + "' successfully deleted.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Dashboard with Id" + testDashboardId + " was deleted" + Constants.PRINT_PATTERN);

        //check deleted data
        Response getDeletedResponse = ApiRequests.getReguest(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId))
                .extract().response();
        Assertions.assertEquals("Dashboard with ID '" + testDashboardId + "' not found on project 'default_personal'. Did you use correct Dashboard ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Checked that Dashboard with Id" + testDashboardId + " was deleted" + Constants.PRINT_PATTERN);
    }
}
