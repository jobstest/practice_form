package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormPage {
    CalendarComponent calendar = new CalendarComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement phoneInput = $("#userNumber");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement uploadPictureButton = $("#uploadPicture");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement submitButton = $("#submit");

    //actions
    public RegistrationFormPage openPage() {
        step("Открыть страницу аутентификации", () -> {
            open("/automation-practice-form");
            zoom(0.5);
            executeJavaScript("$('footer').remove()"); //убираем футер шоб кнопка влезла
            executeJavaScript("$('fixedban').remove()");
        });

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        step("Заполнить поле First Name", () -> {
            firstNameInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        step("Заполнить поле Last Name", () -> {
            lastNameInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        step("Заполнить поле Email", () -> {
            emailInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPage setPhone(String value) {
        step("Заполнить поле Mobile", () -> {
            phoneInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPage clickGenderRadioButton(String value) {
        step("Включить радиокнопку Gender", () -> {
            $(byText(value)).click();
        });

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        step("Заполнить поле Subject", () -> {
            subjectsInput.setValue(value).pressEnter();
        });

        return this;
    }

    public RegistrationFormPage clickHobbiesCheckBox(String value) {
        step("Включить чекбокс Hobbies", () -> {
            $(byText(value)).click();
        });

        return this;
    }

    public RegistrationFormPage uploadPicture() {
        step("Загрузить файл в поле Picter", () -> {
            uploadPictureButton.uploadFromClasspath("img/Screenshot_1.png");
        });

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        step("Заполнить поле Current Address", () -> {
            addressInput.setValue(value);
        });

        return this;
    }

    public RegistrationFormPage setState(String value) {
        step("Заполнить поле State", () -> {
            stateInput.click();
            $(byText(value)).click();
        });

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        step("Заполнить поле City", () -> {
            cityInput.click();
            $(byText(value)).click();
        });

        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        step("Нажать на кнопку Submit", () -> {
            submitButton.click();
        });

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        step("Проверить правильность заполненой формы в  окне Thanks for submitting the form", () -> {
            $(".table-responsive").$(byText(key))
                    .parent().shouldHave(text(value));
        });

        return this;
    }


    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        step("Заполнить поле Date of Birth", () -> {
            $("#dateOfBirthInput").click();
            calendar.setDate(day, month, year);
        });

        return this;
    }
}
