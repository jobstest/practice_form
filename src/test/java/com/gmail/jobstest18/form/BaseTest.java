package com.gmail.jobstest18.form;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setUpSite() {
        Configuration.baseUrl = "https://demoqa.com";
    }
}
