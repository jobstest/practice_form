package com.gmail.jobstest18.form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gmail.jobstest18.config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String login = config.loginJenkins();
        String password = config.passwordJenkins();

        String browser = System.getProperty("browser", "chrome");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String remoteDriver = System.getProperty("remoteDriver", "selenoid.autotests.cloud");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.remote = "https://" + login + ":" + password + "@" + remoteDriver + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
