package pages;

import io.qameta.allure.Step;
import lombok.Getter;

import model.User;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class ReportLoginPage extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(String.valueOf(ReportLoginPage.class));

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
        page.waitForXpath(2000, "//footer");
        //page.isLoaded(2000);
        return page;
    }

    @Override
    public ReportLoginPage openPage() {
        driver.navigate().to(base_url);
        this.waitForXpath(2000, "//button[@type = \"submit\"]");
        //this.wait.until(ExpectedConditions.titleContains("Welcome,"));
        return this;
    }

    @Override
    public BasePage waitForXpath(int timeOut, String xpath) {
        super.waitForXpath(timeOut, xpath);
        return this;
    }
}
