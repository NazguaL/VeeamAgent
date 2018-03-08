package loginTests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by User on 04.03.2018.
 */
public class PositiveLoginFromExcel extends ParentTest {


    public PositiveLoginFromExcel (String browser)
    {
        super(browser);
    }

    @Test
    public void ValidLogin () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "PositiveLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("login").toString()),(dataFromExcelFileForLogin.get("pass").toString()));
        checkAcceptanceCriteria("Title is not expected", homePage.GetTitle(), (dataFromExcelFileForLogin.get("criteria1").toString()));

    }


}
