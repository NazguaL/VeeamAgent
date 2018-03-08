package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by User on 25.02.2018.
 */

@RunWith(value = Parameterized.class)

public class NegativeLogin extends ParentTest
{
    String login, pass;

    public NegativeLogin(String browser, String login, String pass)
    {
        super(browser);
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]
        {
                {"Chrome", "Student", "906090"},
                {"Chrome","tudent","909090"},
                {"Chrome","","909090"},
                {"Chrome","Student",""},
                {"FireFox", "Student", "906090"},
                {"FireFox","tudent","909090"}
        });
    }

    @Test
    public void InvalidLogin ()
    {
        loginPage.LoginUser(login,pass);
        checkAcceptanceCriteria("Title is not expected", loginPage.GetTitle(), "Account of spare:Авторизация");
    }
}
