package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWidgetPopUp {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), \"Overall statistics\")]")
    private WebElement overallStatisticsRadioButton;

    @FindBy(xpath = "//span[contains(text(), \"Next step\")]")
    private WebElement nextStepButton;

    @FindBy(xpath = "//div[contains(text(), \"Filter name\")]")
    private WebElement filterName;

    @FindBy(xpath = "//input[@placeholder='Enter name']]")
    private WebElement launchName;

    @FindBy(xpath = "//button[contains(text(), \"Submit\")]")
    private WebElement submitButton;

    @FindBy(xpath = "//button[contains(text(), \"Add\")]")
    private WebElement addButton;

    public NewWidgetPopUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


}
