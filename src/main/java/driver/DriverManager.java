package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {

    private WebDriver driver;
    private final Logger LOGGER = Logger.getLogger(DriverManager.class);
    Config config = new Config();

    public DriverManager(){
        config.initProperties();
        LOGGER.info("initProperties");
    }

    public WebDriver getDriver(String browser){
        if (null == driver){
            switch (browser){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "ie": {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                }
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case "chrome":{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public WebDriver getDriver(){
        return getDriver(System.getProperty("browser"));
    }

    public void closeDriver(){
        driver.quit();
        driver = null;
        LOGGER.info("Driver is quit");
    }
}
