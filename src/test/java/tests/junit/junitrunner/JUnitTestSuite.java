package tests.junit.junitrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.junittests.JUnitAddDeleteDashboardTest;
import tests.junit.junittests.JUnitEmptyDashboardTest;
import tests.junit.junittests.JUnitLoginTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        JUnitLoginTest.class,
        JUnitEmptyDashboardTest.class,
        JUnitAddDeleteDashboardTest.class
})
public class JUnitTestSuite{
}


