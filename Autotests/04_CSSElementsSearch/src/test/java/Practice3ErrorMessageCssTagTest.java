import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3ErrorMessageCssTagTest {
    private static WebDriver driver;

    private final By emailLocator = By.cssSelector("input.input-data");
    private final By passwordLocator = By.cssSelector("input.password");
    private final By buttonLocator = By.cssSelector("button.form-submit");
    private final By errorMessageLocator =  By.cssSelector("pre.form-error-password-email");


    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationErrorMessage() {
    driver.navigate().to("https://qajava.skillbox.ru/module04/homework/auth/changed.html");
    driver.findElement(emailLocator).sendKeys("@");
    driver.findElement(passwordLocator).sendKeys("123");
    driver.findElement(buttonLocator).click();
    Assertions.assertTrue(driver.findElement(errorMessageLocator).isDisplayed(),
            "Сообщение об ошибке не отображается!");
    Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessageLocator).getText(),
            "Неверный текст об ошибке");
    }

}
