package com.everis.ct.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber/fast-report/cucumber-pretty.html",
        "json:target/cucumber/cucumber.json",
        "timeline:target/cucumber/timeline",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        stepNotifications = true,
        features = {"src/test/resources/features"},
        glue = {"com.everis.ct.web.hooks", "com.everis.ct.web.glue"},
        tags = "@TC1"
)
public class RunnerTest {

    @BeforeClass
    public static void beforeExecution() {
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "BEFORE EXECUTION --->");
    }

    @AfterClass
    public static void afterExecution() {
        Logger.getLogger(RunnerTest.class.getName()).log(Level.INFO, "AFTER EXECUTION --->");
    }
}
