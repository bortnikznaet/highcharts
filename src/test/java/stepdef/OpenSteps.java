package stepdef;

import driver.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ComboTimeline;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenSteps {

    private WebDriver driver;
    private ComboTimeline comboTimeline;

    @After
    public void afterScenario() {
        DriverSetup.quitDriver();
    }

    @Before
    public void init() {
        driver = DriverSetup.getDriver();
        comboTimeline = new ComboTimeline(driver);
    }

    @And("Open the page")
    public void openPage(){
        comboTimeline.openPage();
    }

    @Then("Verification that the page was opened")
    public void verificationThatThePageWasOpened() {
        assertTrue(comboTimeline.isPageOpened());
    }
}
