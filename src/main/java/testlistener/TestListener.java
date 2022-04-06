package testlistener;

import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(TestListener.class));

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }

    private void saveScreenshot(){
        DriverManager driverManager = new DriverManager();
        File screenShot = ((TakesScreenshot) driverManager
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShot, new File(
                    ".//target/testscreenshots/"
                            + getCurrentTimeAsString()
                            + ".png"));
        } catch (IOException e){
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formater);
    }

}
