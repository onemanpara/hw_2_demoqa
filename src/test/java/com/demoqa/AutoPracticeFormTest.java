package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class AutoPracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    File file = new File("src/test/resources/test.jpg");

    @Test
    void FormTest() {
        open("/automation-practice-form");
        $x("//input[@id='firstName']").setValue("Mikhail");
        $x("//input[@id='lastName']").setValue("Nesterov");
        $x("//input[@id='userEmail']").setValue("onemanpara@gmail.com");
        $x("//div[@class='custom-control custom-radio custom-control-inline']/label[contains(text(), 'Male')]").click();
//       $x("//input[@name='gender']").selectRadio("Male");
        $x("//input[@id='userNumber']").setValue("9022541115");
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[@class='react-datepicker__month-select']").selectOption("August");
        $x("//select[@class='react-datepicker__year-select']").selectOption("1998");
        $x("//div[@class='react-datepicker__month-container']//div[@aria-label='Choose Wednesday, August 26th, 1998']").click();
//        $x("//div[@id='subjectsContainer']").click();
//        $x("//div[@id='subjectsContainer']").setValue("Maths").pressEnter();
//        $x("//div[@id='subjectsContainer']").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $x("//label[@for='hobbies-checkbox-2']").click();
        $x("//label[@for='hobbies-checkbox-3']").click();
        $x("//input[@id='uploadPicture']").uploadFile(file);
        $x("//textarea[@placeholder='Current Address']").setValue("Test's Street");


    }
}
