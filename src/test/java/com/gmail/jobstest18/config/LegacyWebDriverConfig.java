package com.gmail.jobstest18.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LegacyWebDriverConfig {

    /*public Browser getBrowser() { // 1-я версия
        return Browser.CHROME;
    }*/

    public Browser getBrowser() {
        // зачитывает данные из командной строки
        String browser = System.getProperty("browser");
        // обрабатывает дефолтное значение
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        // конвертирует в возвращаемый тип
        return Browser.valueOf(browser);
    }

    public String getBaseUrl() {
        // зачитывает данные из командной строки
        String baseUrl = System.getProperty("baseUrl");
        // обрабатывает дефолтное значение
        if (Objects.isNull(baseUrl)) {
            baseUrl = "https://github.com";
        }
        // конвертирует в возвращаемый тип
        return baseUrl;
    }

    public URL getRemoteUrl() {
        // зачитывает данные из командной строки
        String remoteUrl = System.getProperty("remoteUrl");
        // обрабатывает дефолтное значение
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "https://selenium:4444/wd/hub";
        }
        // конвертирует в возвращаемый тип
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
