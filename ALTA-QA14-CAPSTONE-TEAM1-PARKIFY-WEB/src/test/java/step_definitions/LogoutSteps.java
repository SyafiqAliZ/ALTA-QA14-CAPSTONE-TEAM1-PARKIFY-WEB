package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.PageObject.ProfilePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LogoutSteps {
    private final WebDriver driver = Hooks.driver;
    ProfilePage profilePage = new ProfilePage(driver);

    @And("User click logout button")
    public void userClickLogoutButton(){
        profilePage.clickButtonLogout();
    }

    @Then("User see {string} as message")
    public void userSeeAsMessage(String text) {
        Assert.assertEquals(text, profilePage.getLogoutMessage(text));
    }
}