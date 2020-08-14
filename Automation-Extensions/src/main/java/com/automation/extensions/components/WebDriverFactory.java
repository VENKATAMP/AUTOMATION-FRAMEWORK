package com.automation.extensions.components;

import com.automation.extensions.contracts.DriverParams;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    private DriverParams driverParams;

    public WebDriverFactory(String driverParamsJson) {
        this(loadParams(driverParamsJson));
    }

    public WebDriverFactory (DriverParams driverParams) {
        this.driverParams=driverParams;
    }

    /**
     * Generate webdriver based on input params
     * @return webdriver instance
     * @throws MalformedURLException
     */
    public WebDriver get() throws MalformedURLException {
        if(driverParams.getSource()==null || !driverParams.getSource().toUpperCase().equals("REMOTE")){
            return getDriver();
        }
        return getRemoteDriver();
    }
    //Local Drivers
    private WebDriver getChrome(){
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries()+"\\chromedriver.exe"))
                .usingAnyFreePort().build();
       return new ChromeDriver(chromeDriverService);
    }
    private WebDriver getFirefox(){
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries()+"\\chromedriver.exe"))
                .usingAnyFreePort().build();
        return new ChromeDriver(chromeDriverService);
    }
    private WebDriver getIE(){
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries()+"\\chromedriver.exe"))
                .usingAnyFreePort().build();
        return new ChromeDriver(chromeDriverService);
    }
    private WebDriver getDriver(){
        switch(driverParams.getDriver().toUpperCase()){
            case "IE": return getIE();
            case "FIREFOX": return getFirefox();
            case "CHROME":
            default: return getChrome();
        }
    }
    //Remote
    private WebDriver getRemoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()),new ChromeOptions());
    }
    private WebDriver getRemoteDriver() throws MalformedURLException {
        switch(driverParams.getDriver().toUpperCase()){
            case "IE":
            case "FIREFOX":
            case "CHROME":
            default: return getRemoteChrome();
        }
    }

    //load json into driver params object
    private static DriverParams loadParams(String driverParamsJson) {
        if (driverParamsJson == null || driverParamsJson.isEmpty()) {
            return new DriverParams().setDriver("Chrome").setSource("Local").setBinaries(".");//Here setBinaries is dot that is setting current location
        }
        return new Gson().fromJson(driverParamsJson,DriverParams.class);
    }
}

