package com.gmail.jobstest18.form;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationTests {

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

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    @Disabled
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
                .CheckResult("Student Name", firstName + " " + lastName)
                .CheckResult("Student Email", userEmail)
                .CheckResult("Gender", genderMale)
                .CheckResult("Mobile", phone)
                .CheckResult("Date of Birth", birthDate)
                .CheckResult("Subjects", subjects)
                .CheckResult("Hobbies", hobbies)
                .CheckResult("Picture", "Screenshot_1.png")
                .CheckResult("Address", address)
                .CheckResult("State and City", fullAdress);
    }
}
