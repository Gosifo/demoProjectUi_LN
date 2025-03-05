package stepDefinitions;

import actions.BaseAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.CareersPage;
import pageObjects.HomePage;
import pageObjects.JobsPage;
import utilityHelper.PropertyManager;
import java.io.IOException;
import static org.junit.Assert.*;


public class StepDef extends BaseAction{

    PropertyManager propertyManager = new PropertyManager();
    HomePage homePage = new HomePage(driver);
    CareersPage careersPage = new CareersPage(driver);
    JobsPage jobsPage = new JobsPage(driver);



    @Given("I navigate to the LexisNexis website")
    public void iNavigateToTheLexisNexisWebsite() throws IOException {
        driver.get(propertyManager.getSiteUrl());
    }

    @When("I navigate to the careers job page")
    public void iNavigateToTheCareersJobPage() {
        clickElement(homePage.ABOUT_US);
        clickElement(homePage.CAREERS);

        waitUntilElementIsVisible(careersPage.SEARCH_JOB);
        careersPage.scrollAndSelectSearchJob();
    }

    @And("I enter {string} in the search field for jobs or keywords")
    public void iEnterInTheSearchFieldForJobsOrKeywords(String jobSearch) {
        enterTextInElement(jobsPage.SEARCH_BOX, jobSearch);
    }

    @And("I select the search option")
    public void iSelectTheSearchOption() {
    }


    @Then("I should see more than {int} search result returned for {string}")
    public void iShouldSeeMoreThanSearchResultReturned(int arg0, String searchText) {
        String xpathExpression = String.format("//*[contains(text(), 'Results \"%s\"')]", searchText);
        By resultText = By.xpath(xpathExpression);
        waitUntilElementIsVisible(resultText);

        String searchResult = getTextFromElement(jobsPage.SEARCH_RESULT).replaceAll("[^0-9]", "");
        int searchResultInInt = Integer.parseInt(searchResult);

        assertTrue(searchResultInInt > 1);
    }

    @And("I should see {int} role\\(s) listed for {string}")
    public void iShouldSeeRoleSListed(int expectedNoOfRoles, String searchText) {
       int actualNoOfRoles = driver.findElements(By.cssSelector("[class='ais-hits--item']")).size();
       assertEquals(expectedNoOfRoles, actualNoOfRoles);
    }
}