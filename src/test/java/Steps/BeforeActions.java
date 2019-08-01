package Steps;

import com.aventstack.extentreports.Status;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import ExtentListeners.ExtentTestManager;
import Base.BaseTest;
import java.net.MalformedURLException;

public class BeforeActions extends BaseTest {

    @Before
    public void before(Scenario scenario) throws MalformedURLException {

        String scenarioName = scenario.getName();
        ExtentTestManager.startTest("Scenario No: " + scenarioName);
        ExtentTestManager.getTest().log(Status.INFO, "Scenario started : - " + scenarioName);

        this.setUpAppium();
    }
}
