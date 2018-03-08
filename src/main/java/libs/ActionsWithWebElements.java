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
    WebDriverWait webDriverWait20;

    public ActionsWithWebElements  (WebDriver driver)
    {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        exceptionHelper = new ExceptionHelper();
        webDriverWait20 = new WebDriverWait(driver, 20);
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
            element.click();
            log.trace("Clicked on element: " + element);
        } catch (Exception e) {
            ExceptionTextToLog  = "Can not click on element: " + element;
            exceptionHelper.ExceptionLogger(ExceptionTextToLog, e);
        }
    }

    public void SelectACheckbox(By checkbox) throws Exception {
        // isSelected() http://selftechy.com/2011/07/23/selenium-2-0-webdriver-some-useful-apis
        WebElement cancheck = driver.findElement(checkbox);
        if (!cancheck.isSelected()) {
            cancheck.click();
            log.trace("Select a checkbox: " + checkbox);
        }
    }

    public void UnSelectACheckbox(By checkbox) throws Exception {
        WebElement cancheck = driver.findElement(checkbox);
        if (cancheck.isSelected()) {
            cancheck.click();
            log.trace("UnSelect a checkbox: " + checkbox);
        }
    }

    public boolean IsACheckboxSelected (By checkbox) throws Exception
    {
        WebElement cancheck = driver.findElement(checkbox);
        log.trace("Checkbox: " + checkbox + "IsSelected: " + cancheck.isSelected());
        return cancheck.isSelected();
    }

    public void SelectARadiobutton (By radiobutton) throws Exception
    {
        driver.findElement(radiobutton).click();
        log.trace("Select a Radiobutton: " + radiobutton);
    }

    public boolean IsARadiobuttonSelected (By radiobutton) throws Exception
    {
        WebElement cancheck = driver.findElement(radiobutton);
        log.trace("radiobutton: " + radiobutton + " IsSelected: " + cancheck.isSelected());
        return cancheck.isSelected();
    }

    public boolean IsElementPresent (WebElement element)
    {
        return element.isDisplayed() && element.isEnabled();
    }

    public void SelectItemFromDropDownByVisibleElement (WebElement elementDD, String textForSelect)
    {
        Select optionFromDD = new Select(elementDD);
        optionFromDD.deselectByVisibleText(textForSelect);
        log.trace(textForSelect + " was selected from DD menu.");
    }

}
