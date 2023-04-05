import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {
    private WebDriver driver;

    @BeforeEach

    void setUpAll() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOption = new ChromeOptions();
        chromeOption.addArguments("--headless");
        driver = new ChromeDriver(chromeOption);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestCSS() {
        WebDriverManager.chromedriver().setup();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Иван Иванов-Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79999999999");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("paragraph")).getText().trim();
        assertEquals(expected, actual);

    }

    @Test
    void shouldTestSelenium() {
        WebDriverManager.chromedriver().setup();
        driver.get("http://localhost:7777");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("Иван Иванов-Иванов");
        inputs.get(1).sendKeys("+79999999999");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("paragraph")).getText().trim();
        assertEquals(expected, actual);

    }

/*    @Test
    void shouldNegativeTestNameEnglish() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("[data-test-id=name] .input_invalid .input__sub")).sendKeys("Ivan3613354@!54");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79999999999");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals(expected, actual);

    }


    @Test
    void shouldNegativeTestEmptyName() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+79999999999");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.className("input__sub")).getText().trim();
        assertEquals(expected, actual);

    }

    @Test
    void shouldNegativeTestPhone10() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Иван Иванов-Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("+7999999999");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=phone] span.input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());

    }

    @Test
    void shouldNegativeTestPhoneEmpty() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Иван Иванов-Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id=phone] span.input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());

    }*/

/*    @Test
    void shouldNegativeTestClick() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String title = driver.getTitle();
        driver.get("http://localhost:7777");
        driver.findElement(By.cssSelector("span[data-test-id=name] input")).sendKeys("Иван Иванов-Иванов");
        driver.findElement(By.cssSelector("span[data-test-id=phone] input")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.tagName("button")).click();

        String expected = driver.findElement(By.className("checkbox_checked")).click();
        String actual = driver.findElement(By.className("input_invalid")).getText();

        *//* String text = driver.findElement(By.cssSelector("[data-test-id=agreement] span.input_invalid")).getText();*//*
        assertEquals(expected, actual);
    }*/


}
