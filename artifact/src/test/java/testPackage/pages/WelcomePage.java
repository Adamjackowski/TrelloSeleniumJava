package testPackage.pages;

import java.util.function.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage {

    @FindBy(how = How.CSS, using = "a.Buttonsstyles__Button-sc-1jwidxo-0:nth-child(1)")
    private WebElement loginButton;

    public WebDriver driver;

    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isDisplayed() {
        this.wait.until(new Function<WebDriver, Boolean>() {       
            public Boolean apply(WebDriver driver) { 
            return loginButton.isDisplayed();
            } 
        });
    }

    public void login()
    {
        loginButton.click();
    }
}