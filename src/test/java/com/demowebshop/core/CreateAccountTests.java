package com.demowebshop.core;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        app.getUserHelper().click(By.xpath("//a[contains(text(),'Register')]"));

        app.getUserHelper().click(By.xpath("//input[@id='gender-male']"));// Если вы хотите выбрать "Male"
        // driver.findElement(By.xpath("//input[@id='gender-female']")).click(); // Если вы хотите выбрать "Female"

        app.getUserHelper().fillRegistrationForm("Yuliia", "Kozlova", "yuliia.kozlova@example.com", "Password1@");

        //driver.findElement(By.xpath("//input[@id='register-button']")).click();
        app.getUserHelper().clickRegistrationButton();
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath(" //input[@value='Continue']")));
    }
}

