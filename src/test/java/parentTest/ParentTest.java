package parentTest;

//import Pages.*;
//import libs.ExcelDriver;
import libs.DriverInitiator;
import libs.ExcelDriver;
import libs.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import pages.ApparatPage;
//import pages.EditApparatPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

    @RunWith(value = Parameterized.class)

    public class ParentTest
    {
        public WebDriver driver;
        public Logger log;
        public LoginPage loginPage;
        public HomePage homePage;
        public DriverInitiator driverInitiator;
       // public SdelkiListPage sdelkiListPage;
       // public EditSdelkiPage editSdelkiPage;
       // public SparePage sparePage;
       // public EditNewSparePage editNewSparePage;
       // public ApparatPage apparatPage;
       // public EditApparatPage editApparatPage;
        //public TypeSdelkiPage typeSdelkiPage;
        //public EditTypeSdelkiPage editTypeSdelkiPage;
        private Utils utils = new Utils();
        private boolean isTestCompleted = false;
        private String ScreenShotNamePostfix;
        private String pathToScreenShot;
        private String browser;
        public ExcelDriver excelDriver;

        @Rule
        public TestName testName = new TestName();
        //The TestName Rule makes the current test name available inside test methods.

        public ParentTest(String browser)
        {
            this.browser = browser;
            log = Logger.getLogger(getClass());
        }


        @Parameterized.Parameters
        // Использование JUnit параметризованных аннотаций.
        // http://www.quizful.net/post/parameterized-junit-tests
        public static Collection testData() throws IOException {
            return Arrays.asList(new Object[][]{
                    {"FireFox"}
                      ,
                 {"Chrome"}
                           //,
                      //{ "IEdriver" }
               ,
                    { "Opera" }
//                ,
//                {"phantomJs"}
//                ,
//                {"remote"}
            });
        }



        @Before
        public void setUp()
        {
            pathToScreenShot = ".\\target\\screenshots\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
            + this.testName.getMethodName() + browser + ".jpg";

            driverInitiator = new DriverInitiator();

            switch (browser) {
                case "Chrome":
                    log.trace("ChromeDriver initiation requested.");
                    this.driver = driverInitiator.StartChromeDriver();
                    break;
                case "FireFox":
                    log.trace("FirefoxDriver initiation requested.");
                    this.driver = driverInitiator.StartFirefoxDriver ();
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

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
           // sdelkiListPage = new SdelkiListPage(driver);
            //editSdelkiPage = new EditSdelkiPage(driver);
            //sparePage = new SparePage(driver);
            //editNewSparePage = new EditNewSparePage(driver);
            //apparatPage = new ApparatPage(driver);
            //editApparatPage = new EditApparatPage(driver);
           // typeSdelkiPage = new TypeSdelkiPage(driver);
           // editTypeSdelkiPage = new EditTypeSdelkiPage(driver);

            excelDriver = new ExcelDriver();


        }

        @After


        public void tearDown()
        {
            utils.screenShot(pathToScreenShot, driver);
            driver.quit();
            driver = null;
        }

        protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected){
            if (actual != expected)
            {
                ScreenShotNamePostfix = "AcceptanceCriteriaMismatched";
                utils.screenShot(pathToScreenShot, driver);
            }
            Assert.assertThat(message, actual, is (expected));
            isTestCompleted = true;
        }

        protected void checkAcceptanceCriteria(String message, String actual, String expected){
            if (!actual.equals(expected))
            {
                ScreenShotNamePostfix = "AcceptanceCriteriaMismatched";
                utils.screenShot(pathToScreenShot, driver);
            }
            Assert.assertThat(message, actual, is (expected));
            isTestCompleted = true;
        }

}
