package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ComboTimelinePage extends AbstractPage<ComboTimelinePage> {
    private static final String COMBO_TIMELINE_URL = "https://www.highcharts.com/demo/combo-timeline";

    private static final By POINT_TRACKER = By.cssSelector("path.highcharts-point[role='img'][aria-label*='employees']");
    private static final By TOOL_TIP_TOP = By.cssSelector("#container svg .highcharts-tooltip text tspan:first-of-type");
    private static final By TOOL_TIP_BOTTOM = By.cssSelector("#container svg .highcharts-tooltip text tspan[style*='font-weight']");

    @FindBy(xpath = "//img[@id='CookiebotSessionPixel']")
    private WebElement lastElementBodyHtml;

    @FindBy(xpath = "//button[@id='hc-cookie-dialog-accept']")
    private WebElement btnAllowAllCookies;

    @FindBy(xpath = "//*[@id='container']//*[contains(@class,'highcharts-legend')]//*[contains(@class,'highcharts-legend-item')][./*[name()='text' and normalize-space()='Revenue']]")
    private WebElement revenueLink;



    public ComboTimelinePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ComboTimelinePage openPage() {
        return openPage(COMBO_TIMELINE_URL);
    }

    public Boolean isPageComboLineOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean urlOk = wait.until(ExpectedConditions.urlContains("/demo/highcharts/combo-timeline"));
        boolean lastElementOk = lastElementBodyHtml.getAttribute("alt").equals("Cookiebot session tracker icon loaded");
        boolean getTitle = driver.getTitle().contains("Combo Timeline");

        return urlOk && lastElementOk && getTitle;
    }

    public void agreeToCookies() {
        btnAllowAllCookies.click();
    }

    public void hideRevenue(){
        activateDemoFrame();
        Actions actions = new Actions(driver);
        actions
                .moveToElement(revenueLink)
                .moveByOffset(2,2)
                .pause(Duration.ofMillis(100))
                .click(revenueLink)
                .perform();

    }

    public void activateDemoFrame() {

        List<WebElement> iframes = driver.findElements(By.cssSelector("iframe"));
        if (!iframes.isEmpty()) {
            for (WebElement f : iframes) {
                driver.switchTo().frame(f);
                if (!driver.findElements(By.cssSelector("#container svg")).isEmpty()) {
                    break;
                } else {
                    driver.switchTo().defaultContent();
                }
            }
        }
    }

    public void hoverPointEmployees(int value) {
        activateDemoFrame();
        List<WebElement> point = driver.findElements(POINT_TRACKER);

        ((JavascriptExecutor) driver).executeScript(
                "var f = document.querySelectorAll('#container svg g.highcharts-flags-series, " +
                        "#container svg g.highcharts-flags-series *');" +
                        "f.forEach(n => n.setAttribute('data-prev-pe', n.style.pointerEvents||''));" +
                        "f.forEach(n => n.style.pointerEvents='none');"
        );
        try {
            Actions actions = new Actions(driver);
            actions
                    .moveToElement(point.get(value-1))
                    .moveByOffset(1,-20)
                    .pause(Duration.ofMillis(100))
//                    .click(point.get(value-1))
                    .perform();
        }
        finally {
            ((JavascriptExecutor) driver).executeScript(
                    "var f = document.querySelectorAll('#container svg g.highcharts-flags-series, " +
                            "#container svg g.highcharts-flags-series *');" +
                            "f.forEach(n => n.style.pointerEvents = n.getAttribute('data-prev-pe') || '');" +
                            "f.forEach(n => n.removeAttribute('data-prev-pe'));"
            );
        }

    }

    public Boolean checkDateTooltip(String date, String sumEmployees) {
        return driver.findElement(TOOL_TIP_TOP).getText().contains(date)
                && driver.findElement(TOOL_TIP_BOTTOM).getText().contains(sumEmployees + " employees");
    }
}
