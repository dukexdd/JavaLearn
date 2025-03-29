import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice3BookInfoCountTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://qajava.skillbox.ru/");
    }

    @AfterEach
    public void tearDown () {
        driver.quit();
    }

    @Test
    public void testBookInfoCount () {

        var elementsCount = driver.findElements(By.className("book-info"));
        int expectedElementsCount = 15;
        Assertions.assertEquals(expectedElementsCount, elementsCount.size(),
                "Число элементов book-info не соответствует ожидаемому");

    }
}
