package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ChoosePreferredLayoutPage extends BasePage {


    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement choosePreferredLayoutHeading;

    @AndroidFindBy(id = "org.openintents.shopping:id/description")
    private MobileElement choosePreferredLayoutDescription;

    @AndroidFindBy(id = "org.openintents.shopping:id/layout_choice_actionbar")
    private MobileElement firstLayout;

    @AndroidFindBy(id = "org.openintents.shopping:id/layout_choice_bottom")
    private MobileElement secondLayout;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private MobileElement backButton;


    public ChoosePreferredLayoutPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyPreferredLayoutPage(){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(choosePreferredLayoutHeading));

        choosePreferredLayoutDescription.isDisplayed();
        firstLayout.isDisplayed();
        secondLayout.isDisplayed();
        backButton.isDisplayed();

    }

    public void userSelectstheSecondLayout(){

        secondLayout.click();
    }

    public void navigateBack(){

        backButton.click();
    }
}
