import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson3LocatorTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void testLocators () {
    driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
    var emailElement = driver.findElement(By.className("form-input"));
    var passwordElement = driver.findElement(By.id("password"));
    var passwordConfirmElement = driver.findElement(By.name("confirm_password"));

    }
}
