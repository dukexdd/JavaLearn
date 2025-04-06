import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson4FeedbackAndMasterRequestTests {
    private static WebDriver driver;

    private final By nameLocator = By.cssSelector(".data.text");
    private final By emailLocator = By.cssSelector(".data.field");
    private final By reviewLocator = By.cssSelector(".field.text");
    private final By buttonFeedbackLocator = By.id("comment");
    private final By messageLocator = By.className("message-header");

    private final By fioLocator = By.cssSelector(".form-input.fio");
    private final By streetLocator = By.cssSelector(".data.form-input.street");
    private final By houseNumberLocator = By.cssSelector(".form-input.house");
    private final By flatNumberLocator = By.cssSelector(".form-input.flat");
    private final By dateLocator = By.cssSelector(".form-input.date");
    private final By buttonRequestLocator = By.cssSelector(".form-submit");

    private final By fioShowResultLocator = By.cssSelector(".show-fio");
    private final By streetShowResultLocator = By.cssSelector(".show-street");
    private final By houseShowResultLocator = By.cssSelector(".show-house");
    private final By flatShowResultLocator = By.cssSelector(".show-flat");
    private final By dateShowResultLocator = By.cssSelector(".show-date");


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
    public void testFeedback() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson3/os.html");

        driver.findElement(nameLocator).sendKeys("Вася");
        driver.findElement(emailLocator).sendKeys("test@test.ru");
        driver.findElement(reviewLocator).sendKeys("Мой отзыв - отзыв");
        driver.findElement(buttonFeedbackLocator).click();

        Assertions.assertTrue(driver.findElement(messageLocator).isDisplayed(),
                "Не отобразился текст про спасибо");
    }

    @Test
    public void testMasterRequest() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson3/index.html");

        var correctFio = "Василий Васильевич Васильев";
        var correctStreet = "Васильевская";
        var correctHouse = "15";
        var correctFlat = "3";
        var correctDate = "В последний четверг за предпоследним";

        driver.findElement(fioLocator).sendKeys(correctFio);
        driver.findElement(streetLocator).sendKeys(correctStreet);
        driver.findElement(houseNumberLocator).sendKeys(correctHouse);
        driver.findElement(flatNumberLocator).sendKeys(correctFlat);
        driver.findElement(dateLocator).sendKeys(correctDate);
        driver.findElement(buttonRequestLocator).click();

        Assertions.assertEquals("\"" + correctFio + "\"", driver.findElement(fioShowResultLocator).getText(),
                "Ошибка отображения ФИО");
        Assertions.assertEquals("\"" + correctStreet + "\"", driver.findElement(streetShowResultLocator).getText(),
                "Ошибка отображения Улицы");
        Assertions.assertEquals("\"" + correctHouse + "\"", driver.findElement(houseShowResultLocator).getText(),
                "Ошибка отображения Дома");
        Assertions.assertEquals("\"" + correctFlat + "\"", driver.findElement(flatShowResultLocator).getText(),
                "Ошибка отображения Квартиры");
        Assertions.assertEquals("\"" + correctDate + "\"", driver.findElement(dateShowResultLocator).getText(),
                "Ошибка отображения Даты прихода мастера");
    }

}
