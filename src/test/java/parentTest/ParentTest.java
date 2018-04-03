package parentTest;

//import libs.ExcelDriver;

import libs.DriverInitiator;
import libs.ExcelDriver;
import libs.Utils;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

@RunWith(value = Parameterized.class)

public class ParentTest {
    public WebDriver driver;
    public Logger log;
    public LoginPage loginPage;
    public HomePage homePage;
    public EULAPage eulaPage;
    public DeployRestorePage deployRestorePage;
    public InstallCredentialsPage installCredentialsPage;
    public DriverInitiator driverInitiator;

    private Utils utils = new Utils();
    private boolean isTestCompleted = false;
    private String ScreenShotNamePostfix;
    private String pathToScreenShot;
    public String browser;
    public ExcelDriver excelDriver;

    @Rule
    public TestName testName = new TestName();
    //The TestName Rule makes the current test name available inside test methods.

    public ParentTest(String browser) {
        this.browser = browser;
        log = Logger.getLogger(getClass());
    }


    @Parameterized.Parameters
    // Использование JUnit параметризованных аннотаций.
    // http://www.quizful.net/post/parameterized-junit-tests
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                //{"FireFox"}
                //,
               {"Chrome"}
                //,
                //{ "IEdriver" }
                //,
                //{ "Opera" }
//                ,
//                {"phantomJs"}
//                ,
//                {"remote"}
        });
    }

    protected void GetScreenShot(String pathToScreenShotPostfix)
    {
        utils.screenShot(pathToScreenShot + pathToScreenShotPostfix, driver);
    }

    protected void GetScreenShotWithSleep (String pathToScreenShotPostfix, int seconds)
    {
        Sleep(seconds);
        GetScreenShot(pathToScreenShotPostfix);
        Sleep(seconds);
    }

    public void Sleep (int seconds)
    {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {


        pathToScreenShot = ".\\target\\screenshots\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + browser;

        driverInitiator = new DriverInitiator();



        switch (browser) {
            case "Chrome":
                log.trace("ChromeDriver initiation requested.");
                this.driver = driverInitiator.StartChromeDriver();
                break;
            case "FireFox":
                log.trace("FirefoxDriver initiation requested.");
                this.driver = driverInitiator.StartFirefoxDriver();
                break;
            case "IEdriver":
                log.trace("IEDriver initiation requested.");
                this.driver = driverInitiator.StartIEDriver();
                break;
            case "Opera":
                log.trace("OperaeDriver initiation requested.");
                this.driver = driverInitiator.StartOperaDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 800));

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        eulaPage = new EULAPage(driver);
        deployRestorePage = new DeployRestorePage(driver);
        installCredentialsPage = new InstallCredentialsPage(driver);


        excelDriver = new ExcelDriver();

/*
        ProcessBuilder b = new ProcessBuilder("C:\\Windows\\System32\\cmd.exe");
        try {
            b.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //, "cd .\\veeamconsole\\dotnet", "NutanixBackup.dll", "-useStub", "-useHttp"
*/


    }

    @After




    public void tearDown()
    {
        GetScreenShotWithSleep("AfterTestScreenShot", 1);
        driver.quit();
        driver = null;
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected) {
        if (actual != expected) {
            ScreenShotNamePostfix = "AcceptanceCriteriaMismatched";
            utils.screenShot(pathToScreenShot, driver);
        }
        Assert.assertThat(message, actual, is(expected));
        isTestCompleted = true;
    }

    protected void checkAcceptanceCriteria(String message, String actual, String expected) {
        if (!actual.equals(expected)) {
            ScreenShotNamePostfix = "AcceptanceCriteriaMismatched";
            utils.screenShot(pathToScreenShot, driver);
        }
        Assert.assertThat(message, actual, is(expected));
        isTestCompleted = true;
    }

}
