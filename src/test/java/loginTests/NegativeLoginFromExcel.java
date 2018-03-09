package loginTests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sergii.ivashko on 09.03.2018.
 */
public class NegativeLoginFromExcel extends ParentTest
{

    public NegativeLoginFromExcel (String browser)
    {
        super(browser);
    }

    @Test
    public void Invalid1stPass () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "NegativeLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("Valid1stLogin").toString()),(dataFromExcelFileForLogin.get("Invalid1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", loginPage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Login Alter is not expected", loginPage.ReturnLoginAlterText(), (dataFromExcelFileForLogin.get("LoginAlterAfterFilled").toString()));
    }

    @Test
    public void Empty1stPass () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "NegativeLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("Valid1stLogin").toString()),(dataFromExcelFileForLogin.get("Empty1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", loginPage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Login Alter is not expected", loginPage.ReturnLoginAlterText(), (dataFromExcelFileForLogin.get("LoginAlterAfterEmpty").toString()));
    }

    @Test
    public void Invalid1stLogin () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "NegativeLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("Invalid1stLogin").toString()),(dataFromExcelFileForLogin.get("Valid1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", loginPage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Login Alter is not expected", loginPage.ReturnLoginAlterText(), (dataFromExcelFileForLogin.get("LoginAlterAfterFilled").toString()));
    }

    @Test
    public void Empty1stLogin () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "NegativeLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("Empty1stLogin").toString()),(dataFromExcelFileForLogin.get("Valid1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", loginPage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Login Alter is not expected", loginPage.ReturnLoginAlterText(), (dataFromExcelFileForLogin.get("LoginAlterAfterEmpty").toString()));
    }
}
