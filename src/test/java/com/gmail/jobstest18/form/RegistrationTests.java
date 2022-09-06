package com.gmail.jobstest18.form;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

@Tag("practice_form")
public class RegistrationTests extends TestBase {

    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String genderMale = "Male";
    String subjects = "Maths";
    String hobbies = "Sports";
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
    String fullAdress = state + " " + city;
    String year = "1985";
    String month = "March";
    String day = "11";
    String birthDate = day + " " + month + "," + year;


    @Test
    @DisplayName("Регистрация на странице")
    void fillPracticeFormTests() {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .clickGenderRadioButton(genderMale)
                .setPhone(phone)
                .setBirthDate(day, month, year)
                .setSubject(subjects)
                .clickHobbiesCheckBox(hobbies)
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genderMale)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", birthDate)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "Screenshot_1.png")
                .checkResult("Address", address)
                .checkResult("State and City", fullAdress);
    }
}
