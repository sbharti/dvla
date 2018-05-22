package com.pageObjects;



import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/* This is base page class which opens the page. */

public class PageBase {
    protected String URL;
    protected WebDriver driver;
    protected String pageTitle;

    public static final int DEFAULT_WAIT_FOR_PAGE = 10;

    public PageBase(WebDriver myDriver, String pageTitle) {
        this.driver = myDriver;
        this.pageTitle = pageTitle;
    }

    public void open() {
        driver.get(URL);
    }


    public void waitForPageToLoad() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_FOR_PAGE, TimeUnit.SECONDS);
    }

}
