import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practic3Tests {
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
    public void funnySocksSiteTests () {
        driver.navigate().to("https://qajava.skillbox.ru/module05/auth/index.html/");
        var h1FirstTag = driver.findElement(By.cssSelector("section.important-section-block > h1:first-child"));
        var pLastTag = driver.findElement(By.cssSelector("form#login-form.form > p:last-child"));
        var bodyThirdElement = driver.findElement(By.cssSelector("body > *:nth-child(3)"));
        var footerFirstAByType = driver.findElements(By.cssSelector("div.footer__menuList > a:nth-of-type(1)"));

        var firstAOfFirstFooterMenuList = driver.findElements(By.cssSelector(
                "div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)"));
        Assertions.assertEquals(1, firstAOfFirstFooterMenuList.size(),
                "Ошибка, найдено более 1 элемента!");
    }


}
