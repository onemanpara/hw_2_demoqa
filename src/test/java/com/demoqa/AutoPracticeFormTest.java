package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    String name = "Mikhail";
    String surname = "Nesterov";
    String email = "onemanpara@gmail.com";
    String number = "9022541115";

    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1998");
        $(byAttribute("aria-label", "Choose Wednesday, August 26th, 1998")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
        $("#currentAddress").setValue("Test's Street");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(name));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(number));
        $(".table-responsive").shouldHave(text("26 August,1998"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("test.jpg"));
        $(".table-responsive").shouldHave(text("Test's Street"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }
}
