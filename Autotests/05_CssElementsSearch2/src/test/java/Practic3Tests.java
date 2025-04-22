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

        /* Первый тег h1, находящийся сразу на первом уровне вложенности внутри
        <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.
         */
        var h1FirstTag = driver.findElement(By.cssSelector("section.important-section-block > h1:first-child"));

        /* Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">.
        Используйте поиск по child.
         */
        var pLastTag = driver.findElement(By.cssSelector("form#login-form.form > p:last-child"));

        // Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
        var bodyThirdElement = driver.findElement(By.cssSelector("body > *:nth-child(3)"));

        /* Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">.
        Используйте поиск по type.
         */
        var footerFirstAByType = driver.findElements(By.cssSelector("div.footer__menuList > a:nth-of-type(1)"));

        /* По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего
        родителя <div class="footer__menuList">, при этом <div class="footer__menuList"> является первым дочерним
        элементом у своего родителя <div class="footer__menu">. Составленный поиск должен вернуть ровно один найденный элемент.
         */
        var firstAOfFirstFooterMenuList = driver.findElements(By.cssSelector(
                "div.footer__menu > div.footer__menuList:first-child > a:nth-of-type(1)"));
        Assertions.assertEquals(1, firstAOfFirstFooterMenuList.size(),
                "Ошибка, найдено более 1 элемента!");
    }


}
