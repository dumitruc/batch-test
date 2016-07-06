package com.dumitruc.training.stepdefs;

import com.dumitruc.training.webui.WebDriverClient;
import org.hamcrest.CoreMatchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by dumitruc on 12/12/2014.
 */
public class StepDefWebUiCommon extends StepDefBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(StepDefWebUiCommon.class);
    WebDriverClient webDriverClient = WebDriverClient.getInstance();

    public void verifyBrowser() {
        assertThat("Browser was not launched for the test", webDriverClient, is(CoreMatchers.notNullValue()));
    }

    public void navigateToUrl(String url) {
        webDriverClient.navigateToUrl(url);
        System.out.printf("hello");
    }

}
