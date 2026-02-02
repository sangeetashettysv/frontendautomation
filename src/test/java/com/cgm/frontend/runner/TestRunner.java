package com.cgm.frontend.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.cgm.frontend.stepDefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",  // generate HTML report
        "json:target/cucumber.json"           // optional JSON report
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests { }