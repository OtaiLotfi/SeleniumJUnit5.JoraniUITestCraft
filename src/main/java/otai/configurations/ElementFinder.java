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


}
