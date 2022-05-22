package pages;

import lombok.Getter;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

@Getter
public class ReportLoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@type, \"submit\")]")
    private WebElement login;

    public ReportLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ReportPortalMainPage loginToDashboardPage(User user) {
        loginField.sendKeys(user.getLogin());
        passwordField.sendKeys(user.getPassword());
        login.click();
        ReportPortalMainPage page = new ReportPortalMainPage(driver);
        Utils.waitForXpath(driver, 2000, "//footer");
        return page;
    }

    public ReportLoginPage openPage() {
        driver.navigate().to(base_url);
        Utils.waitForXpath(driver, 2000, "//button[@type = \"submit\"]");
        return this;
    }

}
