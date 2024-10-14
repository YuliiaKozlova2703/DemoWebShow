package com.demowebshop.core;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        app.getUserHelper().click(By.xpath("//a[contains(text(),'Register')]"));

        app.getUserHelper().click(By.xpath("//input[@id='gender-male']")); // Если вы хотите выбрать "Male"

        // Генерируем уникальный email для теста
        String uniqueEmail = "yuliia.kozlova" + System.currentTimeMillis() + "@example.com";
        app.getUserHelper().fillRegistrationForm("Yuliia", "Kozlova", uniqueEmail, "Password1@");

        // Нажимаем кнопку регистрации
        app.getUserHelper().clickRegistrationButton();

        // Проверяем, что регистрация прошла успешно и есть кнопка "Continue"
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//input[@value='Continue']")),
                "Проверка на наличие кнопки 'Continue' после успешной регистрации");
    }
}
