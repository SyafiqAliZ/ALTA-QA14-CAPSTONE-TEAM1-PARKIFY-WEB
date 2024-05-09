package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.LoginPage;
import org.example.PageObject.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterSteps {
    private final WebDriver driver = Hooks.driver;
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @When("User click sign up button")
    public void clickSignupButton(){
        loginPage.clickButtonSignup();
    }

    @Then("User redirected to register page")
    public void userRedirectedToRegisterPage() {

    }

    @Then("User choose {string}")
    public void userChoose(String text) {
        registerPage.accountType(text);
    }

    @And("User input {string} as full name {string} as email and {string} as password and click sign up")
    public void userInputAsFullNameAsEmailAndAsPasswordAndClickSignUp(String fullName, String email, String password) {
        registerPage.inputRegisName(fullName);
        loginPage.inputFieldEmail(email);
        loginPage.inputFieldPassword(password);
        loginPage.clickButtonSubmit();
    }

    @And("User will see success message {string}")
    public void userWillSeeSuccessMessage(String arg0) {

    }

    @Then("User redirected to login page")
    public void userRedirectedToLoginPage() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }
}
