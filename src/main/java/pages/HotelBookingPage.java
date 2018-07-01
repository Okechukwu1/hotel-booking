package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.NoSuchElementException;

public class HotelBookingPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelBookingPage.class);

    private static final String FIRST_NAME_ID = "firstname";
    private static final String SUR_NAME_ID = "lastname";
    private static final String PRICE_ID = "totalprice";
    private static final String DEPOSIT_ID = "depositpaid";
    private static final String CHECK_IN_ID = "checkin";
    private static final String CHECK_OUT_ID = "checkout";
    private static final String CHECK_IN_DATE_SELECTOR = "#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(3) > a";
    private static final String CHECK_OUT_DATE_SELECTOR = "#ui-datepicker-div > table > tbody > tr:nth-child(4) > td:nth-child(4) > a";
    private static final String SAVE_SELECTOR = "#form > div > div:nth-child(7) > input[type=\"button\"]";

    public HotelBookingPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(final String firstname) {
        WebElement firstNameElement = driver.findElement(By.id(FIRST_NAME_ID));
        firstNameElement.sendKeys(firstname);
        LOGGER.info(String.format("I am serching for %s", firstname));
    }

    public void setLastName(final String lasttname) {
        WebElement lastNameElement = driver.findElement(By.id(SUR_NAME_ID));
        lastNameElement.sendKeys(lasttname);
        LOGGER.info(String.format("I am serching for %s", lasttname));
    }

    public void setPrice(final String price) {
        WebElement priceElement = driver.findElement(By.id(PRICE_ID));
        priceElement.sendKeys(price);
        LOGGER.info(String.format("I am serching for %s", price));
    }

    public void setDepositStatus(final String status) {
        WebElement depositElement = driver.findElement(By.id(DEPOSIT_ID));
        Select select = new Select(depositElement);

        if (status == "true") {
            select.selectByVisibleText("true");
        } else {
            select.selectByVisibleText("false");
        }
    }

    public void setCheckInDate(final String inDate) {
        WebElement checkInElement = driver.findElement(By.id(CHECK_IN_ID));
        checkInElement.click();
        driver.findElement(By.cssSelector(CHECK_IN_DATE_SELECTOR)).click();
    }

    public void setCheckOutDate(final String outDate) {
        WebElement checkOutElement = driver.findElement(By.id(CHECK_OUT_ID));
        checkOutElement.click();
        driver.findElement(By.cssSelector(CHECK_OUT_DATE_SELECTOR)).click();
    }

    public void saveBooking() {
        WebElement saveButton = driver.findElement(By.cssSelector(SAVE_SELECTOR));
        saveButton.click();
    }

    public boolean doesDummyFirstNameExists() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait/*.ignoring(NoSuchElementException.class)*/.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div:nth-child(1) > p")));
        return true;
    }

    public boolean dummyFirstNameDoesNotExist() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.cssSelector("div:nth-child(1) > p")));
        return true;
    }

    public void deleteBooking() {
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector("input[value='Delete']"));
        deleteButtons
                .stream()
                .filter(e -> e.getAttribute("value").equalsIgnoreCase("Delete"))
                .forEach(WebElement::click);
        }
    }

