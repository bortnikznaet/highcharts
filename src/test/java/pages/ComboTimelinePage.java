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
    private static final By POINT_TRACKER = By.cssSelector("path.highcharts-point[role='img'][aria-label*='employees']");
    private static final By TOOL_TIP_TOP = By.cssSelector("#container svg .highcharts-tooltip text tspan:first-of-type");
    private static final By TOOL_TIP_BOTTOM = By.cssSelector("#container svg .highcharts-tooltip text tspan[style*='font-weight']");
    private static final By TOOL_TIP_GROUP = By.cssSelector("g.highcharts-tooltip");

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

    public void hideRevenue() {
        activateDemoFrame();

        Actions actions = new Actions(driver);
        actions
                .moveToElement(revenueLink)
                .moveByOffset(2, 2)
                .click(revenueLink)
                .perform();
    }

    public void activateDemoFrame() {
        driver.switchTo().defaultContent();

        By frame = By.cssSelector("iframe[src*='highcharts'][src*='combo-timeline']");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#container svg")));
    }

    public void prepareChart() {
        ((JavascriptExecutor) driver).executeScript(
                "var f = document.querySelectorAll('#container svg g.highcharts-flags-series, #container svg g.highcharts-flags-series *');" +
                        "f.forEach(n => n.setAttribute('data-prev-pe', n.style.pointerEvents||''));" +
                        "f.forEach(n => n.style.pointerEvents='none');"
        );
    }

    public void restoreChart() {
        ((JavascriptExecutor) driver).executeScript(
                "var f = document.querySelectorAll('#container svg g.highcharts-flags-series, #container svg g.highcharts-flags-series *');" +
                        "f.forEach(n => n.style.pointerEvents = n.getAttribute('data-prev-pe') || '');" +
                        "f.forEach(n => n.removeAttribute('data-prev-pe'));"
        );
    }

    public List<WebElement> sumEmployeesPoint() {
        return driver.findElements(POINT_TRACKER);
    }

    public void hoverPointEmployees(int index) {
        String js =
                "var c=(Highcharts&&Highcharts.charts||[]).find(x=>x&&x.renderTo&&x.renderTo.id==='container');" +
                        "if(!c) return 'NO_CHART';" +
                        "var s=c.series.find(x=>x && x.name && x.name.toLowerCase().includes('employees')) || c.series[1];" +
                        "if(!s) return 'NO_SERIES';" +
                        "var p=s.points[" + index + "];" +
                        "if(!p) return 'NO_POINT';" +
                        "p.onMouseOver(); return 'OK';";

        Object res = ((JavascriptExecutor) driver).executeScript(js);
        if (!"OK".equals(res)) {
            throw new IllegalStateException("Hover failed for index " + index + ": " + res);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(TOOL_TIP_GROUP));
    }

    public String getTooltipTop() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TOOL_TIP_TOP)).getText();
    }

    public String getTooltipBottom() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(TOOL_TIP_BOTTOM)).getText();
    }
}

