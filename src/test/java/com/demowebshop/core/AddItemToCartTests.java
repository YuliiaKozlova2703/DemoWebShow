package com.demowebshop.core;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AddItemToCartTests extends TestBase {

    @Test
    public void AddItemToCartTest() {
        SoftAssert softAssert = new SoftAssert();

        /* Шаг 1: Поиск и клик на второй товар
        driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]")).click();*/
        app.getUserHelper().click(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[2]"));
        // Шаг 2: Проверка наличия алерта
        softAssert.assertTrue(app.getUserHelper().isNotificationPresent());
        // Проверка всех утверждений
        softAssert.assertAll();
    }
}

