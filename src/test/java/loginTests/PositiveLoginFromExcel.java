package loginTests;

import libs.ConfigData;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sergii.ivashko on 04.03.2018.
 */
public class PositiveLoginFromExcel extends ParentTest
{

    public PositiveLoginFromExcel (String browser)
    {
        super(browser);
    }

    @Test
    public void ValidLogin () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "PositiveLogin");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("valid1stLogin").toString()),(dataFromExcelFileForLogin.get("valid1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", deployRestorePage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("H Title is not expected", deployRestorePage.ReturnPopUpHTitleText(), (dataFromExcelFileForLogin.get("PopUpHTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Install button line 1 is not expected", deployRestorePage.ReturnLine1OfInstallBlockButtonText(), (dataFromExcelFileForLogin.get("Line1OfInstallBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Install button line 2 is not expected", deployRestorePage.ReturnLine2OfInstallBlockButtonText(), (dataFromExcelFileForLogin.get("Line2OfInstallBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Restore button line 1 is not expected", deployRestorePage.ReturnLine1OfRestoreBlockButtonText(), (dataFromExcelFileForLogin.get("Line1OfRestoreBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Restore button line 2 is not expected", deployRestorePage.ReturnLine2OfRestoreBlockButtonText(), (dataFromExcelFileForLogin.get("Line2OfRestoreBlockButtonTextCriteria").toString()));
    }
}
