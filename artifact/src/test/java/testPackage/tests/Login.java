package testPackage.tests;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testPackage.pages.AfterLogoutPage;
import testPackage.pages.LoginPage;
import testPackage.pages.MainPage;
import testPackage.pages.WelcomePage;

public class Login extends TestBase {

    public JSONObject  passes;
    

    @BeforeMethod
    public void setUpTestData() throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        String a = System.getProperty("user.dir");
        String b = "\\src\\test\\java\\testPackage\\testData.json";
        String c = a + b;
        FileReader reader = new FileReader(c);
        this.passes = (JSONObject) jsonParser.parse(reader);
        this.driver.get(URL);
    }
 
    //-----------------------------------Tests-----------------------------------
    @Test
    public void ProperLogin () {
        WelcomePage welcomePage = new WelcomePage(this.driver);
        welcomePage.isDisplayed();
        welcomePage.login();
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.isDisplayed();
        loginPage.login((String)this.passes.get("Login"), (String)this.passes.get("Password"));
        MainPage mainPage = new MainPage(this.driver);
        mainPage.isDisplayed();
        mainPage.logout();
        AfterLogoutPage afterLogoutPage = new AfterLogoutPage(this.driver);
        afterLogoutPage.isDisplayed();
        afterLogoutPage.logout();
        welcomePage.isDisplayed();
    }

    @Test
    public void WrongLogin () {

        WelcomePage welcomePage = new WelcomePage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);
        
        welcomePage.isDisplayed();
        welcomePage.login();
        loginPage.isDisplayed();
        loginPage.login("fake@fake.com","fake");
        loginPage.isLoginFailed();
    }
}

