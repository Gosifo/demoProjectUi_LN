package pageObjects;

import actions.BaseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseAction {

    public HomePage(WebDriver driver){
        BaseAction.driver = driver;
    }

    public final By ABOUT_US = By.linkText("About Us");
    public final By CAREERS = By.xpath("(//a[@class='score-button btn-clickable-area'][normalize-space()='Learn More'])[1]");

}
