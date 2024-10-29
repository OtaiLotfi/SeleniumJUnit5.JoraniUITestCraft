package Tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Configuration;
import otai.configurations.DriverManager;
import otai.pages.CreateNewRequestPage;
import otai.pages.HRListOfEmployeesPage;
import otai.pages.HRReportsPage;
import otai.pages.LeaveRequestsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static otai.configurations.Routes.*;
import static otai.configurations.Routes.LEAVES_URL;

@Configuration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HRListOfEmployeesTest {
    private static WebDriver driver;
    private static HRListOfEmployeesPage hrListOfEmployeesPage;
    private static LeaveRequestsPage leaveRequestsPage;
    private static HRReportsPage hrReportsPage;
    private static CreateNewRequestPage createNewRequestPage;

    @BeforeAll
    public static void setUp() {
        DriverManager.setUpDriver();
        driver = DriverManager.getDriver();
        hrListOfEmployeesPage = new HRListOfEmployeesPage(driver);
        leaveRequestsPage = new LeaveRequestsPage(driver);
        hrReportsPage = new HRReportsPage(driver);
        createNewRequestPage = new CreateNewRequestPage(driver);
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
        hrReportsPage.clickTheItemFromHeader("List of employees");
    }

    @ParameterizedTest
    @Order(4)
    @ValueSource(strings = {"10 rows", "25 rows", "50 rows", "Show all"})
    public void clickShowAllRows(String buttonLabel) throws InterruptedException {
        hrListOfEmployeesPage.clickOnButtonPageLength("buttons-page-length");
        hrListOfEmployeesPage.clickOnButtonsCollection(buttonLabel);
        hrListOfEmployeesPage.scrollThePage();
    }

    @ParameterizedTest
    @Order(5)
    @ValueSource(strings = {"Firstname", "Lastname", "E-mail", "Entity", "Contract", "Manager", "Identifier", "Date hired", "Position", "Show all"})
    public void clickChangeColumns(String buttonLabel) {
        hrListOfEmployeesPage.clickOnButtonPageLength("buttons-colvis");
        hrListOfEmployeesPage.clickOnButtonsCollection(buttonLabel);
        hrListOfEmployeesPage.leftClickOutsidePopup();
    }

    @Test
    @Order(8)
    public void enterTheFirstHiringDate() {
        hrListOfEmployeesPage.clickOnTheDateHired("viz_datehired1");
        createNewRequestPage.entreMonthOrYear("selectMonth","Oct");
        createNewRequestPage.entreDataMonth("8");
    }

    @Test
    @Order(9)
    public void enterTheSecondHiringDate() {
        hrListOfEmployeesPage.clickOnTheDateHired("viz_datehired2");
        createNewRequestPage.entreMonthOrYear("selectMonth","Oct");
        createNewRequestPage.entreDataMonth("18");
    }


}
