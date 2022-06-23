package tests.api;

import config.EndPointUrl;
import models.widget.Widget;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import utils.Constants;
import utils.DashboardTestUtils;

import java.util.List;

public class WidgetTest {

    private final Logger LOGGER = Logger.getLogger(WidgetTest.class);
    private String testWidgetId;
    //private Widget testWidget = new Widget("Demo Widget API" + System.currentTimeMillis(), "Demo Widget API description", true, "oldLineChart", List.of("String1"));

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

        List<String> getAllWidgetNames = DashboardTestUtils.getWidgetReguest(EndPointUrl.WIDGET.addPath("/names/all"))
                .extract()
                .jsonPath()
                .getList("content.");
        System.out.println(getAllWidgetNames.toString());

    }

//    @Test
//    public void postWidget(){
//        testWidgetId = DashboardTestUtils.getIdFromPostNewWidget(EndPointUrl.WIDGET.getPath(), testWidget);
//        //testWidget = DashboardTestUtils.getWidgetReguest(EndPointUrl.DASHBOARD.addPath("/" + testWidgetId));
//        LOGGER.info("");
//        LOGGER.info(Constants.LOGGER_PATTERN + "TestWidget :" + testWidget.toString() + " was created"+ Constants.LOGGER_PATTERN);
//        LOGGER.info(Constants.LOGGER_PATTERN + "TestWiget with Id" + testWidgetId + " was created" + Constants.LOGGER_PATTERN);
//
//    }

    @Test
    public void getWidgetByID(){
        Widget widget = DashboardTestUtils.getWidget(EndPointUrl.WIDGET.addPath("/16"));
        //testWidget = DashboardTestUtils.getWidgetReguest(EndPointUrl.DASHBOARD.addPath("/" + testWidgetId));
        LOGGER.info(widget.toString());
    }



}
