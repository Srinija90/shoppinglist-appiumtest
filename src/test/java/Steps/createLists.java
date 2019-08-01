package Steps;

import Base.BaseTest;
import Pages.ChoosePreferredLayoutPage;
import Pages.MyShoppingPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import java.util.List;

public class createLists extends BaseTest {

    @Given("^user selects the second layout$")
    public void userSelectsSecondLayout()  {
        ChoosePreferredLayoutPage choosePreferredLayoutPage = new ChoosePreferredLayoutPage(driver);
        choosePreferredLayoutPage.verifyPreferredLayoutPage();
        choosePreferredLayoutPage.userSelectstheSecondLayout();
    }

    @When("^user creates a (.*)$")
    public void userCreatesLists(String listName) throws Exception {
        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);

        myShoppingPage.createNewList(listName);

    }

    @And("^user adds the (.*)$")
    public void userAddsListItemsToLists(List<String> listItems) throws InterruptedException {
        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
        myShoppingPage.addListItemsToList(listItems);

    }

    @And("^user deletes the list item (.*)$")
    public void userDeletesAListItemFromList(String item) throws InterruptedException {
        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
        myShoppingPage.deleteListItemFromList(item);

    }

    @Then("^(.*) is deleted successfully$")
    public void itemShouldBeDeleted(String item) throws Throwable {
        MyShoppingPage myShoppingPage = new MyShoppingPage(driver);
        myShoppingPage.assertItemDeleted(item);


    }

}
