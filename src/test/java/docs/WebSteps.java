package docs;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    AnnotatedStepTest screen = new AnnotatedStepTest();

    @Step("Открываем страницу {reg}")
    public void openRegistrationPage(String reg) {
        open(reg);
        screen.attachScreenshot();
    }
}
