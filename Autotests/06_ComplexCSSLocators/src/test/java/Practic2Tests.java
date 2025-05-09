import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practic2Tests {
    private static WebDriver driver;

    // Найдите тег input, у которого нет атрибута id.
    private final By timeInput = By.cssSelector("input:not([id])");

    /* Найдите все теги p, у которых одновременно выполняются два условия:
    - class начинается на слово form;
    - class НЕ заканчивается на слово error.
    */
    private final By formsNotError = By.cssSelector("p[class^=form]:not([class$=error])");

    // Найдите <div class="form-inner">, у него найдите первый по счёту элемент такого типа: <p class="form-row">.
    private final By firstFormRow = By.cssSelector(".form-inner p.form-row:first-child");

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
    public void cssLocators() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module04/practice1/");
        driver.findElements(timeInput);
        driver.findElements(formsNotError);
        driver.findElements(firstFormRow);
    }


}
