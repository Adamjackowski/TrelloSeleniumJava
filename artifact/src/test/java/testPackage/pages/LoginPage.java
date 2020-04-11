package testPackage.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "login")
    private WebElement login;
    


    
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isDisplayed() {
        this.wait.until(new Function<WebDriver, Boolean>() {       
            public Boolean apply(WebDriver driver) { 
            return allElements();
            } 
        });
    }

    public boolean allElements()
    {
        List<WebElement> elements = new ArrayList<WebElement>();
        elements.addAll(Arrays.asList(this.email, this.password, this.login));
        for (WebElement element : elements) {
            if (!element.isDisplayed())
            {
                return false;
            }   
        }
		return true;

    }
    public void login(String login, String password)
    {
        this.email.sendKeys(login);
        this.password.sendKeys(password);
        this.login.click();
    }
}