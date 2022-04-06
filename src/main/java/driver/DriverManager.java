package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private final Logger LOGGER = Logger.getLogger(String.valueOf(DriverManager.class));
    private WebDriver driver;


    public DriverManager(){
        initProperties("src/test/resources/config/config.properties");
    }

    public WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser","chrome")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void initProperties(String pathToConfig){
        Properties properties = System.getProperties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(pathToConfig);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(ip);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
