package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    public static WebDriver webDriver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//div[@class='p-4 space-y-5']")
    private WebElement verifyProfile;

    @FindBy(xpath = "//a[@href='/parking-slot/61']")
    private WebElement buttonManageParking;

    @FindBy(xpath = "//button[.='Logout']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//li[.='Logout successfully']")
    private WebElement messageLogout;

    @FindBy(xpath = "//button[.='Delete Account']")
    private WebElement buttonDelete;

    @FindBy(xpath = "//div[@id='radix-:rov:']")
    private WebElement confirmDelete;

    @FindBy(css = ".bg-red-400")
    private WebElement buttonConfirmDelete;

    @FindBy(xpath = "//li[1]/div[1]/div[.='berhasil menghapus akun']")
    private WebElement messageDelete;


    public void verifyProfile() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='p-4 space-y-5']")));
        verifyProfile.isDisplayed();
    }

    public String popupSuccess(String text) {
        String elementXpath = "//li[1]/div[1]/div[.='" + text + "']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement popupSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return popupSuccess.getText();
    }

    public void clickManageParking() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/parking-slot/61']")));
        buttonManageParking.click();
    }

    public void clickButtonLogout() {
        buttonLogout.click();
    }

    public String getLogoutMessage(String text) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[.='Logout successfully']")));
        return messageLogout.getText();
    }

    public void clickButtonDelete() {
        buttonDelete.click();
    }

    public String confirmDelete(String text) {
        String elementXpath = "//h2[@class='text-lg font-semibold']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return confirmDelete.getText();
    }

    public void buttonCofirmDelete() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bg-red-400")));
        buttonConfirmDelete.click();
    }

    public String messageDelete(String text) {
        String elementXpath = "//li[1]/div[1]/div[.='berhasil menghapus akun']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement messageDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return messageDelete.getText();
    }


}
