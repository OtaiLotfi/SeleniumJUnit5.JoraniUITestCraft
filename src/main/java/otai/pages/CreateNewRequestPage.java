package otai.pages;

import otai.configurations.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component

public class CreateNewRequestPage extends BasePage {
    public CreateNewRequestPage(WebDriver driver){
        super(driver);
    }

    public void clickOnStatusOperation(String statusOperationLabel) {
        this.waitMillis(SHORT_WAIT);
        this.waitVisibilityOfElement(ElementFinder.statusOperationName(statusOperationLabel), ELEMENT_VISIBILITY_DELAY);
        WebElement statusOperationButton = driver.findElement(ElementFinder.statusOperationName(statusOperationLabel));
        statusOperationButton.click();
        this.waitMillis(SHORT_WAIT);
    }
}
