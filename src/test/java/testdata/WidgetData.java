package testdata;

import models.widget.ContentParameter;
import models.widget.Widget;
import models.widget.WidgetOption;

import java.util.List;

public class WidgetData {

    public static Widget widgetDataToPost() {
        Widget testWidget = new Widget();

        testWidget.setContentParameters(new ContentParameter(
                List.of("statistics$executions$total",
                        "statistics$executions$passed",
                        "statistics$executions$failed",
                        "statistics$executions$skipped",
                        "statistics$defects$product_bug$pb001",
                        "statistics$defects$automation_bug$ab001",
                        "statistics$defects$system_issue$si001",
                        "statistics$defects$to_investigate$ti001"),
                50, new WidgetOption(false, "launch", "area-spline")));

        testWidget.setFilterIds(List.of(11L));
        testWidget.setDescription("Demo Dashboard API");
        testWidget.setName("Demo Widget API" + System.currentTimeMillis());
        testWidget.setOwner("default");
        testWidget.setShare(true);
        testWidget.setWidgetType("statisticTrend");
        return testWidget;

    }
}
