package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.Set;

public class Main {
    public static WebDriver driver;
    public static final By ACCEPT_ALL_BTN = By.id("onetrust-accept-btn-handler");
    public static final By ABOUT_US = By.linkText("About Us");
    public static final By CAREERS = By.xpath("(//a[@class='score-button btn-clickable-area'][normalize-space()='Learn More'])[1]");
    public static final By SEARCH_JOB = By.xpath("//a[normalize-space()='Search jobs']");
    public static final By SEARCH_BOX = By.id("search-box-d3ba3a32752d48908f4061d0129326bf");
    public static final By SEARCH_BTN = By.cssSelector("#search-box-button");
    public static final By SEARCH_RESULT = By.id("search-results-statistics-e0271e2d03ab43d1b65ffb7850e12e1d");


    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver(); // Initialize WebDriver
        driver.get("https://risk.lexisnexis.co.uk/");
        driver.manage().window().maximize();

// Store the current window handle
        String originalTab = driver.getWindowHandle();

        waitUntilElementToBeClickable(ACCEPT_ALL_BTN);
        clickElement(ACCEPT_ALL_BTN);
        clickElement(ABOUT_US);
        clickElement(CAREERS);

        // Get window handles
        Set<String> windowHandles = driver.getWindowHandles();
        String newTabHandle = (String) windowHandles.toArray()[1];

        // Switch to the new tab
        driver.switchTo().window(newTabHandle);

        waitUntilElementIsVisible(SEARCH_JOB);

        WebElement element = driver.findElement(SEARCH_JOB);
        // Scroll into view using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        clearAndEnterTextInElement(SEARCH_BOX, "automation tester");
        clickElement(SEARCH_BTN);

        Thread.sleep(2000);
        String searchResult = driver.findElement(SEARCH_RESULT).getText().replaceAll("[^0-9]", "");
        System.out.println(searchResult);
        int searchResultInInt = Integer.parseInt(searchResult);
        Assert.assertTrue(searchResultInInt>2);
        Thread.sleep(2000);
        driver.quit();
    }






    public static void waitUntilElementIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clickElement(By by) {
        waitUntilElementToBeClickable(by);
        elementFinder(by).click();
    }

    public static void enterTextInElement(By by, String text) {
        waitUntilElementIsVisible(by);
        elementFinder(by).sendKeys(text);
    }

    public static void clearAndEnterTextInElement(By by, String text) {
        waitUntilElementIsVisible(by);
        elementFinder(by).clear();
        enterTextInElement(by, text);
    }

    public static WebElement elementFinder(By by) {
        return driver.findElement(by);
    }

    public static boolean isElementPresent(By by) {
        try {
            elementFinder(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}