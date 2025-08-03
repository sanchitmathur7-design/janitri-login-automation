package com.janitri.tests;

import com.janitri.base.BaseTest;
import com.janitri.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        initializeBrowser();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        loginPage.enterEmail("sanchitmathur7@gmail.com");
        loginPage.enterPassword("Sanchit7068@");
        loginPage.clickLoginButton();

        Thread.sleep(3000); // Wait for page to load after login
        System.out.println("✅ Valid login test executed.");
    }

    @Test
    public void testInvalidLogin() throws InterruptedException {
        loginPage.enterEmail("mathursanchit@gmail.com");
        loginPage.enterPassword("Sanchit");
        loginPage.clickLoginButton();

        Thread.sleep(2000);
        String error = loginPage.getLoginErrorMessage();
        System.out.println("❌ Login error message: " + error);
        Assert.assertTrue(error.toLowerCase().contains("invalid") || error.toLowerCase().contains("incorrect"));
    }

    @Test
    public void testLoginPageElementsPresence() {
        Assert.assertTrue(loginPage.isEmailFieldVisible(), "Email field should be visible.");
        Assert.assertTrue(loginPage.isPasswordFieldVisible(), "Password field should be visible.");
        Assert.assertTrue(loginPage.isEyeIconVisible(), "Eye icon should be visible.");
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button should be visible.");
    }

    @Test
    public void testPasswordVisibilityToggle() {
        Assert.assertTrue(loginPage.togglePasswordVisibility(), "👁️ Eye icon (password toggle) should be functional.");
    }
}
