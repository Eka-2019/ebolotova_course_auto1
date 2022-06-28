package tests.api;

import config.EndPointUrl;
import io.restassured.response.Response;
import models.widget.Widget;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.WidgetData;
import utils.Constants;
import utils.TestUtils;

public class WidgetTest {

    private final Logger LOGGER = Logger.getLogger(WidgetTest.class);
    private String testWidgetId;
    private final Widget testWidget = WidgetData.widgetDataToPost();

    @BeforeEach
    public void postWidget() {
        testWidgetId = TestUtils.getIdFromPostNewWidget(EndPointUrl.WIDGET.getPath(), testWidget);
        LOGGER.info(Constants.LOGGER_PATTERN + "TestWiget with Id" + testWidgetId + " was created" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void updateWidgetTest() {
        Widget widgetForUpdate = TestUtils.getWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId));
        widgetForUpdate.setDescription("Demo Widget API updated");
        widgetForUpdate.setShare(false);

        Response updateResponse = TestUtils.updateWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId), widgetForUpdate)
                .extract().response();
        Assertions.assertEquals("Widget with ID = '" + testWidgetId + "' successfully updated.", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Widget with Id" + testWidgetId + " was updated" + Constants.LOGGER_PATTERN);

        //check updated Data
        Widget widgetAfterUpdate = TestUtils.getWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId));
        Assertions.assertEquals(widgetForUpdate.getDescription(), widgetAfterUpdate.getDescription());
        Assertions.assertEquals(widgetForUpdate.isShare(), widgetAfterUpdate.isShare());
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Widget with Id" + testWidgetId + " was updated" + Constants.LOGGER_PATTERN);
    }

    @Test
    public void getWidgetByID() {
        Response getWidgetById = TestUtils.getWidgetReguest(EndPointUrl.WIDGET.addPath("/16"))
                .extract().response();
        Assertions.assertEquals(200, getWidgetById.statusCode());
        Assertions.assertEquals("OVERALL STATISTICS PANEL", getWidgetById.jsonPath().getString("name"));
        Assertions.assertEquals("16", getWidgetById.jsonPath().getString("id"));
        Assertions.assertEquals("true", getWidgetById.jsonPath().getString("share"));
        Assertions.assertEquals("default", getWidgetById.jsonPath().getString("owner"));
        Assertions.assertEquals("[DEMO_FILTER]", getWidgetById.jsonPath().getString("appliedFilters.name"));
        LOGGER.info(Constants.LOGGER_PATTERN + "TestWiget with Id" + getWidgetById.jsonPath().getString("id") + " was created" + Constants.LOGGER_PATTERN);
    }

    @AfterEach
    public void DeleteWidgetTest() {
        Response deleteResponse = TestUtils.deleteObject(EndPointUrl.DASHBOARD.addPath("/24/" + testWidgetId))
                .extract().response();

        Assertions.assertEquals("Widget with ID = '" + testWidgetId + "' was successfully deleted from the system.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Widget with Id" + testWidgetId + " was deleted" + Constants.LOGGER_PATTERN);

        //check deleted data
        Response getDeletedResponse = TestUtils.getWidgetReguest(EndPointUrl.WIDGET.addPath("/" + testWidgetId))
                .extract().response();
        Assertions.assertEquals("Widget with ID '" + testWidgetId + "' not found on project 'default_personal'. Did you use correct Widget ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        LOGGER.info(Constants.LOGGER_PATTERN + "Checked that Widget with Id" + testWidgetId + " was deleted" + Constants.LOGGER_PATTERN);
    }
}
