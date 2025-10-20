package definitions;

import driver.DriverSetup;
import dto.EmployeesPoint;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ComboTimelinePage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class OpenPageSteps {

    private WebDriver driver;
    private ComboTimelinePage comboTimelinePage;
    private static final String COMBO_TIMELINE_URL = "https://www.highcharts.com/demo/combo-timeline";

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
    public void openPage() {
        comboTimelinePage.openPage(COMBO_TIMELINE_URL);
    }

    @Then("Verification that the page was opened")
    public void verificationThatThePageWasOpened() {
        assertTrue(comboTimelinePage.isPageComboLineOpened());
    }

    @And("Agree to Cookies")
    public void weAgreeToCookies() {
        comboTimelinePage.agreeToCookies();
    }

    @And("Hide Revenue data")
    public void hideRevenueData() {
        comboTimelinePage.hideRevenue();
    }

    @Then("Hover each tracker point and verify the tooltip contents")
    public void hoverEachTrackerPointAndVerifyTooltip() {
        EmployeesPoint employeesPoint = new EmployeesPoint();

        comboTimelinePage.prepareChart();
        try {
            List<String> dates = employeesPoint.getDates();
            List<Integer> sums = employeesPoint.getEmpSum();

            int points = comboTimelinePage.sumEmployeesPoint().size();
            for (int i = 0; i < points; i++) {
                comboTimelinePage.hoverPointEmployees(i);

                String top = comboTimelinePage.getTooltipTop();
                String bottom = comboTimelinePage.getTooltipBottom();

                assertThat(top).
                        as("Tooltip top text should contain date (index %s). Actual: %s", i, top)
                        .contains(dates.get(i));

                assertThat(bottom).
                        as("Tooltip bottom text should contain '%s employees' (index %s). Actual: %s", sums.get(i), i, bottom)
                        .contains(sums.get(i) + " employees");
            }
        } finally {
            comboTimelinePage.restoreChart();
        }
    }
}