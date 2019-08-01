package Base;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver = null;

    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {
        this.setUpAppium();
    }

    public void setUpAppium() throws MalformedURLException {
        final String androidAppName = "shoppinglist.apk";
        String appiumServer = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(appiumServer);
        File f = new File("src");
        File fs = new File(f, androidAppName);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S8");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "org.openintents.shopping");
        capabilities.setCapability("appActivity", "org.openintents.shopping.ShoppingActivity");

        driver = new AndroidDriver<MobileElement>(url, capabilities);
    }


    @AfterSuite
    public void tearDownAppium() {
        if (driver != null) {
            driver.quit();
        }

    }
}
