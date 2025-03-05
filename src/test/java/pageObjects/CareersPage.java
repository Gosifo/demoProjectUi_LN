package pageObjects;

import actions.BaseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage extends BaseAction {

    public CareersPage(WebDriver driver){
        BaseAction.driver = driver;
    }

    public final By SEARCH_JOB = By.xpath("//a[normalize-space()='Search jobs']");

    public void scrollAndSelectSearchJob(){
        WebElement element = driver.findElement(SEARCH_JOB);

        // Scroll into view using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
