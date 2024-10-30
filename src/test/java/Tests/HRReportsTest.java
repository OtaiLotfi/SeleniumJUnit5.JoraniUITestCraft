package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Configuration;
import otai.configurations.DriverManager;
import otai.pages.HRReportsPage;
import otai.pages.LeaveRequestsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static otai.configurations.Routes.*;
import static otai.configurations.Routes.LEAVES_URL;

@Configuration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HRReportsTest {
    private static WebDriver driver;
    private static HRReportsPage hrReportsPage;
    private static LeaveRequestsPage leaveRequestsPage;

    @BeforeAll
    public static void setUp() {
        DriverManager.setUpDriver();
        driver = DriverManager.getDriver();
        hrReportsPage = new HRReportsPage(driver);
        leaveRequestsPage = new LeaveRequestsPage(driver);
    }

    @Test
    @Order(1)
    public void loginIntoApp() {
        driver.get(LOGIN_URL);
        leaveRequestsPage.waitMillis(LOGIN_TIMEOUT);
        leaveRequestsPage.clickLoginButton();
        boolean displayedUrl = HOME_URL.equals(driver.getCurrentUrl());
        assertTrue(displayedUrl);
    }

    @Test
    @Order(2)
    public void loginIntoFormatListBulleted() {
        leaveRequestsPage.clickTheFormatListBulleted();
        boolean displayedUrl = LEAVES_URL.equals(driver.getCurrentUrl());
        assertTrue(displayedUrl);
    }

    @Test
    @Order(3)
    public void clickItemFromHeader() {
        hrReportsPage.clickTheItemFromHeader("HR ");
        hrReportsPage.clickTheItemFromHeader("Reports");
    }

    @Test
    @Order(4)
    public void chooseTheReportLink() {
        hrReportsPage.clickTheReportLink("Leave type distribution");
    }

    @Test
    @Order(5)
    public void chooseTheYear() throws InterruptedException {
        hrReportsPage.selectTheYear("2023");
        hrReportsPage.clickTheExecuteButton();
        hrReportsPage.scrollThePage();
        hrReportsPage.selectTheYear("2024");
        hrReportsPage.clickTheExecuteButton();
        hrReportsPage.scrollThePage();
    }
}