package zipHub;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings{
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/oleksiiyevdokymov/SeleniumTests/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        System.out.println("Setting Up");
    }
    @AfterTest
    public void close() {
        System.out.println("All good");
        driver.quit();
    }

}