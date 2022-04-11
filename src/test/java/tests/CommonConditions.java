package tests;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ReportLoginPage;
import pages.ReportPortalMainPage;
import service.UserCreator;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "";
    protected static final String USER_PASSWORD = "";
    private static final String RESOURSES_PATH = "";

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public ReportPortalMainPage loginToPortalMainPage(User testUser){
        return new ReportLoginPage(driver)
                .openPage()
                .loginToDashboardPage(testUser);

    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        driver.quit();
    }

}
