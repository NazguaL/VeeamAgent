package loginTests;

import libs.DriverInitiator;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;



/**
 * Created by sergii.ivashko on 21.02.2018.
 */
public class NegativeInitialLoginFirefox
{
    WebDriver driver;
    //WebDriverWait wait;
    Logger log;
    LoginPage loginPage;
    ExceptionHelper exceptionHelper;
    DriverInitiator driverInitiator;

    @Before
    public void SetupFirefox ()
    {
        driverInitiator = new DriverInitiator();
        this.driver = driverInitiator.StartFirefoxDriver();
        log = Logger.getLogger(getClass());
        loginPage = new LoginPage(driver);
    }

    @Test
    public void NegativeLoginViaFirefox ()
    {
        loginPage.OpenLoginPage("http://127.0.0.1:8100/");
        loginPage.InputLogin("admin");
        loginPage.InputPass("adm");
        loginPage.ClickSubmitButton();
        loginPage.CompareAlert("Incorrect login or password");
        log.trace("Page title is: " + driver.getTitle());
    }

    @After
    public void CloseFirefoxDriver ()
    {
        driver.quit();
        driver = null;
    }

}
