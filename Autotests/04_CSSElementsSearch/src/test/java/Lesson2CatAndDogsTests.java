import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2CatAndDogsTests {

    private static WebDriver driver;

    private final By emailLocatorCat = By.className("email");
    private final By writeToMeLocator = By.id("write-to-me");
    private final By resultEmailLocatorCat = By.className("result-email");

    private final By resultEmailLocatorDoge = By.className("your-email");
    private final By dogGenderGirlChoice = By.id("girl");
    private final By dogGenderBoyChoice = By.id("boy");
    private final By emailLocatorDoge = By.name("email");
    private final By nameGenerationButton = By.id("sendMe");
    private final By resultTextDogeNameGen = By.className("result-text");


    private String email;

    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        email = "test@test.ru";
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void kittenTestCorrectEmail () {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(emailLocatorCat).sendKeys(email);
        driver.findElement(writeToMeLocator).click();
        Assertions.assertTrue(driver.findElement(resultEmailLocatorCat).isDisplayed(),
                "Не отображается текст сообщения про email");
        Assertions.assertEquals(email,driver.findElement(resultEmailLocatorCat).getText(),
                "Неверный текст сообщения про email");
    }

    @Test
    public void kittenTestEmptyEmail () {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(writeToMeLocator).click();
        Assertions.assertEquals("",driver.findElement(resultEmailLocatorCat).getText(),
                "Неверный текст сообщения про email");
    }

    @Test
    public void dogsTestFemaleNameGen() {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/practice/");

        driver.findElement(dogGenderGirlChoice).click();
        driver.findElement(emailLocatorDoge).sendKeys(email);
        driver.findElement(nameGenerationButton).click();

        Assertions.assertTrue(driver.findElement(resultEmailLocatorDoge).isDisplayed(),
                "Не отображается сообщение про email");
        Assertions.assertEquals(email, driver.findElement(resultEmailLocatorDoge).getText(),
                "Не верный текст в сообщении про email");

    }

    @Test
    public void dogsTestMaleNameGenCorrectMessage () {
        driver.navigate().to("https://qajava.skillbox.ru/module04/lesson2/practice/");

        driver.findElement(dogGenderGirlChoice).click();
        driver.findElement(dogGenderBoyChoice).click();
        driver.findElement(emailLocatorDoge).sendKeys(email);
        driver.findElement(nameGenerationButton).click();

        Assertions.assertEquals("Хорошо, мы пришлём имя для вашего мальчика на e-mail:",
                driver.findElement(resultTextDogeNameGen).getText(), "Не верный текст сообщения о регистрации");

    }




}
