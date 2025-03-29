import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2NewRegistrationTests {
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
    public void registrationPositiveTest () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module06/register/");
        var testEmail = "skillbox@test.ru";
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.name("email")).sendKeys(testEmail);
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту " + testEmail + " отправлено письмо";
        Assertions.assertEquals(expectedResult,actualResult, "Сообщение о регистрации не соответствует ожидаемому!");
    }

    @Test
    public void registrationEmptyFields () {
        driver.navigate().to ("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var formErrorMessage = driver.findElements(By.className("form-error"));
        var nameError = formErrorMessage.get(0).getText();
        var emailError = formErrorMessage.get(1).getText();
        var passwordError = formErrorMessage.get(2).getText();
        var underButtonError = formErrorMessage.get(3).getText();
        Assertions.assertEquals("Введите имя",nameError,
                "Неверное сообщение об ошибке у поля `Имя`!)");
        Assertions.assertEquals("Введите email",emailError,
                "Неверное сообщение об ошибке у поля `E-mail`!)");
        Assertions.assertEquals("Введите пароль",passwordError,
                "Неверное сообщение об ошибке у поля `Пароль`!)");
        Assertions.assertEquals("Некорректный email или пароль",underButtonError,
                "Неверное сообщение об ошибке под кнопкой `Зарегистрироваться`");
    }


    }