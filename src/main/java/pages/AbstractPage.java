package pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage( WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public HotelBookingPage navigateToHomePage(){
        driver.navigate().to("http://hotel-test.equalexperts.io/");
        return new HotelBookingPage(driver);
    }

    void stopBrowser(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }


}
