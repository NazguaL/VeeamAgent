package loginTests;

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
public class NegativeLogin
{
    WebDriver driver;
    //WebDriverWait wait;
    Logger log;
    LoginPage loginPage;
    ExceptionHelper exceptionHelper;

    @Before
    public void Setup ()
    {
        //File fileFF = new File("./drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, 10);
        log = Logger.getLogger(getClass());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        exceptionHelper = new ExceptionHelper();
        // homePage = new HomePage(driver);
    }

    @Test
    public void ValidLogin ()
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
    }


}
