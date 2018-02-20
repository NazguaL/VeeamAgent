package pages;

import libs.ActionsWithWebElements;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by sergii.ivashko on 20.02.2018.
 */
public class LoginPage {
    WebDriver driver;
    Logger log;
    ActionsWithWebElements actionsWithWebElements;
    ExceptionHelper exceptionHelper;
    /*Locators:*/
    By loginNameInput = By.xpath(".//*[@placeholder='Login']");
    By loginPassInput = By.xpath(".//*[@placeholder='Password']");
    //String loginSubmitButtonInputXpath = "//*[@type='submit']";
    By loginSubmitButtonInput = By.xpath(".//*[@type='submit']");
    By afterLoginTitle = By.xpath(".//*[@class='gt-left pop-up-h-title']");
    By loginAlert = By.xpath(".//*[@class='login-alert']");


    public LoginPage (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(driver);
        exceptionHelper = new ExceptionHelper();
    }

    public void OpenLoginPage (String link)
    {
        try
        {
            driver.get(link);
            log.trace("Page is opened");
        }
        catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not open login page!", e);
        }
    }

    public void InputLogin (String login)
    {
        try
        {
            actionsWithWebElements.InputToTextField(loginNameInput, login);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not fill login!", e);
        }
    }

    public void InputPass (String pass)
    {
        try
        {
            actionsWithWebElements.InputToTextField(loginPassInput, pass);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not fill password!", e);
        }
    }

    public void ClickSubmitButton ()
    {
        try
        {
            actionsWithWebElements.ClickOnButton(loginSubmitButtonInput);
        } catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not click on \"Submit\" button!", e);
        }
    }

    public void CompareTitle (String expectedTitle)
    {
        try
        {
            String actualTitle = actionsWithWebElements.ReturnText(afterLoginTitle);
            log.trace("Login title is: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle);
        } catch (Exception e) {
            exceptionHelper.ExceptionLogger("expectedTitle does not equal to actualTitle!", e);
        }
    }

    public void CompareAlert (String expectedAlert)
    {
        try
        {
            String actualAlert = actionsWithWebElements.ReturnText(loginAlert);
            log.trace("Login alert is: " + actualAlert);
            Assert.assertEquals(actualAlert, expectedAlert);
        } catch (Exception e) {
            exceptionHelper.ExceptionLogger("expectedTitle does not equal to actualTitle!", e);
        }
    }

}
