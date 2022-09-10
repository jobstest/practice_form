package com.gmail.jobstest18.owner;

import com.gmail.jobstest18.config.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    private WebDriver driver = new WebDriverProvider().get();

    @Test
    @Tag("owner")
    void testGitHubTitle1() {
        // код выполнения теста
        String title = driver.getTitle();
        assertEquals(title, "GitHub: Where the world builds software · GitHub");
    }

    @Test
    void testGitHubTitle2() {
        // настройка Chrome Driver, если у вас все хорошо сконфигурировано, то она не нужна
        WebDriverManager.chromedriver().setup();

        // конфигурация запуска: browser = chrome, base url = https://github.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://github.com");

        // код выполнения теста
        String title = driver.getTitle();
        assertEquals(title, "GitHub: Where the world builds software · GitHub");
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
