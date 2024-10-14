package com.demowebshop.core;

import com.demowebshop.fw.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;
    WebDriverWait wait;

    UserHelper userHelper;
    private final String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    protected void init() {
        ///driver = new ChromeDriver();
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1920x1080");
            options.addArguments("headless");
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        userHelper = new UserHelper(driver, wait);
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    protected void stop() {
        driver.quit();
    }
}
