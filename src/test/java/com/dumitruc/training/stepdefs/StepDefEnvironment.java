package com.dumitruc.training.stepdefs;

import com.dumitruc.training.stepdefs.StepDefBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class StepDefEnvironment extends StepDefBase{

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefEnvironment.class);

    @Given("^I have test conditions id: (\\S+)$")
    public void logTestConditions(String tcId) throws Throwable {
        LOGGER.info("=========================================");
        LOGGER.info("Executing test id: "+tcId);
    }

    @Given("^I have setup my cucumber framework$")
    public void checkCucumberIsThere() throws Throwable {
        LOGGER.info("Cucumber seems to be working fine...");
    }

    @When("^I say hello to (\\S+)$")
    public void iSayHelloTo(String whom) throws Throwable {
        LOGGER.info("Receiving step argument: "+whom);
    }

    @Then("^(\\S+) says hello back to (\\S+)$")
    public void sayHelloFromTo(String whom, String who) throws Throwable {
        LOGGER.info(whom+" is saying hello to "+who);
        assertThat("These are same person",whom,is(not(who)));
    }



}
