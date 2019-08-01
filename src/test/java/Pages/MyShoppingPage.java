package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MyShoppingPage extends BasePage {

    private static final int XML_REFRESH_DELAY = 3000;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement myShoppingListHeading;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private MobileElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Clean up list']")
    private MobileElement cleanUpList;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private MobileElement moreOptions;

    @AndroidFindBy(id = "org.openintents.shopping:id/autocomplete_add_item")
    private MobileElement textField;

    @AndroidFindBy(id = "org.openintents.shopping:id/button_add_item")
    private MobileElement addButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")
    private MobileElement oiShoppingListHeader;

    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView")
    private MobileElement newListLink;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement NewShoppingListAlertHeader;

    @AndroidFindBy(id = "org.openintents.shopping:id/edittext")
    private MobileElement listNameInput;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
    private MobileElement settings;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]")
    private MobileElement sortOrderButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private MobileElement alphabeticalOrder;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.TextView")
    private MobileElement list1;

    private String itemListXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout";

    public MyShoppingPage(AppiumDriver driver) {
        super(driver);
    }

    public void verifyMyShoppingListPage() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(myShoppingListHeading));

        menuButton.isDisplayed();
        cleanUpList.isDisplayed();
        moreOptions.isDisplayed();
        textField.isDisplayed();
        addButton.isDisplayed();
    }

    public void clickMenuButton() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(myShoppingListHeading));

        menuButton.click();
    }

    public void clickcleanUpList() {

        cleanUpList.click();
    }

    public void createNewList(String listName) throws Exception {

        oiShoppingListHeader.isDisplayed();
        menuButton.click();
        newListLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(NewShoppingListAlertHeader));


        listNameInput.sendKeys(listName);
        Thread.sleep(XML_REFRESH_DELAY);
        okButton.click();
    }

    public void addListItemsToList(List<String> listItems) {

        int size = listItems.size();

        for (int i = 0; i < size; i++) {

            textField.sendKeys(listItems.get(i));
            addButton.click();

        }


    }

    public void deleteListItemFromList(String item) {

        List<String> itemTextList = getItemTextList();
        int size = itemTextList.size();
        for (int i = 0; i < size; i++) {

            int index = i + 1;
            if (itemTextList.get(i).equals(item)) {

                MobileElement checkBox = (MobileElement) driver.findElementByXPath(itemListXPath + "[" + index + "]/android.widget.RelativeLayout[1]/android.widget.CheckBox");
                checkBox.click();

            }
        }


        cleanUpList.click();
    }

    public void sortItemsAlphabeticalOrder() throws Exception {

        moreOptions.click();
        settings.click();
        sortOrderButton.click();
        Thread.sleep(XML_REFRESH_DELAY);
        alphabeticalOrder.click();
        Thread.sleep(XML_REFRESH_DELAY);
        clickDeviceBackButton();
        menuButton.click();
        Thread.sleep(XML_REFRESH_DELAY);
        list1.click();
    }


    public void assertItemDeleted(String item) {

        List<String> itemTextList = getItemTextList();
        boolean itemFound = false;

        int size = itemTextList.size();
        for (int i = 0; i < size; i++) {

            if (itemTextList.get(i).equals(item)) {
                itemFound = true;
            }
        }

        Assert.assertFalse(itemFound);
    }

    public void clickDeviceBackButton() throws  Exception{

        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(XML_REFRESH_DELAY);

    }

    public void assertSortOrder(List<String> sortedList) {

        List<String> itemText = getItemTextList();

        int size = sortedList.size();
        Assert.assertEquals(itemText.size(), size);

        for (int i = 0; i < size; i++) {

            Assert.assertEquals(itemText.get(i), sortedList.get(i));

        }

    }

    private List<String> getItemTextList() {
        List<String> itemTextList = new ArrayList<String>();
        List<MobileElement> itemsListEls = driver.findElementsByXPath(itemListXPath);

        int size = itemsListEls.size();
        for (int i = 0; i < size; i++) {
            int index = i + 1;
            MobileElement itemTextEl = (MobileElement) driver.findElementByXPath(itemListXPath + "[" + index + "]/android.widget.RelativeLayout[2]/android.widget.TextView");

            itemTextList.add(itemTextEl.getText());
        }

        return itemTextList;
    }
}
