import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2Tests {
    private static WebDriver driver;

    private final By emailLocator = By.cssSelector("[data='email']");
    private final By passwordLocator = By.cssSelector("[data='password one']");
    private final By buttonLocator = By.cssSelector("#submit.form-submit");
    private final By errorMessageLocator =  By.cssSelector(".form-error-password-email");


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationErrorMessage() {
        driver.navigate().to("https://qajava.skillbox.ru/module05/auth/index.html/");
        driver.findElement(emailLocator).sendKeys("@");
        driver.findElement(passwordLocator).sendKeys("123");
        driver.findElement(buttonLocator).click();
        Assertions.assertTrue(driver.findElement(errorMessageLocator).isDisplayed(),
                "Сообщение об ошибке не отображается!");
        Assertions.assertEquals("Некорректный email или пароль", driver.findElement(errorMessageLocator).getText(),
                "Неверный текст об ошибке");
    }
}
