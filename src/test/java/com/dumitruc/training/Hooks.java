package com.dumitruc.training;


import com.dumitruc.training.stepdefs.StepDefBase;
import com.dumitruc.training.webui.WebDriverClient;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class Hooks extends StepDefBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setup(Scenario scenario){
        LOGGER.info("Before scenario = " + scenario.getId());
    }

    @Before("@WEBUI")
    public void setupWebUi() {
        WebDriverClient webDriverClient = WebDriverClient.getInstance();
        webDriverClient.openBrowser();
        webDriverClient.getDriver().manage().window().maximize();
        webDriverClient.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After("@WEBUI")
    public void tearDownWebUi() {
        WebDriverClient webDriverClient = WebDriverClient.getInstance();
        webDriverClient.getDriver().quit();
    }
}
