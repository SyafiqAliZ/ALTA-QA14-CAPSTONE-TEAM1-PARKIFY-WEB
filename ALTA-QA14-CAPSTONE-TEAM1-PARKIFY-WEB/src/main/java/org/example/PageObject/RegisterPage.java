package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public static WebDriver webDriver;
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    @FindBy(xpath = "//input[@name='fullname']")
    private WebElement regisName;
    @FindBy(xpath = "//li[1]/div[1]/div[.='selamat data sudah terdaftar']")
    private WebElement popupRegis;

    public void accountType(String text) {
        String elementXpath = "//div[.='" + text + "']";
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement accountType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        accountType.click();
    }
    public boolean verifyRegisterPage(){
        boolean a = regisName.isDisplayed();
        return a;
    }
    public void inputRegisName(String fullName){
        regisName.sendKeys(fullName);
    }
}
