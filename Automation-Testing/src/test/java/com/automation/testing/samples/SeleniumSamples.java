package com.automation.testing.samples;
import com.automation.extensions.components.WebDriverExtensions;
import com.automation.extensions.components.WebDriverFactory;
import com.automation.extensions.contracts.DriverParams;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class SeleniumSamples {
    @Test
    public void WebDriverSamples() throws InterruptedException, IOException {
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe"))
                .usingAnyFreePort().build();
        WebDriver driver = new ChromeDriver(chromeDriverService);
        Thread.sleep(1000);
        driver.quit();

       /* GeckoDriverService geckoDriverService=new GeckoDriverService
                .Builder()
                .usingDriverExecutable(new File("C:\\Users\\RV\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe"))
                .usingAnyFreePort().build();

        driver=new FirefoxDriver(geckoDriverService);
        Thread.sleep(1000);
        driver.quit();*/
    }
    @Test
    public void webElementSamples() throws InterruptedException {
        ChromeDriverService chromeDriverService=new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        WebDriver driver =new ChromeDriver(chromeDriverService);
        driver.manage().window().maximize();
        driver.navigate().to("https://gravitymvctestapplication.azurewebsites.net/");
        driver.findElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void webDriverFactorySamples() throws InterruptedException, MalformedURLException {
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        driver.manage().window().maximize();
        driver.navigate().to("https://gravitymvctestapplication.azurewebsites.net/");
        driver.findElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void goToUrlSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void getElementSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        extensions.getElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void asSelectSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Course");
        extensions.asSelect(extensions.getElement(By.xpath("//select[@id='SelectedDepartment']"))).selectByIndex(1);
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void getElementsSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        List<WebElement> elements=extensions.getElements(By.xpath("//ul/li"));
        Thread.sleep(2000);
        driver.quit();
    }
   @Test
   public void getVisibleElementSamples() throws InterruptedException,MalformedURLException{
       WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
       WebDriverExtensions extensions=new WebDriverExtensions(driver);
       extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
       extensions.getVisibleElement(By.xpath("//a[.='Students']")).click();
       Thread.sleep(2000);
       driver.quit();
   }
    @Test
    public void getVisibleElementsSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        List<WebElement> elements=extensions.getVisibleElements(By.xpath("//ul/li"));
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void getEnabledElementSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        extensions.getEnabledElement(By.xpath("//input[@id='SearchString']")).sendKeys("Heloo");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void verticalWindowScrollSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        driver.manage().window().setSize(new Dimension(100,350));
        extensions.verticalWindowScroll(1000);
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void actionsSamples() throws InterruptedException,MalformedURLException{
        WebDriver driver =new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("C:\\Users\\RV\\Downloads\\chromedriver_win32 (5)")).get();
        WebDriverExtensions extensions=new WebDriverExtensions(driver);
        extensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        WebElement element=extensions.getVisibleElement(By.xpath("//a[.='Students']"));
        extensions.getActions(element).click().build().perform();
        Thread.sleep(2000);
        driver.quit();
    }
}
