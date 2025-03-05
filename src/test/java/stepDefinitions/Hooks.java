package stepDefinitions;

import actions.BaseAction;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilityHelper.PropertyManager;
import java.io.File;
import java.io.IOException;


public class Hooks extends BaseAction {

    PropertyManager propertyManager = new PropertyManager();
    private final String getBasePath =  System.getProperty("user.dir");

    @Before
    public void InitializeTest() throws IOException {
        //Check to see if driver exist open, if we have an existing one use that one and don't open a new driver
        if (driver == null) {
            switch (propertyManager.getBrowser().toLowerCase()) {
                case "chrome":
                    System.out.println("Opening Chrome Browser");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefox":
                    System.out.println("Opening FireFox Browser");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                    System.out.println("Incorrect browser specified");
                    break;
            }
        }
    }


    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }


    //Check to see if test failed and if failed take screenshot and close browser
    @After
    public void TearDownTest(Scenario scenario) {
        String pageTitle = driver.getTitle();
        String screenshotPath = getBasePath + "\\screenshot\\";
        try {
            if (scenario.isFailed()) {
                System.out.println("Test scenario: " + scenario.getName() + " [Failed]" + "\n" +
                        "See Screenshot with id for information: " + scenario.getName() + "- " + pageTitle + "- " );
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(scrFile, new File(screenshotPath + scenario.getName() + "- " + pageTitle + "- " + ".jpg"));
                closeBrowser();
            } else {
                System.out.println("\n" + "Test scenario: " + scenario.getName() + " [Passed]");
                driver.navigate().to(propertyManager.getSiteUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
