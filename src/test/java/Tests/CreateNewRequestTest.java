package Tests;

import org.springframework.context.annotation.Configuration;

import otai.configurations.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import otai.pages.CreateNewRequestPage;
import otai.pages.LeaveRequestsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static otai.configurations.Routes.*;

@Configuration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreateNewRequestTest {
    private static WebDriver driver;
    private static CreateNewRequestPage createNewRequestPage;
    private static LeaveRequestsPage leaveRequestsPage;

    @BeforeAll
    public static void setUp() {
        DriverManager.setUpDriver();
        driver = DriverManager.getDriver();
        createNewRequestPage = new CreateNewRequestPage(driver);
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
    public void searchForStartDate() {
        leaveRequestsPage.searchFiltersStatus("10/30/2024");
    }

    @Test
    @Order(4)
    public void loginOnTheLeaveRequestID() {
        leaveRequestsPage.clickOnTheLeaveRequestID();
    }

    @Test
    @Order(5)
    public void cancelTheLeaveRequestID() {
        createNewRequestPage.clickOnStatusOperation("Edit");
        createNewRequestPage.clickOnStatusOperation("Cancel");
    }

    @Test
    @Order(6)
    public void createNewRequest() {
        this.searchForStartDate();
        createNewRequestPage.createNewRequest("New request");
    }

    @Test
    @Order(7)
    public void chooseLeaveType() {
        createNewRequestPage.chooseLeaveType("Telework");
    }

    @Test
    @Order(8)
    public void enterStartDateRequest() {
        createNewRequestPage.enterTheDate("startdate");
        createNewRequestPage.entreMonthOrYear("selectMonth", "Dec");
        createNewRequestPage.entreMonthOrYear("selectYear", "2024");
        createNewRequestPage.entreDataMonth("8");
    }

    @Test
    @Order(9)
    public void enterEndDateRequest() {
        createNewRequestPage.enterTheDate("enddate");
        createNewRequestPage.entreMonthOrYear("selectMonth", "Dec");
        createNewRequestPage.entreMonthOrYear("selectYear", "2024");
        createNewRequestPage.entreDataMonth("9");
        createNewRequestPage.clickOnStatusOperation("Cancel");
    }
}