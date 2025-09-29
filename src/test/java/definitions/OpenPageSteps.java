package definitions;

import driver.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ComboTimelinePage;

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
    public void openPage(){
        comboTimelinePage.open();
    }

    @Then("Verification that the page was opened")
    public void verificationThatThePageWasOpened() {
        assertTrue(comboTimelinePage.isPageComboLineOpened());
    }
}
