import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice1BootSizeTests {
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
    public void testBootsSearchValueAboveRange () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("45");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assertions.assertEquals(expectedResult,actualResult,"Неверное сообщение!");
    }

    @Test
    public void testBootsSearchValueBelowRange () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("33");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assertions.assertEquals(expectedResult,actualResult,"Неверное сообщение!");
    }

    @Test
    public void testBootsSearchInvalidCharacterInput () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("!#$%^&*");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "Введите размер обуви!";
        Assertions.assertEquals(expectedResult, actualResult, "Неверное сообщение!");
    }


    @Test
    public void positiveBootsSearch () {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("40");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assertions.assertEquals(expectedResult,actualResult,"Неверное сообщение!");
    }
}

