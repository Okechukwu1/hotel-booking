package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HotelBookingPage;

public class HotelBookingTest {

    private static WebDriver driver;
    private static HotelBookingPage homePage;

    @Before
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testHotelBookingForm() {
        homePage = new HotelBookingPage(driver);
        homePage.navigateToHomePage();
        homePage.setFirstName("Dummy");
        homePage.setLastName("Tester");
        homePage.setPrice("50");
        homePage.setDepositStatus("true");
        homePage.setCheckInDate("20");
        homePage.setCheckOutDate("23");
        homePage.saveBooking();
        homePage.doesDummyFirstNameExists();
        homePage.deleteBooking();
        homePage.dummyFirstNameDoesNotExist();
    }

    @Test
    public void testHotelBookingFormWithInvalidData() {
        homePage = new HotelBookingPage(driver);
        homePage.navigateToHomePage();
        homePage.setFirstName("21221646467979566615151vvgagggsggdgddgdgdgdgdgdgdgdgdggdhshsjskjdehhefhfjejjdjdy");
        homePage.setLastName("3231646796565764645475nnhchfheyejhhddhbdfdhdbdhjsh76433451574541662251545454");
        homePage.setPrice("505554646616451515142441515");
        homePage.setDepositStatus("true");
        homePage.setCheckInDate("20");
        homePage.setCheckOutDate("23");
        homePage.saveBooking();
        homePage.doesDummyFirstNameExists();
        homePage.deleteBooking();
        homePage.dummyFirstNameDoesNotExist();
    }

    @Test
    public void testWithWrongDataTypeForTheFreeTextFields() {
        homePage = new HotelBookingPage(driver);
        homePage.navigateToHomePage();
        homePage.setFirstName("124586");
        homePage.setLastName("298697");
        homePage.setPrice("wrong");
        homePage.setDepositStatus("true");
        homePage.setCheckInDate("20");
        homePage.setCheckOutDate("23");
        homePage.saveBooking();
        homePage.doesDummyFirstNameExists();
        homePage.deleteBooking();
        homePage.dummyFirstNameDoesNotExist();
    }

}