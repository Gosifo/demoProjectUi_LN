package pageObjects;

import actions.BaseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobsPage extends BaseAction {

    public JobsPage(WebDriver driver){
        BaseAction.driver = driver;
    }

    public final By SEARCH_BOX = By.id("search-box-d3ba3a32752d48908f4061d0129326bf");
    public final By SEARCH_BTN = By.cssSelector("#search-box-button");
    public final By SEARCH_RESULT = By.id("search-results-statistics-e0271e2d03ab43d1b65ffb7850e12e1d");
    public final By NO_RESULTS_TXT = By.cssSelector("[class='no-results']");
}
