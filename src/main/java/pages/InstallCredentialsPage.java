package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sergii.ivashko on 15.03.2018.
 */
public class InstallCredentialsPage extends ParentPage
{
    public InstallCredentialsPage (WebDriver driver)
    {
        super(driver);
    }

    /*Locators:*/
    @FindBy(xpath = ".//*[@class='gt-left pop-up-h-title']")
    WebElement PopUpHTitle;

    //Title
    @FindBy(xpath = ".//*[@class='zagname']")
    WebElement CredentialsTitle;

    @FindBy(xpath = ".//*[@class='subzagname']")
    WebElement CredentialsTitleMessage;

    //Login
    @FindBy(xpath = ".//*[@class='jis-1']/div[1]/div[1]")
    WebElement LoginText;

    @FindBy(xpath = ".//*[@class='jis-1']/div[1]/div[2]/input")
    WebElement LoginInputField;

    //OldPassword
    @FindBy(xpath = ".//*[@class='jis-1']/div[2]/div[1]")
    WebElement OldPasswordText;

    @FindBy(xpath = ".//*[@class='jis-1']/div[2]/div[2]/input")
    WebElement OldPasswordField;

    //New Password
    @FindBy(xpath = ".//*[@class='jis-1']/div[3]/div[1]")
    WebElement NewPasswordText;

    @FindBy(xpath = ".//*[@class='jis-1']/div[3]/div[2]/input")
    WebElement NewPasswordField;

    //Confirm New Password
    @FindBy(xpath = ".//*[@class='jis-1']/div[3]/div[1]")
    WebElement ConfirmNewPasswordText;

    @FindBy(xpath = ".//*[@class='jis-1']/div[3]/div[2]/input")
    WebElement ConfirmNewPasswordField;

    //Buttons
    @FindBy(xpath = ".//*[@class='go-btn gt-right go-btn-global']")
    WebElement NextButton;

    @FindBy(xpath = ".//*[@class='back-btn gt-right go-btn-global']")
    WebElement PreviousButton;




}
