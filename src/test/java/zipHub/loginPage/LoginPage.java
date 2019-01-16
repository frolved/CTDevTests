package zipHub.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input[type=\"email\"]")
    private WebElement email;

    @FindBy(css = "input[type='password']")
    private WebElement password;

    @FindBy(xpath = "//button[text() = \"Login\"]")
    private WebElement loginButton;


    public void open() {
        driver.get("https://stage.zhub.tk/#/login");
        driver.manage().window().maximize();
    }

    public void login(String email, String password) {
        this.email.clear();
        this.email.sendKeys(email);
        this.password.clear();
        this.password.sendKeys(password);
        this.loginButton.click();
    }

}
