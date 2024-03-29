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

public class AfterLogoutPage extends BasePage {

    @FindBy(how = How.CSS, using = ".css-178ag6o")
    private WebElement confirmLogout;

    public WebDriver driver;

    public AfterLogoutPage(WebDriver driver) {
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
        elements.addAll(Arrays.asList(this.confirmLogout));
        for (WebElement element : elements) {
            if (!element.isDisplayed())
            {
                return false;
            }   
        }
		return true;

    }

    public void logout()
    {
        this.confirmLogout.click();
    }
}