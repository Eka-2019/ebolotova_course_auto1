package tests.api;

import models.Dashboard;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EndPointUrl;
import utils.Constants;
import utils.DashboardTestUtils;

import java.util.List;

public class LoginAndTestContent {
    private final Logger LOGGER = Logger.getLogger(LoginAndTestContent.class);

    @Test
    public void LoginAndCheckContentTest() {
        List<Dashboard> dashboards = DashboardTestUtils.getDashboards(EndPointUrl.DASHBOARD.getPath());
        Assertions.assertEquals(24, dashboards.get(0).getId());
        Assertions.assertEquals(12, dashboards.get(0).getWidgets().get(0).getWidgetId());
        LOGGER.info(Constants.LOGGER_PATTERN + "LoginAndCheckContentTest was completed successfully" + Constants.LOGGER_PATTERN);
    }
}
