package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by User on 18.02.2018.
 */
public class HomePage extends ParentPage
{

    /*Locators:*/
    By TitleLogo = By.xpath("//a[@class='logo']");

    public HomePage (WebDriver driver)
    {
        super(driver);
    }

    public void CompareTitle (String expectedTitle)
    {
        String actualTitle = actionsWithWebElements.Title();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
