package com.gmail.jobstest18;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class PractoceFormTestDataTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillPracticeFormTests() {

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

        String expectedFullName = format("%s %s", firstName, lastName);

        open("/automation-practice-form");
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
    }

}
