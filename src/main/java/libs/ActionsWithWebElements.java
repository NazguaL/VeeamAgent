package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 18.02.2018.
 */
public class ActionsWithWebElements
{
    WebDriver driver;
    Logger log;
    ExceptionHelper exceptionHelper;
    String ExceptionTextToLog;
    // WebDriverWait webDriverWait20;

    public ActionsWithWebElements  (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        exceptionHelper = new ExceptionHelper();
        // webDriverWait20 = new WebDriverWait(driver, 20);
    }

    public void OpenPage (String Url)
    {
        try
        {
            driver.get(Url);
            log.trace("Page with URL: \'" + Url + "\' opened.");
        }
        catch (Exception e)
        {
            exceptionHelper.ExceptionLogger("Can not open Page with URL: \'" + Url + "\'!", e);
        }
    }

    public String ReturnElementText (WebElement element)
    {
        try {
            String text = element.getText();
            log.trace("Text of element: " + element + " is " + text);
            return text;
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not get text of element: " + element;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
            return null;
        }
    }

    public void InputToTextField (WebElement element, String value)
    {
        try {
            element.clear();
            element.sendKeys(value);
            log.trace(value + " filled to element: " + element);
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not fill value \'" + value + "\' to element: " + element;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
        }
    }

    public void ClickOnElement (WebElement element) {
        try {
            // webDriverWait20.until(ExpectedConditions.visibilityOf(element));
            // Explicitly wait.
            element.click();
            log.trace("Clicked on element: " + element);
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not click on element: " + element;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
        }
    }

    public void SelectAnElement (WebElement element, boolean neededState)
    {
        try {
            // isSelected() http://selftechy.com/2011/07/23/selenium-2-0-webdriver-some-useful-apis
            if ((!element.isSelected() && neededState)||(element.isSelected() && !neededState))
            {
                element.click();
                log.trace("Selected element: " + element);
            }
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not select element: " + element;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
        }
    }

    public boolean IsAnElementSelected (WebElement element) throws Exception
    {
        log.trace("Element: " + element + " IsSelected: " + element.isSelected());
        return element.isSelected();
    }

    public boolean IsAnElementPresented (WebElement element) throws Exception
    {
        log.trace("Element: " + element + " IsPresented: " + element.isSelected());
        return element.isDisplayed() && element.isEnabled();
    }

    public void SelectItemFromDropDownByVisibleElement (WebElement elementDD, String textForSelect)
    {
        try {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.deselectByVisibleText(textForSelect);
            log.trace(textForSelect + " was selected from DD menu.");
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not select element from DD menu: " + elementDD;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
        }
    }

}
