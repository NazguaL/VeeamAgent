package pages;

import libs.ActionsWithWebElements;
import libs.ConfigData;
import libs.ExceptionHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

/**
 * Created by User on 18.02.2018.
 */
public class LoginPage extends ParentPage
{
    String BaseUrl;
    /*Locators:*/

    @FindBy(xpath = ".//*[@placeholder='Login']")
    WebElement loginNameInput;

    @FindBy(xpath = ".//*[@placeholder='Password']")
    WebElement loginPassInput;

    @FindBy(xpath = ".//*[@type='submit']")
    WebElement loginSubmitButtonInput;


    public LoginPage (WebDriver driver)
    {
        super(driver);
    }

    public void OpenLoginPage() {

        try {
            BaseUrl = ConfigData.getCfgValue("base_url");
        } catch (IOException e) {
            exceptionHelper.ExceptionLogger("Can not get base URL from config!", e);
        }
        actionsWithWebElements.OpenPage(BaseUrl + "/login");
    }

    public void InputLogin(String login) {
        actionsWithWebElements.InputToTextField(loginNameInput, login);
    }

    public void InputPass(String pass) {
        actionsWithWebElements.InputToTextField(loginPassInput, pass);
    }

    public void ClickSubmitButton() {
        actionsWithWebElements.ClickOnElement(loginSubmitButtonInput);
    }

    public void LoginUser (String login, String pass)
    {
        OpenLoginPage();
        InputLogin(login);
        InputPass(pass);
        ClickSubmitButton();
    }
}
