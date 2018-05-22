package com.driver;

/* This is the Driver Factory which provides the driver object for browser mentioned in the config file*/

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver = null;

    public static WebDriver createInstance(String browserName) {

        String browser = browserName.toLowerCase();

        if (browser.equals("firefox")) {
            driver = getFireFoxDriver();

        } else if (browser.equals("chrome")) {
            driver = getChromeDriver();

        } else {
            driver = getChromeDriver();

        }
        return driver;
    }


    private static WebDriver getFireFoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().window().maximize();
        return firefoxDriver;
    }

    private static WebDriver getChromeDriver() {
/*      If you want to run on the old chrome version,
        please mention the chrome driver version compatiable to your chrome. e.x driver 2.31 is valid for chrome version(61.0).*/
        WebDriverManager.chromedriver().version("2.31").setup();
//        ChromeDriverManager.getInstance().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}


