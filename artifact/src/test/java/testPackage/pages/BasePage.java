package testPackage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
     this.driver = driver;
     this.wait = new WebDriverWait(driver,20);
    }
}
