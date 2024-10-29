package otai.pages;

import otai.configurations.ElementFinder;
import org.openqa.selenium.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class LeaveRequestsPage extends BasePage {
    public LeaveRequestsPage(WebDriver driver) {
        super(driver);
    }

    private final By loginButton = By.xpath("//button[@id='send']");
    private final By formatListBulleted = By.xpath("//div[@class='nav-responsive']//i[contains(@class,'bulleted')]");
    private final By searchFilterStatus = By.xpath("//input[@type='search']");
    private final By selectTypeField = By.xpath("//select[@id='cboLeaveType']");
    private final By showEntriesField = By.xpath("//select[@name='leaves_length']");
    private final By firstLeaveRequestID = By.xpath("//tr[@role='row']/td/a");


    public void clickLoginButton() {
        this.waitVisibilityOfElement(loginButton, ELEMENT_VISIBILITY_DELAY);
        driver.findElement(loginButton).click();
        this.waitMillis(SHORT_WAIT);
    }

    public void clickTheFormatListBulleted() {
        this.waitVisibilityOfElement(formatListBulleted, ELEMENT_VISIBILITY_DELAY);
        driver.findElement(formatListBulleted).click();
    }

    public void searchFiltersStatus(String filterStatus) {
        this.waitVisibilityOfElement(searchFilterStatus, ELEMENT_VISIBILITY_DELAY);
        WebElement searchStatus = driver.findElement(searchFilterStatus);
        searchStatus.clear();
        searchStatus.sendKeys(filterStatus);
        searchStatus.sendKeys(Keys.ENTER);
        this.waitMillis(SHORT_WAIT);
    }

    public void chooseType(String label) {
        List<String> typeLabels = this.getTypeLabels(label);
        for (String typeLabel : typeLabels) {
            this.waitVisibilityOfElement(selectTypeField, ELEMENT_VISIBILITY_DELAY);
            WebElement typeField = driver.findElement(selectTypeField);
            typeField.click();
            this.waitMillis(1000);
            this.selectType(typeLabel).click();
        }
    }

    public void chooseLeavesLength(String leavesLengthLabel) {
        List<String> leaveLength = this.getLeavesLength(leavesLengthLabel);
        for (String leaveLengthLabel : leaveLength) {
            this.waitVisibilityOfElement(showEntriesField, ELEMENT_VISIBILITY_DELAY);
            WebElement leaveLengthField = driver.findElement(showEntriesField);
            leaveLengthField.click();
            this.waitMillis(SHORT_WAIT);
            this.selectType(leaveLengthLabel).click();
        }
    }

    public void chooseDefaultLeavesLength(String typeLabel) {
        this.waitVisibilityOfElement(showEntriesField, ELEMENT_VISIBILITY_DELAY);
        WebElement typeField = driver.findElement(showEntriesField);
        typeField.click();
        this.waitMillis(SHORT_WAIT);
        this.selectType(typeLabel).click();
    }

    public WebElement selectType(String label) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        this.waitVisibilityOfElement(ElementFinder.typeLabel(label), ELEMENT_VISIBILITY_DELAY);
        WebElement optionField = driver.findElement(ElementFinder.typeLabel(label));
        js.executeScript("arguments[0].scrollIntoView(true);", optionField);
        return optionField;
    }

    public void checkFilterStatusCheckbox(String label) {
        this.waitVisibilityOfElement(ElementFinder.filterStatusCheckBox(label), ELEMENT_VISIBILITY_DELAY);
        WebElement typeField = driver.findElement(ElementFinder.filterStatusCheckBox(label));
        typeField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public List<String> getTypeLabels(String label) {
        this.waitVisibilityOfElement(ElementFinder.labelName(label), ELEMENT_VISIBILITY_DELAY);
        List<WebElement> typeElements = driver.findElements(ElementFinder.labelName(label));
        List<String> typeLabels = new ArrayList<>();
        for (WebElement typeLabel : typeElements) {
            String inputLabel = typeLabel.getText();
                typeLabels.add(inputLabel);
        }
        return typeLabels;
    }

    public List<String> getLeavesLength(String leavesLengthLabel) {
        this.waitVisibilityOfElement(ElementFinder.labelName(leavesLengthLabel), ELEMENT_VISIBILITY_DELAY);
        List<WebElement> leavesLengthElements = driver.findElements(ElementFinder.labelName(leavesLengthLabel));
        List<String> leavesLength = new ArrayList<>();
        for (WebElement leaveLength : leavesLengthElements) {
            String leaveLabel = leaveLength.getText();
            leavesLength.add(leaveLabel);
        }
        return leavesLength;
    }

    public void chooseDefaultType(String defaultType) {
            this.waitVisibilityOfElement(selectTypeField, ELEMENT_VISIBILITY_DELAY);
            WebElement typeField = driver.findElement(selectTypeField);
            typeField.click();
            this.waitMillis(SHORT_WAIT);
            this.selectType(defaultType).click();
        }

    public void clickOnTheLeaveRequestID() {
        this.waitVisibilityOfElement(firstLeaveRequestID, ELEMENT_VISIBILITY_DELAY);
        WebElement typeField = driver.findElement(firstLeaveRequestID);
        typeField.click();
        this.waitMillis(SHORT_WAIT);
    }
}
