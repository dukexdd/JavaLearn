import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2UpgradedTests {
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
    public void testPositive () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иван Иванович Иванов.\n" +
                "На вашу почту (ivanov@gmail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +71234567890.";
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testNoName () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: ФИО";
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testNoEmail () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: E-mail";
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testNoPhone () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: Телефон";
        Assertions.assertEquals(expectedResult,actualResult);
    }

    }