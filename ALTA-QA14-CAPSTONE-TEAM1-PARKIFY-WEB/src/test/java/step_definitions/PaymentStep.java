package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.BookingPage;
import org.example.PageObject.EditProfilPage;
import org.example.PageObject.LoginPage;
import org.example.PageObject.PaymentPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentStep {


    private final WebDriver driver = Hooks.driver;
    PaymentPage payment = new PaymentPage(driver);

    @And("User click barcode in dashboard page")
    public void UserClickBarcode(){
        payment.clickOnBarcodeCard();

    }

    @And("User will directed to barcode page")
    public void userWillDirectedToBarcodePage() {
        Assert.assertTrue(payment.clickOnYourQr());

    }

    @And("User click exit park button")
    public void userClickExitParkButton() {
        payment.clickOnExitPark();

    }

    @And("User select payment {string}")
    public void userSelectPayment(String text) {
        payment.selectPayment(text);
    }
}
