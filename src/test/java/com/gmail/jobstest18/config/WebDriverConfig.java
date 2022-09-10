package com.gmail.jobstest18.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {
    // зачитывает данные из командной строки
    @Key("baseUrl")
    // обрабатывает дефолтное значение
    @DefaultValue("https://github.com")
    // конвертирует в возвращаемый тип
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("https://selenium:4444/wd/hub")
    URL getRemoteUrl();
}
