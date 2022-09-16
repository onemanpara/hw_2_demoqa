package com.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    File file = new File("src/test/resources/test.jpg");
    String name = "Mikhail";
    String surname = "Nesterov";
    String email = "onemanpara@gmail.com";
    String number = "9022541115";

    @Test
    void formTest() {
        open("/automation-practice-form");
        $x("//input[@id='firstName']").setValue(name);
        $x("//input[@id='lastName']").setValue(surname);
        $x("//input[@id='userEmail']").setValue(email);
        $x("//label[contains(text(), 'Male')]").click();
        $x("//input[@id='userNumber']").setValue(number);
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption("August");
        $x("//select[@class='react-datepicker__year-select']").selectOption("1998");
        $x("//div[@class='react-datepicker__month-container']//div[@aria-label='Choose Wednesday, August 26th, 1998']").click();
        $x("//div[@id='subjectsContainer']//input").setValue("Maths").pressEnter();
        $x("//div[@id='hobbiesWrapper']//label[contains(text(), 'Sports')]").click();
        $x("//div[@id='hobbiesWrapper']//label[contains(text(), 'Reading')]").click();
        $x("//div[@id='hobbiesWrapper']//label[contains(text(), 'Music')]").click();
        $x("//input[@id='uploadPicture']").uploadFile(file);
        $x("//textarea[@placeholder='Current Address']").setValue("Test's Street");
        $x("//div[@class=' css-tlfecz-indicatorContainer']").scrollIntoView(true);
        $x("//div[@class=' css-tlfecz-indicatorContainer']").click();
        $x("//div[@id='state']//div[contains(text(), 'Haryana')]").doubleClick();
        $x("//div[@id='city']").click();
        $x("//div[@id='city']//div[contains(text(), 'Karnal')]").click();
        $x("//button[@id='submit']").click();

        $x("//div[@class='table-responsive']").shouldHave(Condition.text(name));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(surname));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(email));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text(number));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("26 August,1998"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Male"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Maths"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Sports, Reading, Music"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("test.jpg"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Test's Street"));
        $x("//div[@class='table-responsive']").shouldHave(Condition.text("Haryana Karnal"));
    }
}
