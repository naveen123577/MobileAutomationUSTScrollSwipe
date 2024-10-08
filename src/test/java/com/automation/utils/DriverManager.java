package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static AppiumDriver driver;

    public static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
        capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));

        if (ConfigReader.getConfigValue("application.name").equals("expedia")) {
            capabilities.setCapability("app", ConfigReader.getConfigValue("expedia.app.path"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("expedia.app.activity"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("expedia.app.package"));
        } else {
            capabilities.setCapability("app", ConfigReader.getConfigValue("ebay.app.path"));
        }

        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
