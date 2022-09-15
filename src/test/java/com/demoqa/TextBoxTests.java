package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String name = "Egor";
        open("/text-box");
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@gmail.com");
        $("#currentAddress").setValue("Egor");
        $("#permanentAddress").setValue("Egor");
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text("Egor@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Egor"));
        $("#output #permanentAddress").shouldHave(text("Egor"));
    }
}
