import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicle2ElementPresenceTest {
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
    public void findAllElements () {
        driver.navigate().to("https://qajava.skillbox.ru/");

        var feedback = driver.findElement(By.linkText("Обратная связь"));
        String feedbackHref = feedback.getAttribute("href");

        var preorders = driver.findElement(By.linkText("Предзаказы"));
        String preordersHref = preorders.getAttribute("href");

        var about = driver.findElement(By.linkText("О магазине"));
        String aboutHref = about.getAttribute("href");

        var bookCard = driver.findElements(By.className("book-info"));
        var addToCardButton = bookCard.get(0).findElement(By.className("book-add"));

        var cartCount = driver.findElement(By.id("cart_count")).getText();

        var bookMenu = driver.findElement(By.id("genres")).getText();

        var searchInputForm = driver.findElement(By.name("search-input-form"));

    }

}
