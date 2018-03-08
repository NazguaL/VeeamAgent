package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by User on 21.02.2018.
 */
public class DriverInitiator
{
    public WebDriver driver;
    Logger log;

    public DriverInitiator ()
    {
        log = Logger.getLogger(getClass());
    }

    public WebDriver StartChromeDriver ()
    {
        driver  = new ChromeDriver();
        log.trace("ChromeDriver initiated.");
        return driver;
    }

    public WebDriver StartFirefoxDriver ()
    {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.page", 0); // Empty start page
        profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver  = new FirefoxDriver(caps);
        log.trace("FirefoxDriver initiated.");
        return driver;
    }

    public WebDriver StartIEDriver ()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new InternetExplorerDriver(capabilities);
        log.trace("IEDriver initiated.");
        return driver;
    }

    public WebDriver StartOperaDriver ()
    {
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Program Files\\Opera\\51.0.2830.40\\opera.exe");
        driver = new OperaDriver(options);
        log.trace("OperaDriver initiated.");
        return driver;
    }

}
