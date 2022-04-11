package pages;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportLoginPage extends AbstractPage {

    private final String BASE_URL = "https://reportportal.epam.com/ui/#login";

    @FindBy(xpath = "//input[@placeholder='Login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[1]")
    private WebElement loginAsEPAMer;

    @FindBy(xpath = "//button[contains(text(), \"Login\")]")
    private WebElement login;

    public ReportLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ReportLoginPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }


    public EPAMLoginPage loginOld(String name, String password) {
        loginField.sendKeys(name);
        passwordField.sendKeys(password);
        loginAsEPAMer.click();
        return new EPAMLoginPage(driver);
    }

    public EPAMLoginPage loginToEPAMLoginPage(User user) {
        loginField.sendKeys(user.getUserName());
        passwordField.sendKeys(user.getPassword());
        loginAsEPAMer.click();
        return new EPAMLoginPage(driver);
    }

    public ReportPortalMainPage loginToDashboardPage(User user) {
        loginField.sendKeys(user.getUserName());
        passwordField.sendKeys(user.getPassword());
        login.click();
        return new ReportPortalMainPage(driver);
    }

}
