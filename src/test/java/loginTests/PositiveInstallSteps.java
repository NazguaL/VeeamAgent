package loginTests;

import libs.ConfigData;
import libs.Utils;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;
import java.io.IOException;
import java.util.Map;
import org.junit.rules.TestName;

/**
 * Created by sergii.ivashko on 13.03.2018.
 */
public class PositiveInstallSteps extends ParentTest
{

    public PositiveInstallSteps(String browser)
    {
        super(browser);
    }
    public TestName testName = new TestName();



    @Test
    public void InstallStepsTest1 () throws IOException
    {
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForInstallSteps = excelDriver.getData(excelDataFile, "InstallSteps");
        //Open Login page and enter login and pass:
        loginPage.LoginUser((dataFromExcelFileForInstallSteps.get("Valid1stLogin").toString()),(dataFromExcelFileForInstallSteps.get("Valid1stPass").toString()));
        //On Deploy and Restore page click on Install button:
        //Check of expected texts on Deploy and Restore page in Positive1stLogin Test
        GetScreenShotWithSleep("DeployRestorePageScreenShot", 1);
        deployRestorePage.ClickOnInstallBlockButton();
        ///Check of expected texts on EULA Page and AcceptEULA:
        checkAcceptanceCriteria("H Title is not expected", eulaPage.ReturnPopUpHTitleText(), (dataFromExcelFileForInstallSteps.get("HTitleText").toString()));
        checkAcceptanceCriteria("Credentials Title is not expected", eulaPage.ReturnEULATitleText(), (dataFromExcelFileForInstallSteps.get("EULATitleText").toString()));
        GetScreenShotWithSleep("EULAPageScreenShot", 1);
        eulaPage.AcceptEULA();
        //Check of expected texts on Install Credentials Page
        checkAcceptanceCriteria("H Title is not expected", installCredentialsPage.ReturnPopUpHTitleText(), (dataFromExcelFileForInstallSteps.get("HTitleText").toString()));
        checkAcceptanceCriteria("Credentials Title is not expected", installCredentialsPage.ReturnCredentialsTitleText(), (dataFromExcelFileForInstallSteps.get("CredentialsTitleText").toString()));
        checkAcceptanceCriteria("Credentials Message text is not expected", installCredentialsPage.ReturnCredentialsTitleMessageText(), (dataFromExcelFileForInstallSteps.get("CredentialsTitleMessageText").toString()));
        GetScreenShotWithSleep("InstallCredentialsPageScreenShot", 1);
        installCredentialsPage.InputInstallCredentials("admin", "admin", "qwe123ASD");


        /*
        String excelDataFile = ConfigData.getCfgValue("DATA_FILE");
        Map dataFromExcelFileForLogin = excelDriver.getData(excelDataFile, "InstallSteps");
        loginPage.LoginUser((dataFromExcelFileForLogin.get("Valid1stLogin").toString()),(dataFromExcelFileForLogin.get("Valid1stPass").toString()));
        checkAcceptanceCriteria("Page title is not expected", deployRestorePage.GetTitle(), (dataFromExcelFileForLogin.get("PageTitleTextCriteria").toString()));
        checkAcceptanceCriteria("H Title is not expected", deployRestorePage.ReturnPopUpHTitleText(), (dataFromExcelFileForLogin.get("PopUpHTitleTextCriteria").toString()));
        checkAcceptanceCriteria("Install button line 1 is not expected", deployRestorePage.ReturnLine1OfInstallBlockButtonText(), (dataFromExcelFileForLogin.get("Line1OfInstallBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Install button line 2 is not expected", deployRestorePage.ReturnLine2OfInstallBlockButtonText(), (dataFromExcelFileForLogin.get("Line2OfInstallBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Restore button line 1 is not expected", deployRestorePage.ReturnLine1OfRestoreBlockButtonText(), (dataFromExcelFileForLogin.get("Line1OfRestoreBlockButtonTextCriteria").toString()));
        checkAcceptanceCriteria("Restore button line 2 is not expected", deployRestorePage.ReturnLine2OfRestoreBlockButtonText(), (dataFromExcelFileForLogin.get("Line2OfRestoreBlockButtonTextCriteria").toString()));
        */


    }

}

