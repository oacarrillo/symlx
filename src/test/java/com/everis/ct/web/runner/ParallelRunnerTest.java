package com.everis.ct.web.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(plugin = {"pretty", "html:target/cucumber/fast-report/cucumber-pretty.html",
        "json:target/cucumber/cucumber.json",
        "timeline:target/cucumber/timeline",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/resources/features"},
        glue = {"com.everis.ct.web.hooks", "com.everis.ct.web.glue"},
        tags = "DEMO_"
)
public class ParallelRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}