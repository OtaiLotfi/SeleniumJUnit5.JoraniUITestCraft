package otai.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static final int ELEMENT_VISIBILITY_DELAY = 60;
    public static final int SHORT_WAIT = 2000;
    public static final int TIMEOUT = 3000;

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibilityOfElement(By locator, long timeoutInSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitMillis(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void scrollThePage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, 1000)");
            Thread.sleep(100);
        }

        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0, -1000)");
            Thread.sleep(100);
        }
    }

    public void clickOnAWhiteSpace() {
        this.waitMillis(SHORT_WAIT);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE).perform();
    }

    public void leftClickOutsidePopup() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.elementFromPoint(100, 100).click();");
        this.waitMillis(100);
    }
}
