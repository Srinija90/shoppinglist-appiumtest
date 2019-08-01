package Steps;

import Base.BaseTest;
import ExtentListeners.ExtentManager;
import ExtentListeners.ExtentTestManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class AfterActions extends BaseTest {

    @After
    public void after(Scenario scenario) throws IOException {
        final String environment = System.getProperty("env");

        String screenshotPath = "";
        if (scenario.isFailed()) {
            screenshotPath = saveScreenshot(scenario);

            ExtentTestManager.addScreenShotsOnFailure(screenshotPath);
        } else {
            ExtentTestManager.scenarioPass();
        }

        ExtentManager.getReporter().flush();
        driver.quit();
    }

    private static String saveScreenshot(Scenario scenario) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        String screenshotPath = System.getProperty("user.dir") + "/reports/screenshots_"
                + d.toString().replace(":", "_").replace(" ", "_") + "/" + scenario.getId() + ".png";
        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return screenshotPath;
    }

}

