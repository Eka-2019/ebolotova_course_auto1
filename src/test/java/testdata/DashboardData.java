package testdata;

import models.dashboard.Dashboard;

public class DashboardData {

    public static Dashboard dashboardDataToPost() {
        Dashboard testDashboard = new Dashboard();
        testDashboard.setName("Demo Dashboard API" + System.currentTimeMillis());
        testDashboard.setDescription("Demo Dashboard API");
        testDashboard.setShare(true);
        return testDashboard;
    }
}
