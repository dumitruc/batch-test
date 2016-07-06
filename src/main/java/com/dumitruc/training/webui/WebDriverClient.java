package com.dumitruc.training.webui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.util.PendingException;

/**
 * Created by dima on 06/07/2016.
 */
public class WebDriverClient {

    private static final String BROWSER_KEY = "browser";
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverClient.class);
    private static WebDriverClient driverClient;
    private static BrowserType browserType;
    private WebDriver driver = launchChrome();


    private WebDriverClient() {
        //no access to create
    }

    public static WebDriverClient getInstance() {
        if (driverClient == null) {
            driverClient = new WebDriverClient();
        }
        return driverClient;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openBrowser() {
        LOGGER.info("Launching browser");
        browserType = BrowserType.valueOf(System.getProperty(BROWSER_KEY));
        if (browserType == null) {
            noBrowser(browserType.toString());
        }
        switch (browserType) {
            case FIREFOX:
                driver = launchFirefox();
                break;
            case CHROME:
                driver = launchChrome();
                break;
            default:
                noBrowser(browserType.toString());
        }

    }

    private WebDriver launchChrome() {
//        System.setProperty("webdriver.chrome.driver", );

        return new ChromeDriver();
    }

    private WebDriver launchFirefox() {
        return new FirefoxDriver();
    }

    private void noBrowser(String browser) {
        LOGGER.error("Browser " + browser + " not configured.");
        throw new PendingException("Brawser coul dnot be launched");
    }

    public void navigateToUrl(String url) {
        LOGGER.debug("Navigating to url: {}", url);
        driver.get(url);
    }

}
