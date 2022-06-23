package tests.api;

import models.dashboard.Dashboard;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import config.EndPointUrl;
import utils.Constants;
import utils.DashboardTestUtils;

import java.util.List;

public class LoginAndContentTest {
    private final Logger LOGGER = Logger.getLogger(LoginAndContentTest.class);

    @Test
    public void LoginAndCheckContentTest() {
        List<Dashboard> dashboards = DashboardTestUtils.getDashboards(EndPointUrl.DASHBOARD.getPath());
        Assertions.assertEquals(24, dashboards.get(0).getId());
        Assertions.assertEquals(12, dashboards.get(0).getWidgets().get(0).getWidgetId());
        LOGGER.info(Constants.LOGGER_PATTERN + "LoginAndCheckContentTest was completed successfully" + Constants.LOGGER_PATTERN);
    }
}
