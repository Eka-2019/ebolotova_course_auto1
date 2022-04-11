package pages;

import org.openqa.selenium.WebDriver;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    public URI getCurrentPageURL() throws URISyntaxException {
        return new URI(driver.getCurrentUrl());
    }

    protected final int WAIT_TIME_OUT = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
