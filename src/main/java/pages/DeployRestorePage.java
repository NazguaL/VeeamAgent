package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by sergii.ivashko on 08.03.2018.
 */
public class DeployRestorePage extends ParentPage
{

    /*Locators:*/
    @FindBy(xpath = ".//*[@class='gt-left pop-up-h-title']")
    WebElement PopUpHTitle;

    @FindBy(xpath = ".//*[@class='btns-g inst-mod']")
    WebElement InstallBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g inst-mod']/div[1]")
    WebElement Line1OfRestoreBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g inst-mod']/div[2]")
    WebElement Line2OfRestoreBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g restore-mod/']")
    WebElement RestoreBlockButton;

    public DeployRestorePage (WebDriver driver)
    {
        super(driver);
    }

    public String ReturnPopUpHTitleText ()
    {
        String text  = actionsWithWebElements.ReturnElementText(PopUpHTitle);
        return text;
    }

    public void ClickOnInstallBlockButton()
    {
        actionsWithWebElements.ClickOnElement(InstallBlockButton);
    }

    public String ReturnLine1OfRestoreBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line1OfRestoreBlockButton);
    }

    public String ReturnLine2OfRestoreBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line2OfRestoreBlockButton);
    }

    public void ClickOnRestoreBlockButton()
    {
        actionsWithWebElements.ClickOnElement(RestoreBlockButton);
    }

}

