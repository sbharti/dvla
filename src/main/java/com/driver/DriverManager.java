package com.driver;

/* This class manages the driver instance e.g. initiation and destroy after use */

import com.utils.PropertyReaders;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() throws IOException {
        String browser = new PropertyReaders().readProperty("browser");
        setWebDriver(DriverFactory.createInstance(browser));
        return webDriver.get();
    }

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }


    public static void destroyDriver(WebDriver driver) {
        driver.quit();
        driver = null;
    }
}
