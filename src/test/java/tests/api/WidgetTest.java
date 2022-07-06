package tests.api;

import config.EndPointUrl;
import io.restassured.response.Response;
import models.widget.Widget;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.WidgetData;
import utils.ApiRequests;
import utils.Constants;

public class WidgetTest {
    private final Widget testWidget = WidgetData.widgetDataToPost();
    private String testWidgetId;

    @BeforeEach
    public void postWidget() {
        testWidgetId = ApiRequests.getIdFromPostNewWidget(EndPointUrl.WIDGET.getPath(), testWidget);
        System.out.println(Constants.PRINT_PATTERN + "TestWiget with Id" + testWidgetId + " was created" + Constants.PRINT_PATTERN);
    }

    @Test
    public void updateWidgetTest() {
        Widget widgetForUpdate = ApiRequests.getWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId));
        widgetForUpdate.setDescription("Demo Widget API updated");
        widgetForUpdate.setShare(false);

        Response updateResponse = ApiRequests.updateWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId), widgetForUpdate)
                .extract().response();
        Assertions.assertEquals("Widget with ID = '" + testWidgetId + "' successfully updated.", updateResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, updateResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Widget with Id" + testWidgetId + " was updated" + Constants.PRINT_PATTERN);

        //check updated Data
        Widget widgetAfterUpdate = ApiRequests.getWidget(EndPointUrl.WIDGET.addPath("/" + testWidgetId));
        Assertions.assertEquals(widgetForUpdate.getDescription(), widgetAfterUpdate.getDescription());
        Assertions.assertEquals(widgetForUpdate.isShare(), widgetAfterUpdate.isShare());
        System.out.println(Constants.PRINT_PATTERN + "Checked that Widget with Id" + testWidgetId + " was updated" + Constants.PRINT_PATTERN);
    }

    @Test
    public void getWidgetByID() {
        Response getWidgetById = ApiRequests.getReguest(EndPointUrl.WIDGET.addPath("/16"))
                .extract().response();
        Assertions.assertEquals(200, getWidgetById.statusCode());
        Assertions.assertEquals("OVERALL STATISTICS PANEL", getWidgetById.jsonPath().getString("name"));
        Assertions.assertEquals("16", getWidgetById.jsonPath().getString("id"));
        Assertions.assertEquals("true", getWidgetById.jsonPath().getString("share"));
        Assertions.assertEquals("default", getWidgetById.jsonPath().getString("owner"));
        Assertions.assertEquals("[DEMO_FILTER]", getWidgetById.jsonPath().getString("appliedFilters.name"));
        System.out.println(Constants.PRINT_PATTERN + "TestWiget with Id" + getWidgetById.jsonPath().getString("id") + " was created" + Constants.PRINT_PATTERN);
    }

    @AfterEach
    public void DeleteWidgetTest() {
        Response deleteResponse = ApiRequests.deleteObject(EndPointUrl.DASHBOARD.addPath("/24/" + testWidgetId))
                .extract().response();

        Assertions.assertEquals("Widget with ID = '" + testWidgetId + "' was successfully deleted from the system.", deleteResponse.jsonPath().getString("message"));
        Assertions.assertEquals(200, deleteResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Widget with Id" + testWidgetId + " was deleted" + Constants.PRINT_PATTERN);

        //check deleted data
        Response getDeletedResponse = ApiRequests.getReguest(EndPointUrl.WIDGET.addPath("/" + testWidgetId))
                .extract().response();
        Assertions.assertEquals("Widget with ID '" + testWidgetId + "' not found on project 'default_personal'. Did you use correct Widget ID?", getDeletedResponse.jsonPath().getString("message"));
        Assertions.assertEquals(404, getDeletedResponse.getStatusCode());
        System.out.println(Constants.PRINT_PATTERN + "Checked that Widget with Id" + testWidgetId + " was deleted" + Constants.PRINT_PATTERN);
    }
}
