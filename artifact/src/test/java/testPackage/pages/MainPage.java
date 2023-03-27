package testPackage.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(how = How.CSS, using = ".DweEFaF5owOe02")
    private WebElement logo;

    @FindBy(how = How.CSS, using = ".JaxGrNSZxJ4ghJ > ul:nth-child(7) > li:nth-child(2) > button:nth-child(1) > span:nth-child(1)")
    private WebElement logout;



    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.logout =  logouts.get(8);
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
        elements.addAll(Arrays.asList(this.logo));
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
        this.logo.click();
        this.logout.click();
    }
}