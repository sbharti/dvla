package com;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@cucumber.api.CucumberOptions(
        tags = {"@dvla"},
        features = "src/test/resources")
public class TestRunner {
}
