import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practic1Tests {
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
        var aboutUs = driver.findElement(By.cssSelector("[test-info='about-us']"));
        var emptyHrefs = driver.findElements(By.cssSelector("a[href='']"));
        var bookPrice = driver.findElement(By.cssSelector("div.book-price"));
        var buttonBook = driver.findElements(By.cssSelector("button[class^='book']"));
        var classMain = driver.findElements(By.cssSelector("[class$=main]"));
        var classMenu = driver.findElements(By.cssSelector("a[class*=menu]"));
    }

    @Test
    public void searchPageTests() {
        driver.navigate().to("https://qajava.skillbox.ru/search.html");
        var selectedOption = driver.findElement(By.cssSelector("option[selected]"));
    }



}
