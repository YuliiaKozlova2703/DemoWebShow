package com.demowebshop.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeSuite
    public void setUpSuite() {
        String browser = System.getProperty("browser", "chrome");
        app = new ApplicationManager(browser);
    }

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @AfterSuite
    public void tearDownSuite() {
        // Дополнительные действия после завершения всех тестов (если необходимо)
    }
}
