package zipHub;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import zipHub.loginPage.LoginPage;

import java.io.*;
import java.util.Properties;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
       // LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();


        Properties prop = new Properties();
            InputStream stream = new FileInputStream("/Users/oleksiiyevdokymov/SeleniumTests/src/test/java/properties/config.properties");
            prop.load(stream);


        loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/div/div[4]/button")));
        WebElement dailyDeal = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/ul/li[1]/div/div/a"));
        dailyDeal.click();
        WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/ul/li[1]/div/div/div/a[1]"));
        dropDown.click();

    }

    @DataProvider(name = "Creds")
    public Object[][] getData() {
        Object[][] data = new Object[1][2];
        data[0][0] = "demo1@demo.com";
        data[0][1] = "test";

        return data;
    }

}
