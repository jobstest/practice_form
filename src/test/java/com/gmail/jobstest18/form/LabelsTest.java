package com.gmail.jobstest18.form;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("parfionov")
    @DisplayName("Test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории") // то что отделяемо
    @Story("Просмотр созданных задач в репозитории")
    @Link(value = "Страница регистрации", url = "https://demoqa.com/automation-practice-form")
    public void testAnnotated() {

    }
}
