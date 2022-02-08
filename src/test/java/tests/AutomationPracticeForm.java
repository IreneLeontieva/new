
package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillForm() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").sendKeys("Irina");
        $("#lastName").sendKeys("Leonteva");
        $("#userEmail").sendKeys("test@test.ru");
        $(byText("Female")).click();
        $("#userNumber").sendKeys("8921634771");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1994");
        $(".react-datepicker__month-select").selectOptionContainingText("December");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $(byText("Reading")).click();
        $(byText("Sports")).click();
        File cv = new File("src/test/resources/cv.pdf");
        $("#uploadPicture").uploadFile(cv);
        $("#currentAddress").sendKeys("Moscow");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Irina Leonteva"));
        $(".table-responsive").shouldHave(text("test@test.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("8921634771"));
        $(".table-responsive").shouldHave(text("13 December,1994"));
        $(".table-responsive").shouldHave(text("Biology, Chemistry"));
        $(".table-responsive").shouldHave(text("Reading, Sports"));
        $(".table-responsive").shouldHave(text("cv.pdf"));
        $(".table-responsive").shouldHave(text("Moscow"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));





    }
}