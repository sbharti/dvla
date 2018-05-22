package com.pageObjects;

/* This is the page class for dvla website, it has all the elements accessors and it defines the
* methods to perform funtions on the website. */

import com.opencsv.CSVReader;
import com.utils.PropertyReaders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class DvlaVehicleInformationPage extends PageBase {
    private final static String CSV_PATH = "src/test/resources/test.csv";
    private final static String pageTitle = "Get vehicle information from DVLA - GOV.UK";


    public DvlaVehicleInformationPage(WebDriver driver) {
        super(driver, pageTitle);
        URL = new PropertyReaders().readProperty("URL");
    }


    public List<String> getCarInfoFromExcelSheet() throws FileNotFoundException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] csvCell;
        List<String> expectedCarInformationList = new ArrayList<>();

        try {
            while ((csvCell = reader.readNext()) != null) {

                expectedCarInformationList.add(csvCell[0]);
                expectedCarInformationList.add(csvCell[1]);
                expectedCarInformationList.add(csvCell[2]);

            }
        } catch (IOException e) {
            e.printStackTrace();

        }
            return expectedCarInformationList;
    }

    public List<String> getVehicleInformation() throws FileNotFoundException, InterruptedException {
        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] csvCell;
        List<String> carInformationList = new ArrayList<>();

        driver.findElement(By.cssSelector("#get-started a")).click();
        waitForPageToLoad();

        try {
            while ((csvCell = reader.readNext()) != null) {

                String expectedCarRegistrationNumber = csvCell[0];
                String expectedCarMake = csvCell[1];
                String expectedCarColour = csvCell[2];

                driver.findElement(By.cssSelector(".field-input-validation-Vrm #Vrm")).sendKeys(expectedCarRegistrationNumber);
                driver.findElement(By.cssSelector(".form-group .button")).click();


                String actualRegistrationNumber = driver.findElement(By.cssSelector(".list-summary .list-summary-item:nth-child(1) .reg-mark")).getText().toUpperCase();
                String actualCarMake = driver.findElement(By.cssSelector(".list-summary .list-summary-item:nth-child(2) span:nth-child(2)")).getText().toUpperCase();
                String actualCarColour = driver.findElement(By.cssSelector(".list-summary li:nth-child(3) span:nth-child(2)")).getText().toUpperCase();

                carInformationList.add(actualRegistrationNumber);
                carInformationList.add(actualCarMake);
                carInformationList.add(actualCarColour);

                driver.findElement(By.cssSelector(".link-back")).click();
                waitForPageToLoad();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return carInformationList;
    }

}

