package com.dumitruc.training.stepdefs;

import com.dumitruc.training.BigAndHeavy;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dima on 25/07/2017.
 */
public class StepDefDateParse extends StepDefBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefBase.class);

    Scenario scenario;

    HashMap<Long, String> inDates = new HashMap();
    HashMap<Long, Date> outDate;

    SimpleDateFormat validationDateFormater = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean completed = false;

    long currentKey = 0;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
        LOGGER.info("Before scenario = " + scenario.getId());
    }

    @Given("^my transaction has the date as \"([^\"]*)\"$")
    public void myTransactionHasTheDateAs(String arg0) throws Throwable {
        inDates.put(currentKey, arg0);
    }

    @When("^my big machine processes this data$")
    public void myBigMachineProcessesThisData() throws Throwable {
        outDate = BigAndHeavy.parseDate(inDates);
    }

    @Then("^it identifies the date as \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void itIdentifiesTheDateAsWithValue(String format, String value) throws Throwable {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date expectedDate = simpleDateFormat.parse(value);

        assert validationDateFormater.format(outDate.get(currentKey))
                .equals(validationDateFormater.format(expectedDate));
    }

    @Given("^my transaction \"([^\"]*)\" has the date as \"([^\"]*)\"$")
    public void myTransactionHasTheDateAs(long key, String value) throws Throwable {
        currentKey = key;
        myTransactionHasTheDateAs(value);
    }

    @Then("^it identifies the \"([^\"]*)\" date as \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void itIdentifiesTheDateAsWithValue(long key, String format, String value) throws Throwable {
        currentKey = key;
        itIdentifiesTheDateAsWithValue(format, value);
    }

    @And("^application has run$")
    public void applicationHasRun() throws Throwable {
        outDate = BigAndHeavy.parseDate(inDates);
        completed = true;
    }

    @When("^my big machine finished processing the data$")
    public void myBigMachineFinishedProcessingTheData() throws Throwable {
        if (!completed) {
            applicationHasRun();
        }
    }

    @Given("^my transaction data contains the date as \"([^\"]*)\"$")
    public void myTransactionDataContainsTheDateAs(String arg0) throws Throwable {
        scenario.write("No actual data creation just validate data is present - sanity");
        assert inDates.containsValue(arg0);
    }

    @Given("^the dates$")
    public void theDates(DataTable dates) throws Throwable {
        for (List<String> strings : dates.raw()) {
            Long key=null;
            try {
                key = Long.parseLong(strings.get(0));
            }catch (Exception ex){
                LOGGER.info("Ignoring table key");
            }
            if (key != null){
                inDates.put(key,strings.get(1));
            }
        }
    }
}
