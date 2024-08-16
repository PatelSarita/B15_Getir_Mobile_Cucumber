package app.getir.step_definitions;

import app.getir.pages.BasketPage;
import app.getir.pages.CategoryPage;
import app.getir.pages.LoginPage;
import app.getir.utilities.ScrollHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Getir_StepDefs {
    LoginPage loginPage = new LoginPage();
    CategoryPage categoryPage = new CategoryPage();
    BasketPage basketPage = new BasketPage();

    @When("The user opens the getir app and enters {string} and {string}")
    public void the_user_opens_the_getir_app_and_enters_and(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("The user logins successfully")
    public void the_user_logins_successfully() {
        String expectedText = "Dondurma";
        String actualText = categoryPage.categoryDondurma.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @When("The user clicks on basket button")
    public void the_user_clicks_on_basket_button() {
        categoryPage.basketBtn.click();
    }
    @Then("The user verifies that the basket is empty and able to see {string}")
    public void the_user_verifies_that_the_basket_is_empty_and_able_to_see(String expectedText) {
        Assert.assertEquals(expectedText,basketPage.emptyBasketText.getText());
        basketPage.backBtn.click();
    }
    @Then("The user is able to see all item list on page and verifies the size is {int}")
    public void the_user_is_able_to_see_all_item_list_on_page_and_verifies_the_size_is(int expectedSize) {
        int actualSize = categoryPage.categoryList.size();
        Assert.assertEquals(expectedSize,actualSize);
    }
    @When("The user clicks on category which is {string}")
    public void the_user_clicks_on_category_which_is(String categoryName) {
        categoryPage.goToCategory(categoryName);
    }
    @When("If needed the user scrolls down and adds {int} items")
    public void if_needed_the_user_scrolls_down_and_adds_items(int itemNum, DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        for (String item : list) {
            new ScrollHelper().scrollVerticalHelper(item);
            categoryPage.addItem(itemNum);
        }
    }
    @Then("The user verifies that the {string}")
    public void the_user_verifies_that_the(String expectedAmount) {
        String actualAmount = basketPage.totalAmount.getText();
        Assert.assertEquals(expectedAmount,actualAmount);
    }
}
