package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingPage {
    public static WebDriver webDriver;

    public BookingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//p[@class='font-semibold text-2xl mt-auto']")
    private WebElement bookingTitle;

    @FindBy(xpath = "//h2[@class='font-semibold text-3xl leading-none text-wrap pe-6']")
    private WebElement verifyInfoBooking;

    @FindBy(xpath = "//img[@src='/motorcycle.png']")
    private WebElement radioButtonCar;

    @FindBy(xpath = "//div[@class='flex flex-col p-4 space-y-4']/select[1]")
    private WebElement chooseFloor;

    @FindBy(xpath = "//div[@class='space-y-2']/button[@class='flex h-10 items-center justify-between border border-input bg-background px-3 py-2 text-sm ring-offset-background placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 [&>span]:line-clamp-1 w-full rounded-xl']")
    private WebElement clickSlot;

    @FindBy(xpath = "//div[@class='space-y-2']/button[@class='flex h-10 items-center justify-between border border-input bg-background px-3 py-2 text-sm ring-offset-background placeholder:text-muted-foreground focus:outline-none focus:ring-2 focus:ring-ring focus:ring-offset-2 disabled:cursor-not-allowed disabled:opacity-50 [&>span]:line-clamp-1 w-full rounded-xl']")
    private WebElement chooseSlot;

    @FindBy(xpath="//label[text()=\"Choose Slot\"]/following-sibling::select")
    private WebElement slotOne;

    @FindBy(xpath = "//div[@class='space-y-2']//select[@aria-hidden='true']")
    private WebElement chooseSlot2;

    @FindBy(xpath = "//label[text()=\"Choose Slot\"]/following-sibling::select/option[text()=\"Slot 1\"]")
    private WebElement slotSatu;

    @FindBy(xpath = "//p[@class='font-light text-md leading-none']")
    private WebElement verifyBooking;

    @FindBy(css = ".inline-flex")
    private WebElement bookNow;

    @FindBy(xpath="//li[1]/div[1]/div[.='success create reservation']")
    private WebElement successCreateReservation;

    @FindBy(xpath="//p[.='Floor']")
    private WebElement infoBooked;

    @FindBy(xpath="//li[1]/div[1]/div[.='terjadi kesalahan pada proses server']")
    private WebElement errorCreateReservation;

    public void clickParkingPlace() {
        bookingTitle.click();
    }

    public void waitForElementVisible(WebElement e) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

//    @FindBy(css = "//h2[.='Tunjungan Plaza Mall']")
//    private WebElement ParkingPlace;

    public void clickParking() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement ParkingPlace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Tunjungan Plaza Mall']")));
        ParkingPlace.click();
    }

    public void scrollIntoView(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(false);", e);
        waitForElementVisible(e);
    }

    public boolean verifyInfoBooking() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='font-semibold text-3xl leading-none text-wrap pe-6']")));
        return verifyInfoBooking.isDisplayed();
    }

    public void clickBtnCar() {
        radioButtonCar.click();
    }

    public void selectFloor(String text) {
        Select sort = new Select(chooseFloor);
        sort.selectByVisibleText(text);

    }

    public void selectSlot()  {
        chooseSlot.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//html/body/div/main/div/div/div/form/div/div[3]/select/option[@value='3']")));

    }

    public void selectOne(String text)  {
        //selectSlot();
        Select sort = new Select(chooseSlot2);
        sort.selectByValue("3");
//
//        JavascriptExecutor js = (JavascriptExecutor)webDriver;
//        js.executeScript("arguments[0].click();", slotSatu);

        //slotSatu.click();
        //Select sort = new Select(chooseSlot2);
        //sort.selectByVisibleText(text);
        //Thread.sleep(5000);

    }

    public String verifyBooking() {
        return verifyBooking.getText();

    }

    public void clickBtnBookNow() {
        bookNow.isDisplayed();
        bookNow.click();
    }
    ////*[contains(text(),'Book Now')]

    public boolean verifySuccessCreateReservation(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]/div[1]/div[.='success create reservation']")));
        return successCreateReservation.isDisplayed();
    }


    public boolean verifyInfoBooked(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Floor']")));

        return infoBooked.isDisplayed();

    }

    public boolean verifyErrorCreateReservation(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]/div[1]/div[.='terjadi kesalahan pada proses server']")));
        return errorCreateReservation.isDisplayed();
    }

}
//    public void scrollToParkingPlace() {
//        WebElement footer = webDriver.findElement(By.xpath("//p[.='Bandung']"));
//        int deltaY = footer.getRect().y;
//        new Actions(webDriver)
//                .scrollByAmount(0, deltaY)
//                .perform();
//    }



