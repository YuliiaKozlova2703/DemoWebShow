package com.demowebshop.core;

import com.demowebshop.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {
        app.getUserHelper().login(new User().setEmail("yuliia.kozlova@example.com").setPassword("Password1@"));
        Assert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//a[contains(text(),'Log out')]")));
    }
}

