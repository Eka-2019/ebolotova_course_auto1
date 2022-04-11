package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EPAMLoginPage extends AbstractPage {

    private final String BASE_URL = "https://login.epam.com";

    @FindBy(xpath = "//*[@id=\"companyLogo\"]")
    private WebElement companyLogo;

    @FindBy(xpath = "//*[@id=\"userNameInput\"]")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"passwordInput\"]")
    private WebElement password;


    public EPAMLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public EPAMLoginPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getLogoText() {
        return companyLogo.getAttribute("alt");
    }
}
