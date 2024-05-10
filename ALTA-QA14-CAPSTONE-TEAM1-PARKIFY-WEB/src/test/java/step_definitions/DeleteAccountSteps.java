package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.PageObject.ProfilePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DeleteAccountSteps {
    private final WebDriver driver = Hooks.driver;
    ProfilePage profilePage = new ProfilePage(driver);

    @And("click delete account button")
    public void clickDeleteAccountButton() {
        profilePage.clickButtonDelete();
    }

    @Then("message will be show {string}")
    public void messageWillBeShow(String text) {
        Assert.assertEquals(text, profilePage.confirmDelete(text));
    }

    @Then("user click continue")
    public void userClickContinue() {
        profilePage.buttonCofirmDelete();
    }

    @Then("user will see message {string}")
    public void userWillSeeMessage(String text) {
        Assert.assertEquals(text, profilePage.messageDelete(text));
    }

}