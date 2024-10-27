package Tests;

import otai.configurations.DriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import otai.pages.LeaveRequestsPage;

import static org.junit.jupiter.api.Assertions.*;
import static otai.configurations.Routes.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LeaveRequestsTest {

    private static WebDriver driver;
    private static LeaveRequestsPage leaveRequestsPage;

    @BeforeAll
    public static void setUp() {
        DriverManager.setUpDriver();
        driver = DriverManager.getDriver();
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

    @ParameterizedTest
    @Order(3)
    @ValueSource(strings = {"Accepted", "Planned", "Requested", "Rejected", "Cancellation", "Canceled"})
    public void searchFiltersStatus(String status) {
        leaveRequestsPage.searchFiltersStatus(status);
    }

    @Test
    @Order(4)
    public void chooseTheType() {
        leaveRequestsPage.searchFiltersStatus("");
        leaveRequestsPage.chooseType("Type");
        leaveRequestsPage.chooseDefaultType("");
        leaveRequestsPage.chooseLeavesLength("Show");
    }

    @Test
    @Order(5)
    public void chooseTheLeavesLength() {
        leaveRequestsPage.searchFiltersStatus("");
        leaveRequestsPage.chooseDefaultType("");
        leaveRequestsPage.chooseDefaultLeavesLength("100");
    }

    @Test
    @Order(6)
    public void scrollThePage() throws InterruptedException {
        leaveRequestsPage.scrollThePage();
    }

    @ParameterizedTest
    @Order(6)
    @ValueSource(strings = {"Cancellation", "Canceled", "Rejected"})
    public void checkFilterStatus(String statusValue) {
        leaveRequestsPage.checkFilterStatusCheckbox(statusValue);
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.tearDown();
    }
}