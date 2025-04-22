import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practic2Tests {
    private static WebDriver driver;

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
    public void mainPageTests() {
        driver.navigate().to("https://qajava.skillbox.ru/index.html");

        /* На главной странице найдите все теги div, которые являются дочерними
        элементами первого уровня у элемента <footer id="footer">.
         */
        var footerDiv = driver.findElements(By.cssSelector("footer > div"));

        // На главной странице найдите любой тег, который расположен сразу после <li id="genres">
        var afterGenresTag = driver.findElements(By.cssSelector("#genres + *"));

    }

    @Test
    public void searchPageTests() {
        driver.navigate().to("https://qajava.skillbox.ru/search.html");

        /* На странице поиска найдите любые теги, которые расположены после <div class="filter-container">
         (необязательно ближайший сосед).
         */
        var filterContainer = driver.findElements(By.cssSelector("div.filter-container ~ *"));
    }


}
