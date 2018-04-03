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
    @FindBy(xpath = ".//*[@class='jis-1']/div[4]/div[1]")
    WebElement ConfirmNewPasswordText;

    @FindBy(xpath = ".//*[@class='jis-1']/div[4]/div[2]/input")
    WebElement ConfirmNewPasswordField;

    //Buttons
    @FindBy(xpath = ".//*[@class='go-btn gt-right go-btn-global']")
    WebElement NextButton;

    @FindBy(xpath = ".//*[@class='back-btn gt-right go-btn-global']")
    WebElement PreviousButton;

    //Return Text Methods
    public String ReturnPopUpHTitleText ()
    {
        return actionsWithWebElements.ReturnElementText(PopUpHTitle);
    }

    public String ReturnCredentialsTitleText ()
    {
        return actionsWithWebElements.ReturnElementText(CredentialsTitle);
    }

    public String ReturnCredentialsTitleMessageText ()
    {
        return actionsWithWebElements.ReturnElementText(CredentialsTitleMessage);
    }

    public String ReturnLoginText ()
    {
        return actionsWithWebElements.ReturnElementText(LoginText);
    }

    public String ReturnOldPasswordText ()
    {
        return actionsWithWebElements.ReturnElementText(OldPasswordText);
    }

    public String ReturnNewPasswordText ()
    {
        return actionsWithWebElements.ReturnElementText(NewPasswordText);
    }

    public String ReturnConfirmNewPasswordText ()
    {
        return actionsWithWebElements.ReturnElementText(ConfirmNewPasswordText);
    }

    public void InputLogin (String login) {
        actionsWithWebElements.InputToTextField(LoginInputField, login);
    }

    public void ReInputOldPass (String oldpass) {
        actionsWithWebElements.InputToTextField(OldPasswordField, oldpass);
    }

    public void InputNewPass (String newpass) {
        actionsWithWebElements.InputToTextField(NewPasswordField, newpass);
    }

    public void ConfirmNewPass (String newpass) {
        actionsWithWebElements.InputToTextField(ConfirmNewPasswordField, newpass);
    }

    public void ClickNextButton () {
        actionsWithWebElements.ClickOnElement(NextButton);
    }

    public void InputInstallCredentials (String login, String oldpass, String newpass)
    {
        InputLogin(login);
        ReInputOldPass(oldpass);
        InputNewPass(newpass);
        ConfirmNewPass(newpass);
        ClickNextButton ();
    }

    public void InputInstallCredentials (String login, String newpass)
    {
        InputLogin(login);
        InputNewPass(newpass);
        ConfirmNewPass(newpass);
        ClickNextButton ();
    }
}
