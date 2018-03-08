package pages;

import libs.ActionsWithWebElements;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by User on 24.02.2018.
 */
public class ParentPage
{

    WebDriver driver;
    Logger log;
    ActionsWithWebElements actionsWithWebElements;
    String ExceptionTextToLog;
    ExceptionHelper exceptionHelper;

    public ParentPage(WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        actionsWithWebElements = new ActionsWithWebElements(driver);
        exceptionHelper = new ExceptionHelper();
        PageFactory.initElements(driver, this); //this means this page!
    }

    public String GetTitle ()
    {
        String title =  driver.getTitle();
        try {
            log.trace("Title is: " + title);
            return title;
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not get page title!";
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
            return null;
        }
    }

    public void CheckTitle (String expectedTitle)
    {
        Assert.assertEquals("Title does not expected!", GetTitle(), expectedTitle);
    }

}
