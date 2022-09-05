package com.gmail.jobstest18.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositoryTest {

    @Test
    void shouldFindeSelenideFirstRepository() {
        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска Selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажать на линк от первого результат поиска
        $$("ul.repo-list li").first().$("a").click();
        // check: в заголовке встречается selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }

}
