package loginTests;

import libs.DriverInitiator;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import parentTest.ParentTest;

// import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 18.02.2018.
 */

@RunWith(value = Parameterized.class)

public class PositiveLogin extends ParentTest
{
    String login, pass;

    public PositiveLogin (String browser, String login, String pass)
    {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData()
    {
        return Arrays.asList(new Object[][]
                {
                        {"Chrome", "Student", "909090"},
                        {"FireFox","Student","909090"}
                });
    }



    @Test
    public void ValidLogin ()
    {
        loginPage.OpenLoginPage();
        loginPage.InputLogin(login);
        loginPage.InputPass(pass);
        loginPage.ClickSubmitButton();
        log.trace(driver.getTitle());
        //String expectedTitle = "Учет запчастей";
        //homePage.CheckTitle(expectedTitle);
        checkAcceptanceCriteria("Title is not expected", homePage.GetTitle(), "Учет запчастей");

    }
}
