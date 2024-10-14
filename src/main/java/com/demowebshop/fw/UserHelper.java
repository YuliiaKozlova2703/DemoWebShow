package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import com.demowebshop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickRegistrationButton() {
        click(By.xpath("//input[@id='register-button']"));
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        /*click(By.xpath("//input[@id='FirstName']"));
        driver.findElement(By.xpath("//input[@id='FirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Yuliia");*/
        type(By.xpath("//input[@id='FirstName']"), firstName);

        /*click(By.xpath("//input[@id='LastName']"));
        driver.findElement(By.xpath("//input[@id='LastName']")).clear();
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Kozlova");*/
        type(By.xpath("//input[@id='LastName']"), lastName);

        /*click(By.xpath("//input[@id='Email']"));
        driver.findElement(By.xpath("//input[@id='Email']")).clear();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("yuliia.kozlova@example.com");*/
        type(By.xpath("//input[@id='Email']"), email);

        /*click(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='Password']")).clear();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password1@");*/
        type(By.xpath("//input[@id='Password']"), password);

        /*click(By.xpath("//input[@id='ConfirmPassword']"));
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).clear();
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Password1@");*/
        type(By.xpath("//input[@id='ConfirmPassword']"), password);
    }


    public void login(User user) {
        click(By.xpath("//a[.='Log in']"));
        type(By.xpath("//input[@id='Email']"), user.getEmail());
        type(By.xpath("//input[@id='Password']"), user.getPassword());
        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='RememberMe']"));
        if (!rememberMe.isSelected()) {
            rememberMe.click();
        }
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
}
