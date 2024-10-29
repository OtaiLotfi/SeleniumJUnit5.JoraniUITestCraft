package otai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import otai.configurations.ElementFinder;
@Component

public class HRReportsPage  extends BasePage {
    public HRReportsPage(WebDriver driver){
        super(driver);
    }

    private final By yearLabelXpath = By.xpath("//select[@name='cboYear']");
    private final By executeButtonXpath = By.xpath("//button[@id='cmdSubmit']");

    public void clickTheItemFromHeader(String itemLabelValue) {
        this.waitMillis(SHORT_WAIT);
        By itemLabelXpath = ElementFinder.itemLabel(itemLabelValue);
        this.waitVisibilityOfElement(itemLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement itemField = driver.findElement(itemLabelXpath);
        itemField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void clickTheReportLink(String itemLabelValue) {
        this.waitMillis(SHORT_WAIT);
        By reportLinkXpath = ElementFinder.itemLabel(itemLabelValue);
        this.waitVisibilityOfElement(reportLinkXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement reportLinkField = driver.findElement(reportLinkXpath);
        reportLinkField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void selectTheYear(String yearLabel) {
        this.waitVisibilityOfElement(yearLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement yearField = driver.findElement(yearLabelXpath);
        yearField.click();
        this.waitMillis(SHORT_WAIT);
        this.findTheYear(yearLabel).click();
    }

    public WebElement findTheYear(String yearLabel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By yearLabelXpath = ElementFinder.monthOrYearDataHandler(yearLabel);
        this.waitVisibilityOfElement(yearLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement yearFieldLabel = driver.findElement(yearLabelXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", yearFieldLabel);
        return yearFieldLabel;
    }

    public void clickTheExecuteButton() {
        this.waitVisibilityOfElement(executeButtonXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement executeButtonField = driver.findElement(executeButtonXpath);
        executeButtonField.click();
        this.waitMillis(SHORT_WAIT);
    }
}
