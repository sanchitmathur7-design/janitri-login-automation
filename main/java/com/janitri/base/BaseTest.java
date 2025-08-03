package com.janitri.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public void initializeBrowser() {
    	System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver-win64\\chromedriver.exe");





        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dashboard.janitri.in/");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
