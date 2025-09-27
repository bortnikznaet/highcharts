package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComboTimeline extends AbstractPage<ComboTimeline>{
    private static final String COMBO_TIMELINE_URL = "https://www.highcharts.com/demo/combo-timeline";

    @FindBy(xpath = "//img[@id='CookiebotSessionPixel']")
    private WebElement lastElemetsBodyHtml;

//    WebElement lastElement = driver.findElement(By.id("CookiebotSessionPixel"));

    public ComboTimeline(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Override
    public ComboTimeline openPage(){
        driver.get(COMBO_TIMELINE_URL);
        return this;
    }

    public Boolean isPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean urlOk = wait.until(ExpectedConditions.urlContains("/demo/highcharts/combo-timeline"));

        boolean lastElementOk = lastElemetsBodyHtml.getAttribute("alt").equals("Cookiebot session tracker icon loaded");

        return urlOk && lastElementOk;
    }
}
