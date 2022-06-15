package tests.api;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.Test;
import pages.EndPointUrl;
import org.junit.jupiter.api.*;

public class DashboardTest {
    private final Logger LOGGER = Logger.getLogger(DashboardTest.class);

    public JSONObject jsonForCreation(){
        JSONObject newDashboardJSONbody = new JSONObject();
        newDashboardJSONbody.put("description", "Demo Dashboard API desc");
        newDashboardJSONbody.put("name", "Demo Dashboard API" + System.currentTimeMillis());
        newDashboardJSONbody.put("share", true);
        return newDashboardJSONbody;
    }

    @Test
    public void createUpdateDeleteDashboardTest() {
        JSONObject newDashboardJSONbody = jsonForCreation();

        //create dashboard and get Id and name
        String dashboardID = DashboardTestUtils.getIdFromPostNewDashboard(EndPointUrl.DASHBOARD.getPath(), newDashboardJSONbody.toString());
        String dashboardName = DashboardTestUtils.getDashboardNameById(EndPointUrl.DASHBOARD.addPath("/" + dashboardID));
        LOGGER.info("*****   Dashboard with Id" + dashboardID + " was created  *****");

        //Update dashboard
        JSONObject updatedDashboardJSONbody = new JSONObject();
        updatedDashboardJSONbody.put("name", dashboardName);
        updatedDashboardJSONbody.put("description", "Demo Dashboard API description updated");
        updatedDashboardJSONbody.put("share", false);

        Response updateResponse = DashboardTestUtils.updateDashboard(EndPointUrl.DASHBOARD.addPath("/" + dashboardID), updatedDashboardJSONbody.toString())
                .extract().response();
        Assertions.assertEquals("Dashboard with ID = '" + dashboardID + "' successfully updated", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        LOGGER.info("*****   Dashboard with Id" + dashboardID + " was updated  *****");

        //check updated Data
        Response getUpdatedResponse = DashboardTestUtils.getDashboardReguest(EndPointUrl.DASHBOARD.addPath("/" + dashboardID))
                .extract().response();
        Assertions.assertEquals("Demo Dashboard API description updated", getUpdatedResponse.jsonPath().getString("description"));
        Assertions.assertEquals("false", getUpdatedResponse.jsonPath().getString("share"));
        Assertions.assertEquals(200, getUpdatedResponse.getStatusCode());
        LOGGER.info("*****   Checked that Dashboard with Id" + dashboardID + " was updated  *****");

        //Delete dashboard
        Response deleteResponse = DashboardTestUtils.deleteDashboard(EndPointUrl.DASHBOARD.addPath("/" + dashboardID))
                .extract().response();

        Assertions.assertEquals("Dashboard with ID = '" + dashboardID + "' successfully deleted.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        LOGGER.info("*****   Dashboard with Id" + dashboardID + " was deleted  *****");

        //check that Dashboard was deleted
        Response getDeletedResponse = DashboardTestUtils.getDashboardReguest(EndPointUrl.DASHBOARD.addPath("/" + dashboardID))
                .extract().response();
        Assertions.assertEquals("Dashboard with ID '" + dashboardID + "' not found on project 'default_personal'. Did you use correct Dashboard ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        LOGGER.info("*****   Checked that Dashboard with Id" + dashboardID + " was deleted  *****");
    }

    @Test
    public void creationDashboardWithSameIdTest() {
        JSONObject newDashboardJSONbody = jsonForCreation();

        Response createResponse = DashboardTestUtils.postNewDashboard(EndPointUrl.DASHBOARD.addPath(""),newDashboardJSONbody.toString())
                .extract().response();

        Response createResponseDuplication = DashboardTestUtils.postNewDashboard(EndPointUrl.DASHBOARD.addPath(""),newDashboardJSONbody.toString())
                .extract().response();

        Assertions.assertEquals(201, createResponse.getStatusCode());
        Assertions.assertEquals(409, createResponseDuplication.getStatusCode());
        LOGGER.info("*****   creationDashboardWithSameIdTest was completed successfully   *****");
    }
}
