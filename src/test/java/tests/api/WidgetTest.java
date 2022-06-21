package tests.api;

import config.EndPointUrl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import models.Dashboard;
import models.Widget;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import utils.Constants;
import utils.DashboardTestUtils;

import java.util.List;

public class WidgetTest {

    private final Logger LOGGER = Logger.getLogger(WidgetTest.class);

    private String testWidgetId;
    private Widget testWidget = new Widget("Demo Widget API" + System.currentTimeMillis(), "Demo Widget API description", true, "oldLineChart");

    @Test
    public void getWidgetTest(){
//        testDashboardId = DashboardTestUtils.getIdFromPostNewDashboard(EndPointUrl.DASHBOARD.getPath(), testDashboard);
//        testDashboard = DashboardTestUtils.getDashboard(EndPointUrl.DASHBOARD.addPath("/" + testDashboardId));
//        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard :" + testWidget.toString() + " was created"+ Constants.LOGGER_PATTERN);
//        LOGGER.info(Constants.LOGGER_PATTERN + "TestDashboard with Id" + testWidget + " was created" + Constants.LOGGER_PATTERN);

//        Response getWidgests = DashboardTestUtils.getWidgetReguest(EndPointUrl.WIDGET.addPath(""))
//                .extract()
//                .response()
//                .statusCode(200);
//
//        System.out.println(getWidgests.toString());

        List<Widget> getAllWidgets = DashboardTestUtils.getWidgetReguest(EndPointUrl.WIDGET.addPath("/names/all"))
                .extract()
                .jsonPath()
                .getList("content.", Widget.class);
        System.out.println(getAllWidgets.toString());

    }

    @Test
    public void postWidget(){
        testWidgetId = DashboardTestUtils.getIdFromPostNewWidget(EndPointUrl.WIDGET.getPath(), testWidget);
        //testWidget = DashboardTestUtils.getWidgetReguest(EndPointUrl.DASHBOARD.addPath("/" + testWidgetId));
        LOGGER.info("");
        LOGGER.info(Constants.LOGGER_PATTERN + "TestWidget :" + testWidget.toString() + " was created"+ Constants.LOGGER_PATTERN);
        LOGGER.info(Constants.LOGGER_PATTERN + "TestWiget with Id" + testWidgetId + " was created" + Constants.LOGGER_PATTERN);

    }



}
