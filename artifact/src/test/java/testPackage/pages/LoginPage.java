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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "user")
    private WebElement email;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    @FindBy(how = How.ID, using = "login")
    private WebElement proceedLogin;

    @FindBy(how = How.ID, using = "login-submit")
    private WebElement login;

    @FindBy(how = How.ID, using = "login")
    private WebElement loginAgain;

    @FindBy(how = How.ID, using = "error")
    private WebElement loginFailedError;


    public WebDriver driver;
    public static Boolean loginForFirstTime = true;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isDisplayed() {
        this.wait.until(new Function<WebDriver, Boolean>() {       
            public Boolean apply(WebDriver driver) { 
            return allElements();
            } 
        });
    }
    public Boolean isLoginFailed() {
       return this.loginFailedError.isDisplayed();
    }
    public boolean allElements()
    {
        List<WebElement> elements = new ArrayList<WebElement>();
        elements.addAll(Arrays.asList(this.email));
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
        this.proceedLogin.click();
        WebDriverWait wait = new WebDriverWait(this.driver, 20);
        wait.until(ExpectedConditions.visibilityOf(this.password));
        this.password.sendKeys(password);
        if (loginForFirstTime == true)
        {
            this.login.click();
            loginForFirstTime = false;
        }
        else
        {
            this.loginAgain.click();
        }
        
    }
}