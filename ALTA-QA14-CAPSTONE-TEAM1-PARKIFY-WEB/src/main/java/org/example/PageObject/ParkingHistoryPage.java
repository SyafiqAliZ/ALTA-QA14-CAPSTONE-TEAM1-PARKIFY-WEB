package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ParkingHistoryPage {

    public static WebDriver webDriver;

    public ParkingHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath="//a[.='My Parking']")
    private WebElement parkingHistory;

    @FindBy(xpath = "//h2[@class='w-full text-3xl text-center font-semibold text-black']")
    private WebElement parkingHistoryList;

    @FindBy(xpath="//a[@href='/reservations/90']")
    private WebElement reservationHistory;

    @FindBy(xpath = "//p[.='Floor 2']")
    private WebElement verifyBookedHistory;


    public void clickParkingHistory() {
        parkingHistory.click();
    }

    public boolean verifyHistory(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='w-full text-3xl text-center font-semibold text-black']")));
        return parkingHistoryList.isDisplayed();
    }

    public void clickReservationHistory(){
        reservationHistory.click();
    }

    public boolean verifyBookedHistory(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Floor 2']")));
        return verifyBookedHistory.isDisplayed();
    }

}

