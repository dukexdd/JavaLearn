import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicle5CinemaSiteAdvancedTests {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
    }

    @AfterEach
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testPositiveResponse() {
        var favoriteFilm = "Зеленая миля";
        var favoriteSerials = "Во все тяжкие";
        driver.findElement(By.name("films")).sendKeys(favoriteFilm);
        driver.findElement(By.name("serials")).sendKeys(favoriteSerials);
        var buttonSave = driver.findElement(By.id("save"));
        buttonSave.click();
        driver.findElement(By.id("two")).click();
        buttonSave.click();
        driver.findElement(By.id("ok")).click();
        var bestFilms = driver.findElement(By.id("best_films")).getText();
        var bestSerials = driver.findElement(By.id("best_serials")).getText();
        Assertions.assertEquals(favoriteFilm, bestFilms,
                "Неверно отображается любимый фильм");
        Assertions.assertEquals(favoriteSerials, bestSerials,
                "Неверно отображается любимый сериал");
    }


    @Test
    public void testClearButtonInputFields() {
        var favoriteFilm = "Зеленая миля";
        var favoriteSerials = "Во все тяжкие";
        var filmsInputField = driver.findElement(By.name("films"));
        filmsInputField.sendKeys(favoriteFilm);
        var serialsInputField = driver.findElement(By.name("serials"));
        serialsInputField.sendKeys(favoriteSerials);
        var deleteButtons = driver.findElements(By.className("delete"));
        deleteButtons.get(0).click();
        deleteButtons.get(1).click();
        Assertions.assertTrue(filmsInputField.getAttribute("value").isEmpty(),
                "Поле ввода названия фильма не очищено!");
        Assertions.assertTrue(serialsInputField.getAttribute("value").isEmpty(),
                "Поле ввода названия сериала не очищено!");
    }

    @Test
    public void testAllCheckbox() {
        driver.findElement(By.id("two")).click();
        var allCheckBoxes = driver.findElements(By.className("fake-checkbox"));
        for (int i = 0; i <= 3; i++) {
            allCheckBoxes.get(i).click();
        }
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var languageText = driver.findElement(By.id("language")).getText();
        var expectedText = "С русскими субтитрами, С английскими субтитрами, В оригинале, В дубляже";
        Assertions.assertEquals(expectedText, languageText, "Ошибка в работе чек-боксов");
    }

    @Test
    public void testSavingInformationOnFirstPage() {
        var favoriteFilm = "Зеленая миля";
        var favoriteSerials = "Во все тяжкие";
        var inputFieldFilms = driver.findElement(By.name("films"));
        inputFieldFilms.sendKeys(favoriteFilm);
        var inputFieldsSerials = driver.findElement(By.name("serials"));
        inputFieldsSerials.sendKeys(favoriteSerials);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("one")).click();
        var textInputFieldFilms = inputFieldFilms.getAttribute("value");
        var textInputFieldsSerials = inputFieldsSerials.getAttribute("value");
        Assertions.assertEquals(favoriteFilm, textInputFieldFilms,
                "Значение в поле не сохранилось или изменилось");
        Assertions.assertEquals(favoriteSerials, textInputFieldsSerials,
                "Значение в поле не сохранилось или изменилось");
    }

}
