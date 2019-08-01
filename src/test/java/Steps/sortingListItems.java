package Steps;

import Base.BaseTest;
import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

public class sortingListItems extends BaseTest {

    @And("^sort the list items in alphabetical order$")
    public void userSortsLists() throws Exception {

        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
        myShoppingPage.sortItemsAlphabeticalOrder();

    }

    @Then("^list items should be sorted (.*)$")
    public void verifySortedOrder(List<String> sortedList) throws Exception {

        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
        myShoppingPage.assertSortOrder(sortedList);

    }


}
