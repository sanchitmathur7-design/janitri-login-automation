package com.janitri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By eyeIcon = By.cssSelector("svg.feather.feather-eye");
    private By errorMessage = By.cssSelector("p.text-red-500");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        WebElement emailElem = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElem.clear();
        emailElem.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passElem.clear();
        passElem.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public String getLoginErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (Exception e) {
            return "⚠️ No visible error message found.";
        }
    }

    public boolean isEmailFieldVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    public boolean isEyeIconVisible() {
        return driver.findElements(eyeIcon).size() > 0;
    }

    // Optional toggle method
    public boolean togglePasswordVisibility() {
        if (isEyeIconVisible()) {
            driver.findElement(eyeIcon).click();
            return true;
        }
        return false;
    }
}
