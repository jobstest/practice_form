package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        open("/automation-practice-form");
        zoom(0.5);
        executeJavaScript("$('footer').remove()"); //убираем футер шоб кнопка влезла
        executeJavaScript("$('fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clickGenderRadioButton(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage clickHobbiesCheckBox(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture() {
        uploadPictureButton.uploadFile(new File("src/resources/Screenshot_1.png"));

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationFormPage CheckResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }


    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }
}
