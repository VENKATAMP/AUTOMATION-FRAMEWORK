package com.automation.extensions.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import javax.naming.directory.NoSuchAttributeException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebDriverExtensions { //Like Utilities
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    public WebDriverExtensions(WebDriver driver){
        this.driver=driver;
        wait=new FluentWait<>(driver); /*.ignoring(NoSuchElementException.class);*/
    }
    public WebDriver goToUrl(String url){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        return driver;
    }
    public WebElement getElement(By by){
        return getElement(by,Duration.ofSeconds(15));
    }
    public WebElement getElement(By by, Duration timeout){
        return wait.withTimeout(timeout).until(d->d.findElement(by));
    }
    public Select asSelect(WebElement element){
        return new Select(element);
    }
    public List<WebElement> getElements(By by){
        return getElements(by,Duration.ofSeconds(15));
    }
    public List<WebElement> getElements(By by, Duration timeout){
        return wait.withTimeout(timeout).until(d->d.findElements(by));
    }
    public WebElement getVisibleElement(By by){
        return getVisibleElement(by,Duration.ofSeconds(15));
    }
    public WebElement getVisibleElement(By by, Duration timeout){
        return wait.withTimeout(timeout).until(d->{
            WebElement element=d.findElement(by);
            if(!element.isDisplayed()){
                throw new NoSuchElementException("Element exists, but not displayed");
            }
            return element;
        });
    }
    public List<WebElement> getVisibleElements(By by){
        return getVisibleElements(by,Duration.ofSeconds(15));
    }
    public List<WebElement> getVisibleElements(By by, Duration timeout){
        return wait.withTimeout(timeout).until(d->d.findElements(by).stream().filter(WebElement::isDisplayed).collect(Collectors.toList()));
    }
    public WebElement getEnabledElement(By by){
        return getEnabledElement(by,Duration.ofSeconds(15));
    }
    public WebElement getEnabledElement(By by, Duration timeout){
        return wait.withTimeout(timeout).until(d->{
            WebElement element=d.findElement(by);
            if(!element.isEnabled()){
                throw new NoSuchElementException("Element exists, but not displayed");
            }
            return element;
        });
    }
    public WebDriver verticalWindowScroll(int scrollAmt){
        String script=String.format("window.scroll(0,%d)",scrollAmt);
        ((JavascriptExecutor) driver).executeScript(script);
        return driver;
    }
    public Actions getActions(WebElement element){
        WebDriver driver=((WrapsDriver)element).getWrappedDriver();
        Actions actions=new Actions(driver);
        return actions.moveToElement(element);
    }
    public WebElement forceClick(WebElement element){
        WebDriver driver=((WrapsDriver)element).getWrappedDriver();
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
        return element;
    }

}
