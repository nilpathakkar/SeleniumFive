package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit5 {
    protected static WebDriver driver;





    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typetext(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMYYYYHHmmss");
        return formatter.format(date);

    }

    public static String getTexFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public static void waitForClickable(By by) {
        driver.findElement(By.className("by")).click();
    }

    public static void driverWaitsUntillURLTobe(int time, String url) {
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.urlToBe(url));
    }

    public static void driverWaitsUntillToBeClickable(int time, By by) {
        WebDriverWait wait02 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait02.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void driverWaitsUntilltitlesIS(int time, String title) {
        WebDriverWait wait03 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait03.until(ExpectedConditions.titleIs("String title"));
    }

    public static void driverWaitsUntillnumberOfElementsToBe(By by, int time, int x) {
        WebDriverWait wait04 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait04.until(ExpectedConditions.numberOfElementsToBe(by, x));
    }

    public static void driverWaitsUntillnumberOfWindowsToBe(int time, int i) {
        WebDriverWait wait05 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait05.until(ExpectedConditions.numberOfWindowsToBe(i));
    }

    public static void driverWaitsUntilFrameToBeAvailableAndSwitchToIt(int time, By by) {
        WebDriverWait waits06 = new WebDriverWait(driver, Duration.ofSeconds(time));
        waits06.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public static void driverWaitsUntilNumberOfElementsToBeLessThan(int time, By by, int number) {
        WebDriverWait wait07 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait07.until(ExpectedConditions.numberOfElementsToBeLessThan(by, 5));
    }

    public static void driverWaitsUntilNumberOfElementsToBeMoreThan(int time, By by, int number) {
        WebDriverWait wait08 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait08.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 10));
    }

    public static void driverWaitsUntilInvisibilityOfElementLocated(int time, By by) {
        WebDriverWait wait09 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait09.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void driverWaitsUntilNumberOfElementsToBe(By by, int number) {
        WebDriverWait wait10 = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait10.until(ExpectedConditions.numberOfElementsToBe(by, 10));

    }

    public static void driverWaitUntilInvisibilityOf(int time, WebElement element) {
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait01.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void driverWaitUntilElementToBeClickable(By by, int time) {
        WebDriverWait wait02 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait02.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void driverWaitElementToBeSelected(int time, By by) {
        WebDriverWait wait03 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait03.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void driverWaitUrlName(int time, String UrlName) {
        WebDriverWait wait04 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait04.until(ExpectedConditions.urlContains(UrlName));
    }

    public static void driverWaitAttributeToBe(int time, String Attribute, String Value, By by) {
        WebDriverWait wait05 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait05.until(ExpectedConditions.attributeToBe(by, Attribute, Value));
    }

    public static void driverWaitAlertIsPresent(int time) {
        WebDriverWait wait06 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait06.until(ExpectedConditions.alertIsPresent());
    }

    public static void driverWaitAttributeToBeNotEmpty(int time, WebElement webElement, String y) {
        WebDriverWait wait07 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait07.until(ExpectedConditions.attributeToBeNotEmpty(webElement, y));
    }
}
