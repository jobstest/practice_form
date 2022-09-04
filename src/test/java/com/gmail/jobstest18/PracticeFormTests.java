package com.gmail.jobstest18;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import docs.WebSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTests {

    private static final String REGISTRATION_FORM = "/automation-practice-form";

    String firstName = "Test";
    String lastName = "Testov";
    String userEmail = "test@mail.com";
    String phone = "9999999999";
    String genderMale = "Male";
    String subjects = "Maths";
    String hobbies = "Sports";
    String address = "Street 1";
    String state = "NCR";
    String city = "Delhi";
    String year = "1985";
    String month = "March";
    String day = "11";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Owner("parfionov")
    @DisplayName("Test")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории") // то что отделяемо
    @Story("Просмотр созданных задач в репозитории")
    @Link(value = "Страница регистрации", url = "https://demoqa.com/automation-practice-form")
    void fillPracticeFormTests() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // шаги в аллюре

        step ("Открываем страницу" + REGISTRATION_FORM, () -> {  // лямбда
            open(REGISTRATION_FORM);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
        zoom(0.5);
        executeJavaScript("$('footer').remove()"); //убираем футер шоб кнопка влезла
        executeJavaScript("$('fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(phone);
        $(byText(genderMale)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(byText(day)).click();
        $(("#subjectsInput")).setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/resources/Screenshot_1.png"));
        $("#currentAddress").setValue(address);
        $("#submit").scrollTo();
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text(genderMale),
                text(phone),
                text(day + " " + month + "," + "" + year),
                text(subjects),
                text(hobbies),
                text("Screenshot_1.png"),
                text(state + " " + city));
    }

    @Test
    public void fillPracticeFormTests2() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // шаги в аллюре
        WebSteps steps = new WebSteps();

        steps.openRegistrationPage(REGISTRATION_FORM);
    }
}
