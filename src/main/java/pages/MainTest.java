//package pages;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class MainTest {
//
//    private static WebDriver driver;
//    private static HotelBookingPage homePage;
//
//    public static void main(String[] args) {
//
//        setupTest();
//        testHotelBooking();
//        teardown();
//    }
//
//    private static void testHotelBooking() {
//        homePage = new HotelBookingPage(driver);
//        homePage.navigateToHomePage();
//        homePage.setFirstName("Dummy");
//        homePage.setLastName("Tester");
//        homePage.setPrice("50");
//        homePage.setDepositStatus("true");
//        homePage.setCheckInDate("20");
//        homePage.setCheckOutDate("23");
//        homePage.saveBooking();
//        homePage.doesDummyFirstNameExists();
//        homePage.deleteBooking();
//        homePage.dummyFirstNameDoesNotExist();
//    }
//
//    private static void setupTest() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
//    private static void teardown() {
//        if (driver != null) {
//            driver.close();
//            driver.quit();
//        }
//    }
//}
//
//
//
//
