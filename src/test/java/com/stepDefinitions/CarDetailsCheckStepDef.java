package com.stepDefinitions;

import com.driver.DriverManager;
import com.pageObjects.DvlaVehicleInformationPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDetailsCheckStepDef {

    private static DvlaVehicleInformationPage dvlaVehicleInformationPage;
    private WebDriver driver;
    List<String> expectedVehicleList;
    List<String> actualVehicleList = new ArrayList<>();

    @Before
    public void beforeScenario() throws IOException {
        driver = new DriverManager().getDriver();
    }

    @After
    public void afterScenario() {
        DriverManager.destroyDriver(driver);
    }


    @When("^I visit DVLA vehicle information page$")
    public void i_navigate_to_the_hotel_booking_form_page() throws Throwable {
        dvlaVehicleInformationPage = new DvlaVehicleInformationPage(driver);
        dvlaVehicleInformationPage.open();
    }

    @When("^I check the vehicles information provided in the csv file$")
    public void check_vehicle_info() throws Throwable {
        actualVehicleList = dvlaVehicleInformationPage.getVehicleInformation();
    }

    @Then("^I should see the vehicle details mentioned in the csv file$")
    public void assert_car_info() throws FileNotFoundException {
        expectedVehicleList = dvlaVehicleInformationPage.getCarInfoFromExcelSheet();
        Assert.assertTrue("Expected car information is not being displayed on site, Expected -" + expectedVehicleList + "\nActual -" + actualVehicleList,expectedVehicleList.equals(actualVehicleList) );
    }

}
