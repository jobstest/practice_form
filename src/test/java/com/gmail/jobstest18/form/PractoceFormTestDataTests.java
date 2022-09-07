package com.gmail.jobstest18.form;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class PractoceFormTestDataTests extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String phone = faker.phoneNumber().phoneNumber();
    String genderMale = "Male";
    String subjects = "Maths";
    String hobbies = "Sports";
    String address = faker.rickAndMorty().location();
    String state = "NCR";
    String city = "Delhi";
    String year = "1985";
    String month = "March";
    String day = "11";

    String expectedFullName = format("%s %s", firstName, lastName);

    @Test
    @Tag("parametr")
    void fillPracticeFormTests() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть страницу", () -> {
            open("https://demoqa.com/automation-practice-form");
            //zoom(0.5);
            executeJavaScript("$('footer').remove()"); //убираем футер шоб кнопка влезла
            executeJavaScript("$('fixedban').remove()");
        });
        step("Заполнить поля", () -> {
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
            $("#uploadPicture").uploadFromClasspath("img/Screenshot_1.png");
            $("#currentAddress").setValue(address);
            $("#submit").scrollTo();
            $("#state").click();
            $(byText(state)).click();
            $("#city").click();
            $(byText(city)).click();
            $("#submit").click();
        });
        step("Проверить правильность заполнения", () -> {
            $(".table-responsive").shouldHave(
                    text(expectedFullName),
                    text(userEmail),
                    text(genderMale),
                    text(phone),
                    text(day + " " + month + "," + "" + year),
                    text(subjects),
                    text(hobbies),
                    text("Screenshot_1.png"),
                    text(state + " " + city));
        });
    }
}
