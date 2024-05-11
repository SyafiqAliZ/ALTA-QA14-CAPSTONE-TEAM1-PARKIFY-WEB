package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.LoginPage;
import org.example.PageObject.ParkingHistoryPage;
import org.example.PageObject.PaymentPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ParkingHistoryStep {

    private final WebDriver driver = Hooks.driver;
    ParkingHistoryPage parkingHistory = new ParkingHistoryPage(driver);

    @And("User click parking history card")
    public void user_click_parking_history_card() {
        parkingHistory.clickParkingHistory();
    }

    @And("User already on parking history page")
    public void userAlreadyOnParkingHistoryPage() {
        Assert.assertTrue(parkingHistory.verifyHistory());

    }

    @And("user click parking booked")
    public void userClickParkingBooked() {
        parkingHistory.clickReservationHistory();
    }

    @Then("User will see some parking history information")
    public void userWillSeeSomeParkingHistoryInformation() {

    }
}
