package config;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Logger LOGGER = Logger.getLogger(String.valueOf(Config.class));
    String env = System.getProperty("env", "std");

    public void initProperties() {
        Properties properties = System.getProperties();

        try {
            InputStream propertiesFile = Config.class.getClassLoader()
                    .getResourceAsStream(env + ".properties");
            properties.load(propertiesFile);

        } catch (IOException e) {
            LOGGER.error("Reading config file is failed", e);
        }
    }
}
