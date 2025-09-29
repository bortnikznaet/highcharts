package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ComboTimelinePage extends AbstractPage<ComboTimelinePage>{
    private static final String COMBO_TIMELINE_URL = "https://www.highcharts.com/demo/combo-timeline";

    @FindBy(xpath = "//img[@id='CookiebotSessionPixel']")
    private WebElement lastElementBodyHtml;


    public ComboTimelinePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public ComboTimelinePage open(){
        return openPage(COMBO_TIMELINE_URL);
    }


    public Boolean isPageComboLineOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean urlOk = wait.until(ExpectedConditions.urlContains("/demo/highcharts/combo-timeline"));
        boolean lastElementOk = lastElementBodyHtml.getAttribute("alt").equals("Cookiebot session tracker icon loaded");
        boolean getTitle = driver.getTitle().contains("Combo Timeline");

        return urlOk && lastElementOk && getTitle;
    }
}
