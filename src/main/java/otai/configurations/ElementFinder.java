package otai.configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementFinder {
    private WebDriver driver;

    public ElementFinder(WebDriver driver) {
        this.driver = driver;
    }

    public static By typeLabel(String typeLabel) {
        return By.xpath("//*/option[contains(text(),'" + typeLabel + "')]");
    }

    public static By filterStatusCheckBox(String filterStatusLabel) {
        return By.xpath("//span[contains(text(), '" + filterStatusLabel + "')]//input[@type='checkbox']");
    }

    public static By labelName(String label) {
        return By.xpath("//*/label[contains(text(),'" + label + "')]//option");
    }

    public static By statusOperationName(String statusOperationLabel) {
        return By.xpath("//*/a[contains(text(),'" + statusOperationLabel + "')]");
    }

    public static By requestOperationButton(String requestOperationLabel) {
        return By.xpath("//*/div/a[2][contains(text(),'" + requestOperationLabel + "')]");
    }

    public static By inputDate(String dateType) {
        return By.xpath("//input[@class='hasDatepicker'][contains(@id,'" + dateType + "')]");
    }

    public static By dataMonth(String dataMonthValue) {
        return By.xpath("//a[text()='" + dataMonthValue + "']");
    }

    public static By monthOrYearDataHandler(String dataHandler) {
        return By.xpath("//*/option[contains(text(),'" + dataHandler + "')]");
    }

    public static By monthOrYearLabel(String monthOrYearLabel) {
        return By.xpath("//select[@data-handler='" + monthOrYearLabel + "']");
    }

    public static By leaveType(String leaveType) {
        return By.xpath("//ul/li[contains(text(), '" + leaveType + "')]");
    }

    public static By itemLabel(String itemLabelValue) {
        return By.xpath("//a[contains(text(), '" + itemLabelValue + "')]/../a");
    }

    public static By rowsAndColumns(String rowsOrColumnsLabel) {
        return By.xpath("//a/span[text()='" + rowsOrColumnsLabel + "']");
    }

    public static By buttonsPageLengthAndColvis(String buttonClassName) {
        return By.xpath("//a[contains(@class, '" + buttonClassName + "')]");
    }

    public static By dateHired(String inputId) {
        return By.xpath("//input[@id='" + inputId + "']");
    }


}
