package com.dumitruc.training;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: dumitruc
 * Date: 20/05/14
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".",
        format = {"pretty","json:target/report-cucumber/cucumber.json"}
)
public class CucumberRunnerTest {
}
