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
    WebElement Line1OfInstallBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g inst-mod']/div[2]")
    WebElement Line2OfInstallBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g restore-mod/']")
    WebElement RestoreBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g restore-mod']/div[1]")
    WebElement Line1OfRestoreBlockButton;

    @FindBy(xpath = ".//*[@class='btns-g restore-mod']/div[2]")
    WebElement Line2OfRestoreBlockButton;

    public DeployRestorePage (WebDriver driver)
    {
        super(driver);
    }

    public String ReturnPopUpHTitleText ()
    {
        String text  = actionsWithWebElements.ReturnElementText(PopUpHTitle);
        return text;
    }

    // Install Block:
    public void ClickOnInstallBlockButton()
    {
        actionsWithWebElements.ClickOnElement(InstallBlockButton);
    }

    public String ReturnLine1OfInstallBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line1OfInstallBlockButton);
    }

    public String ReturnLine2OfInstallBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line2OfInstallBlockButton);
    }

    // Restore Block:
    public void ClickOnRestoreBlockButton()
    {
        actionsWithWebElements.ClickOnElement(RestoreBlockButton);
    }

    public String ReturnLine1OfRestoreBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line1OfRestoreBlockButton);
    }

    public String ReturnLine2OfRestoreBlockButtonText ()
    {
        return actionsWithWebElements.ReturnElementText(Line2OfRestoreBlockButton);
    }
}

