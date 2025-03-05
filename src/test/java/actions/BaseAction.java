package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseAction {

    public static WebDriver driver;

    public static void waitUntilElementIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement elementFinder(By by) {
        return driver.findElement(by);
    }

    public void clickElement(By by) {
        waitUntilElementToBeClickable(by);
        elementFinder(by).click();
    }

    public void enterTextInElement(By by, String text) {
        waitUntilElementIsVisible(by);
        elementFinder(by).click();
        elementFinder(by).clear();
        elementFinder(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return elementFinder(by).getText();
    }

}
