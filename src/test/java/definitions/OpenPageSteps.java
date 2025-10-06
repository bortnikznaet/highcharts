package definitions;

import driver.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ComboTimelinePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenPageSteps {

    private WebDriver driver;
    private ComboTimelinePage comboTimelinePage;

    @After
    public void afterScenario() {
        DriverSetup.quitDriver();
    }

    @Before
    public void init() {
        driver = DriverSetup.getDriver();
        comboTimelinePage = new ComboTimelinePage(driver);
    }

    @When("Open the page")
    public void openThePage() {
        comboTimelinePage.openPage();
    }

    @Then("Verification that the page was opened")
    public void verificationThatThePageWasOpened() {
        assertTrue(comboTimelinePage.isPageComboLineOpened());
    }


    @And("Agree to Cookies")
    public void weAgreeToCookies() {
        comboTimelinePage.agreeToCookies();
    }

    @Then("Tooltip has date {string} and employees {string}")
    public void tooltipHasDateKeyDateAndEmployeesSumEmployees(String date, String sumEmployees) {
        assertEquals(true, comboTimelinePage.checkDateTooltip(date, sumEmployees));
    }

    @And("On the tracker line, hover point number {int}")
    public void onTheTrackerLineClickPointNumberNo(int value) {
        comboTimelinePage.hoverPointEmployees(value);
    }

    @And("Hide Revenue data")
    public void hideRevenueData() {
        comboTimelinePage.hideRevenue();
    }
}
