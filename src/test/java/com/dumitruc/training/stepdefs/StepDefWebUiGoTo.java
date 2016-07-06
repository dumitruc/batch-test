package com.dumitruc.training.stepdefs;

import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class StepDefWebUiGoTo extends StepDefWebUiCommon {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefWebUiGoTo.class);


    @When("^I navigate to url \"([^\"]*)\"$")
    public void navigate(String url) throws Throwable {
        navigateToUrl(url);
    }

}
