package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EPAMLoginPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(EPAMLoginPage.class));

    @FindBy(id = "companyLogo")
    private WebElement companyLogo;

    @FindBy(id = "userNameInput")
    private WebElement login;

    @FindBy(id = "passwordInput")
    private WebElement password;

    public EPAMLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public EPAMLoginPage openPage() {
        driver.navigate().to(base_url);
        return this;
    }

    @Step ("Login to EPAM page")
    public String getLogoText() {
        return companyLogo.getAttribute("alt");
    }
}
