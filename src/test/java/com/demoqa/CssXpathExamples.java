package com.demoqa;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        $("[data-testid=email]").setValue("a@a.com");
        $(by("data-testid", "email")).setValue("a@a.com");

        //<div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'llo qa.guru']");
        $x("//div[text(text()[contains(., 'llo qa.guru']");
        $(byText("Hello qa.guru"));
        $(withText("Hello qa.guru"));
    }
}