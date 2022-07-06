package tests.api;

import config.EndPointUrl;
import models.dashboard.Dashboard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ApiRequests;
import utils.Constants;

import java.util.List;

public class LoginAndContentTest {

    @Test
    public void LoginAndCheckContentTest() {
        List<Dashboard> dashboards = ApiRequests.getDashboards(EndPointUrl.DASHBOARD.getPath());
        Assertions.assertEquals(24, dashboards.get(0).getId());
        Assertions.assertEquals(12, dashboards.get(0).getWidgets().get(0).getWidgetId());
        System.out.println(Constants.PRINT_PATTERN + "LoginAndCheckContentTest was completed successfully" + Constants.PRINT_PATTERN);
    }
}
