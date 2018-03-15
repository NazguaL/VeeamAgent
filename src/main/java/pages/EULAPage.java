package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sergii.ivashko on 13.03.2018.
 */
public class EULAPage extends ParentPage
{
    public EULAPage(WebDriver driver)
    {
        super(driver);
    }

    /*Locators:*/
    @FindBy(xpath = ".//*[@class='gt-left pop-up-h-title']")
    WebElement PopUpHTitle;

    @FindBy(xpath = ".//*[@class='zagname']")
    WebElement EULATitle;

    //@FindBy(xpath = ".//*[@class='wizzard1']//input[@name='dva' and @type='checkbox']")
    @FindBy(xpath = ".//*[@id='react-view']/div/div[2]/div[1]/div/div/div[2]/div[2]/div/div/div[4]/label/input")
    WebElement EULACheckbox;

    @FindBy(xpath = ".//*[@class='go-btn gt-right go-btn-global']")
    WebElement NextButton;

    public String ReturnPopUpHTitleText ()
    {
        return actionsWithWebElements.ReturnElementText(PopUpHTitle);
    }

    public String ReturnEULATitleText ()
    {
        return actionsWithWebElements.ReturnElementText(EULATitle);
    }

    public String ReturnEULACheckboxText ()
    {
        return actionsWithWebElements.ReturnElementText(EULACheckbox);
    }

    public void SelectEULACheckbox()
    {
        actionsWithWebElements.SelectAnElement (EULACheckbox, true);
    }

    public void ClickOnNextButton()
    {
        actionsWithWebElements.ClickOnElement(NextButton);
    }

    public void AcceptEULA()
    {
        SelectEULACheckbox();
        ClickOnNextButton();
    }

}
