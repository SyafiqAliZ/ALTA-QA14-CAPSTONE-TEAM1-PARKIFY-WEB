package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObject.BookingPage;
import org.example.PageObject.EditProfilPage;
import org.example.PageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.awt.print.Book;

public class BookingStep {

    private final WebDriver driver = Hooks.driver;

    BookingPage booking = new BookingPage(driver);

    @And("User go to menu find parking place")
    public void userGoToMenuFindParkingPlace() {
        booking.clickParkingPlace();
    }

//    @And("User scroll page till find parking place")
//    public void userChooseTritanPointBandungAsParkingPlace() {
//        booking.scrollToParkingPlace();
//    }

    @And("User click tunjungan plaza mall")
    public void userClickTunjunganPlazaMall() {
        booking.clickParking();
    }



    @Then("User will redirected to booking parking page")
    public void userWillRedirectedToBookingParkingPage() {
        Assert.assertTrue(booking.verifyInfoBooking());
    }


    @And("User click button car")
    public void userClickButtonCar() {
        booking.clickBtnCar();
    }

    @And("User choose second floor {string}")
    public void userChooseSecondFloor(String text)  {
        booking.selectFloor(text);

    }

    @And("User choose slot one {string}")
    public void userChooseSlot(String text) {

        booking.selectOne(text);

    }

    @And("User will see the parking information at the picking card")
    public void userWillSeeTheParkingInformationAtThePickingCard()  {
        booking.verifyBooking();
    }

    @And("User click button booking now")
    public void userClickButtonBookingNow()  {
        booking.clickBtnBookNow();

    }

    @And("User will see success message")
    public void userWillSeeSuccessMessage() {
        Assert.assertTrue(booking.verifySuccessCreateReservation());
    }

    @Then("User will see booking information")
    public void userWillSeeBookingInformation() {
        Assert.assertTrue(booking.verifyInfoBooked());

    }

    @And("User did not choose floor")
    public void userDidNotChooseFloor() {

    }

    @Then("User will see error message {string}")
    public void userWillSeeErrorMessage(String text) {
        Assert.assertTrue(booking.verifyErrorCreateReservation());

    }
}

