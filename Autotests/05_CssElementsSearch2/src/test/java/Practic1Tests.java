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
        /* Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
        Осуществите поиск только по атрибуту test-info, равному about-us.
        */
        var aboutUs = driver.findElement(By.cssSelector("[test-info='about-us']"));

        //Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
        var emptyHrefs = driver.findElements(By.cssSelector("a[href='']"));

        /* Локатор на главной странице для элемента <div class="book-price">.
        Осуществите поиск одновременно по тегу и классу, равному book-price.
        */
        var bookPrice = driver.findElement(By.cssSelector("div.book-price"));

        // Локатор на главной странице для всех элементов с тегом button и с атрибутом class, начинающимся на book.
        var buttonBook = driver.findElements(By.cssSelector("button[class^='book']"));

        // Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
        var classMain = driver.findElements(By.cssSelector("[class$=main]"));

        // Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
        var classMenu = driver.findElements(By.cssSelector("a[class*=menu]"));
    }

    @Test
    public void searchPageTests() {
        driver.navigate().to("https://qajava.skillbox.ru/search.html");

        /* Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected.
        Осуществите поиск только по атрибуту selected.
        */
        var selectedOption = driver.findElement(By.cssSelector("option[selected]"));
    }



}
