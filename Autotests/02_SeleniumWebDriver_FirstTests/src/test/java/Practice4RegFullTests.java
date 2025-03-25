import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice4RegFullTests {

    @Test
    public void testPositive () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иван Иванович Иванов.\n" +
                "На вашу почту (ivanov@gmail.com) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +71234567890.";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }

    @Test
    public void testNoName () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: ФИО";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }

    @Test
    public void testNoEmail () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: E-mail";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }

    @Test
    public void testNoPhone () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Необходимо заполнить поле: Телефон";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }

    @Test
    public void testWrongEmail () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ПЕЛЬМЕНЬ!@#$%^&");
        driver.findElement(By.name("phone")).sendKeys("+71234567890");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Неверно заполнено поле: E-mail";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }

    @Test
    public void testWrongPhone () {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иван Иванович Иванов");
        driver.findElement(By.name("email")).sendKeys("ivanov@gmail.com");
        driver.findElement(By.name("phone")).sendKeys("КНОПОЧНЫЙ");
        driver.findElement(By.className("custom-form__button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Неверно заполнено поле: Телефон";
        Assertions.assertEquals(expectedResult,actualResult);
        driver.quit();
    }





}
