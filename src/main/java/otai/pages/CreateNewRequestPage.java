package otai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import otai.configurations.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component

public class CreateNewRequestPage extends BasePage {
    public CreateNewRequestPage(WebDriver driver){
        super(driver);
    }

    private final By selectionArrowForLeaveType = By.xpath("//span[contains(@class,'select2-selection__arrow')]/b");

    public void clickOnStatusOperation(String statusOperationLabel) {
        this.waitMillis(SHORT_WAIT);
        By statusOperationXpath = ElementFinder.statusOperationName(statusOperationLabel);
        this.waitVisibilityOfElement(statusOperationXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement statusOperationButton = driver.findElement(statusOperationXpath);
        statusOperationButton.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void createNewRequest(String requestOperationLabel) {
        By requestXpath = ElementFinder.requestOperationButton(requestOperationLabel);
        this.waitVisibilityOfElement(requestXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement requestOperationButton = driver.findElement(requestXpath);
        requestOperationButton.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void chooseLeaveType(String leaveTypeLabel) {
        this.waitVisibilityOfElement(selectionArrowForLeaveType, ELEMENT_VISIBILITY_DELAY);
        WebElement selectionArrowButton = driver.findElement(selectionArrowForLeaveType);
        selectionArrowButton.click();
        this.waitMillis(SHORT_WAIT);
        this.selectLeaveType(leaveTypeLabel).click();
    }

    public WebElement selectLeaveType(String leaveTypeLabel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By leaveTypeLabelXpath = ElementFinder.leaveType(leaveTypeLabel);
        this.waitVisibilityOfElement(leaveTypeLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement leaveTypeFieldLabel = driver.findElement(leaveTypeLabelXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", leaveTypeFieldLabel);
        return leaveTypeFieldLabel;
    }

    public void entreTheDate(String dateType) {
        By dateTypeXpath = ElementFinder.inputDate(dateType);
        this.waitVisibilityOfElement(dateTypeXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement dateTypeInput = driver.findElement(dateTypeXpath);
        //this.waitMillis(SHORT_WAIT);
        dateTypeInput.click();
    }

    public void entreMonthOrYear(String monthOrYearLabel, String dataHandler) {
        By monthOrYearXpath = ElementFinder.monthOrYearLabel(monthOrYearLabel);
        this.waitVisibilityOfElement(monthOrYearXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement field = driver.findElement(monthOrYearXpath);
        field.click();
        this.waitMillis(SHORT_WAIT);
        this.chooseMonthOrYear(dataHandler).click();
    }

    public WebElement chooseMonthOrYear(String dataHandler) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By monthLabelXpath = ElementFinder.monthOrYearDataHandler(dataHandler);
        this.waitVisibilityOfElement(monthLabelXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement monthField = driver.findElement(monthLabelXpath);
        js.executeScript("arguments[0].scrollIntoView(true);", monthField);
        return monthField;
    }

    public void entreDataMonth(String dataMonthValue) {
        By dataMonthXpath = ElementFinder.dataMonth(dataMonthValue);
        this.waitVisibilityOfElement(dataMonthXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement dataMonthField = driver.findElement(dataMonthXpath);
        dataMonthField.click();
        this.waitMillis(SHORT_WAIT);
    }
}
