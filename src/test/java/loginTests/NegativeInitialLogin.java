package loginTests;

import libs.DriverInitiator;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by sergii.ivashko on 20.02.2018.
 */
public class NegativeInitialLogin
{
    WebDriver driver;
    //WebDriverWait wait;
    Logger log;
    LoginPage loginPage;
    ExceptionHelper exceptionHelper;
    DriverInitiator driverInitiator;

    @Before
    public void Setup ()
    {
        //File fileFF = new File("./drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        driverInitiator = new DriverInitiator();
        this.driver = driverInitiator.StartChromeDriver();
        //driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        log = Logger.getLogger(getClass());
        loginPage = new LoginPage(driver);
        //exceptionHelper = new ExceptionHelper();
        // homePage = new HomePage(driver);
    }

    @Test
    public void NegativeLogin ()
    {
        loginPage.OpenLoginPage("http://127.0.0.1:8100/");
        loginPage.InputLogin("admin");
        loginPage.InputPass("adm");
        loginPage.ClickSubmitButton();
        loginPage.CompareAlert("Incorrect login or password");
        log.trace("Page title is: " + driver.getTitle());
        //String expectedTitle = "";
        //Assert.assertEquals(driver.getTitle(), expectedTitle);
        //String expectedLoginTitle = "Veeam Appliance for AHV.";
        //String actualLoginTitle = driver.findElement(By.xpath(".//*[@class='gt-left pop-up-h-title']")).getText();
        //log.trace(driver.findElement(By.xpath(".//*[@class='gt-left pop-up-h-title']")).getText());
        //Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
    }

    @After
    public void CloseDriver ()
    {
        driver.quit();
        driver = null;
    }


}
