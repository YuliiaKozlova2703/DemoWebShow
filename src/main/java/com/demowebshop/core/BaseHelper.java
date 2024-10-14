package com.demowebshop.core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseHelper {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isNotificationPresent() {
        try {
            WebElement notificationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='bar-notification']/p")));
            String alertText = notificationElement.getText();
            System.out.println("Уведомление: " + alertText);
            return alertText.contains("The product has been added to your shopping cart");
        } catch (Exception e) {
            System.out.println("Уведомление не найдено или возникла ошибка: " + e.getMessage());
        }
        return false;
    }
}
