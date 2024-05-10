package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    public static WebDriver webDriver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//a[.='Your QR Code']")
    private WebElement barcodeCard;

    @FindBy(xpath = "//p[@class='font-semibold text-3xl text-center text-white']")
    private WebElement yourQr;

    @FindBy(xpath = "//a[contains(.,'Exit Park')]")
    private WebElement btnExitPark;

    @FindBy(xpath = "//select[1]")
    private WebElement choosePayment;



    public void clickOnBarcodeCard() {
        barcodeCard.click();
    }

    public boolean clickOnYourQr() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='font-semibold text-3xl text-center text-white']")));
        return yourQr.isDisplayed();
    }

    public void clickOnExitPark() {
        WebElement footer = webDriver.findElement(By.xpath("//a[contains(.,'Exit Park')]"));
        int deltaY = footer.getRect().y;
        new Actions(webDriver)
                .scrollByAmount(0, deltaY)
                .perform();
        btnExitPark.click();
    }

    // public void scrollToParkingPlace() {
//        WebElement footer = webDriver.findElement(By.xpath("//p[.='Bandung']"));
//        int deltaY = footer.getRect().y;
//        new Actions(webDriver)
//                .scrollByAmount(0, deltaY)
//                .perform();
//    }

    public void selectPayment(String text) {
        Select sort = new Select(choosePayment);
        sort.selectByVisibleText(text);

    }
}

