package otai.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import otai.configurations.ElementFinder;

@Component

public class HRListOfEmployeesPage extends BasePage {
    public HRListOfEmployeesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonPageLength(String buttonClassName) {
        By buttonXpath = ElementFinder.buttonsPageLengthAndColvis(buttonClassName);
        this.waitVisibilityOfElement(buttonXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement buttonField = driver.findElement(buttonXpath);
        buttonField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void clickOnButtonsCollection(String rowsOrColumnsLabel) {
        By rowsOrColumnsXpath = ElementFinder.rowsAndColumns(rowsOrColumnsLabel);
        this.waitVisibilityOfElement(rowsOrColumnsXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement rowsOrColumnsField = driver.findElement(rowsOrColumnsXpath);
        rowsOrColumnsField.click();
        this.waitMillis(SHORT_WAIT);
    }

    public void clickOnTheDateHired(String inputId) {
        By dateHiredXpath = ElementFinder.dateHired(inputId);
        this.waitVisibilityOfElement(dateHiredXpath, ELEMENT_VISIBILITY_DELAY);
        WebElement dateHiredInput = driver.findElement(dateHiredXpath);
        this.waitMillis(SHORT_WAIT);
        dateHiredInput.click();
    }
}
