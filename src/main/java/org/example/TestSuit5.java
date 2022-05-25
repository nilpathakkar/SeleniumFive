package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuit5 {
    protected static WebDriver driver;

    @BeforeMethod
    public void openTheBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

    }
    //--------------------------------------------------------------------------------------------------------------------
    @Test
    public void UserShouldBeRegisterSuccessfully(){
        // click on register button
        clickOnElement(By.className("ico-register"));

        //select gender
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();

        //enter first name
        typetext(By.xpath("//input[@name='FirstName']"), "Automation");

        //enter lastname
        typetext(By.id("LastName"), "LastNameTest");

        //Select day of birth from drop down
        Select DateOfBirthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
        DateOfBirthday.selectByIndex(29);

        //Select month of birth from drop down
        Select MonthOfBirthday = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        MonthOfBirthday.selectByIndex(11);

        //Select year of birth from  drop down
        Select YearOfBirthday = new Select(driver.findElement(By.name("DateOfBirthYear")));
        YearOfBirthday.selectByVisibleText("1984");

        // Enter  on Email address
        typetext(By.xpath("//input[@name=\"Email\"]"), "bmail" + randomDate() + "@gmail.com");

        //Enter password
        typetext(By.xpath("//input[@name=\"Password\"]"), "123456");

        //Enter confirm password
        typetext(By.xpath("//input[@name=\"ConfirmPassword\"]"), "123456");

        //Click on register
        clickOnElement(By.xpath("//button[@name=\"register-button\"]"));


        String actualMessage = driver.findElement(By.className("result")).getText();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not success ");

    }
    //-------------------------------------------------------------------------------------------------------------------
    @Test
    public void usherShouldSelectTheProductAndEmailToTheFriendSuccessfully(){
        // click on register button
        clickOnElement(By.className("ico-register"));

        //select gender
        driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click();

        //enter first name
        typetext(By.xpath("//input[@name='FirstName']"), "Automation");

        //enter lastname
        typetext(By.id("LastName"), "LastNameTest");

        //Select day of birth from drop down
        Select DateOfBirthday = new Select(driver.findElement(By.name("DateOfBirthDay")));
        DateOfBirthday.selectByIndex(29);

        //Select month of birth from drop down
        Select MonthOfBirthday = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        MonthOfBirthday.selectByIndex(11);

        //Select year of birth from  drop down
        Select YearOfBirthday = new Select(driver.findElement(By.name("DateOfBirthYear")));
        YearOfBirthday.selectByVisibleText("1984");

        // Enter  on Email address
        typetext(By.xpath("//input[@name=\"Email\"]"), "bmail" + randomDate() + "@gmail.com");

        //Enter password
        typetext(By.xpath("//input[@name=\"Password\"]"), "123456");

        //Enter confirm password
        typetext(By.xpath("//input[@name=\"ConfirmPassword\"]"), "123456");

        //Click on register
        clickOnElement(By.xpath("//button[@name=\"register-button\"]"));


        String actualMessage = driver.findElement(By.className("result")).getText();
        String expectedMessage = "Your registration completed";
        Assert.assertEquals(actualMessage, expectedMessage, "Registration is not success ");

        // click on continue button
        clickOnElement(By.xpath("//a[@class=\"button-1 register-continue-button\"]"));
        
        // click on  computers categories
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]"));

        //click on Desktop
        clickOnElement(By.xpath("//h2/a[@title=\"Show products in category Desktops\"]"));

        //click on build your own computer
        clickOnElement(By.xpath("//div[@class=\"product-item\"]/div[2]//a[@href=\"/build-your-own-computer\"]"));

        //click on email a friend
        clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));

        //type an email address
        typetext(By.xpath("//input[@class=\"friend-email\"]"),"abc" + randomDate() + "@gmail.com");

        //click on send email
        clickOnElement(By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]"));

        // to verify message (assert)
        String actualResult = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        String expectedResult = "Your message has been sent.";
        Assert.assertEquals(actualResult, expectedResult, "Message has not been sent ");

    }

    //-------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldAbleToChangeAndVerifyTheCurrencySuccessfully(){
        //Euro currency from drop down menu
        Select Euro = new Select(driver.findElement(By.name("customerCurrency")));
        Euro.selectByVisibleText("Euro");

        String actualCurrency = driver.findElement(By.xpath("//div[@data-productid=\"1\"]/div[2]//div[3]/div/span")).getText();
        String expectedCurrency = "€1032.00";
        Assert.assertEquals(actualCurrency, expectedCurrency, "Currency is different.");

        //Euro currency from drop down menu
        Select USDollar = new Select(driver.findElement(By.name("customerCurrency")));
        USDollar.selectByVisibleText("US Dollar");

        String actualcurrency = driver.findElement(By.xpath("//div[@data-productid=\"1\"]/div[2]//div[3]/div/span")).getText();
        String expectedcurrency = "$1,200.00";
        Assert.assertEquals(actualcurrency, expectedcurrency, "Currency is different.");
    }
    //------------------------------------------------------------------------------------------------------------------
    @Test
    public void userShouldBeSelectFeatureSuccessFully(){

        //clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/computers\"]"));
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]//a[@href=\"/computers\"]"));

        //click on Desktop
        clickOnElement(By.xpath("//h2/a[@title=\"Show products in category Desktops\"]"));

        //click on build your own computer
        clickOnElement(By.xpath("//div[@class=\"product-item\"]/div[2]//a[@href=\"/build-your-own-computer\"]"));

        //click on processor
        Select Processor= new Select(driver.findElement(By.xpath("//select[@name=\"product_attribute_1\"]")));
        Processor.selectByValue("1");

        //click RAM 2 GB
        Select RAM= new Select(driver.findElement(By.xpath("//select[@name=\"product_attribute_2\"]")));
        RAM.selectByValue("3");

        //click on HDD (option 1)
        clickOnElement(By.xpath("//input[@id=\"product_attribute_3_6\"]"));

        //click on OS (option 2)
        clickOnElement(By.xpath("//input[@id=\"product_attribute_4_9\"]"));

        //click on Software (option 2)
        clickOnElement(By.xpath("//label[@for=\"product_attribute_5_11\"]"));

        //click on Software (option 3)
        clickOnElement(By.xpath("//label[@for=\"product_attribute_5_12\"]"));

        //click on ADD TO CART button
        clickOnElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));

        //click on SHOPPING BASKET
        clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));

        // To verify product in shopping basket
        String actualProductInBasket = driver.findElement(By.xpath("//td[@class=\"product\"]/a")).getText();
        String expectedProductInBasket = "Build your own computer";
        Assert.assertEquals(actualProductInBasket, expectedProductInBasket, "Product is not match");
    }
    //-----------------------------------------------------------------------------------------------------------------
    @AfterMethod
    public void  Quit(){
        driver.quit();
    }
//---------------------------------------------------------------------------------------------------------------------
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
