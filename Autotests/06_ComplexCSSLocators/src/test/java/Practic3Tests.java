import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Practic3Tests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private final By firstNoteMainpage = By.cssSelector("div.pageStatistic__list div.pageStatistic__article:first-child");
    private final By firstNoteSidebar = By.cssSelector(".articlePreview.pageArticle__articlePreview:first-child");
    private final By secondNoteSidebar = By.cssSelector(".articlePreview.pageArticle__articlePreview:nth-child(2)");
    private final By openNoteTitle = By.cssSelector(".pageStatistic__article:first-child .articlePreview__title");
    private final By openNoteText = By.cssSelector(".pageStatistic__article:first-child .articlePreview__text");
    private final By sideNoteTitle = By.cssSelector(".page__sidebar .pageArticle__articlePreview:first-child .articlePreview__title");
    private final By sideNoteText = By.cssSelector(".page__sidebar .pageArticle__articlePreview:first-child .articlePreview__text");
    private final By binButton = By.cssSelector(".pageArticle__buttons > button:nth-child(2)");

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testNotes() {
        driver.navigate().to("https://qa.skillbox.ru/module15/bignotes/#/statistic");
        var openNoteTitleContent = driver.findElement(openNoteTitle).getText();
        var openNoteTextContent = driver.findElement(openNoteText).getText();
        driver.findElement(firstNoteMainpage).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNoteSidebar));
        var sideNoteTitleContent = driver.findElement(sideNoteTitle).getText();
        var sideNoteTextContent = driver.findElement(sideNoteText).getText();
        Assertions.assertEquals(openNoteTitleContent,sideNoteTitleContent, "Текст заголовков не совпадает!");
        Assertions.assertEquals(openNoteTextContent,sideNoteTextContent,"Текст записи не совпадает!");
        driver.findElement(binButton).click();
        driver.findElement(firstNoteSidebar).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(secondNoteSidebar));
        driver.findElement(binButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(firstNoteSidebar));
        var sideElementsSize = driver.findElements(By.cssSelector(".articlePreview.pageArticle__articlePreview")).size();
        Assertions.assertEquals(0,sideElementsSize, "Остались записи справа в списке «Все записи»!");
        
    }
}
