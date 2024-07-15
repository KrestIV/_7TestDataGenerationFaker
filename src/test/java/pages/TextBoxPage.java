package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement fullNameInput   = $("input#userName"),
            userEmailInput          = $("#userEmail"),
            currentAddressInput     = $("#currentAddress"),
            permanentAddressInput   = $("#permanentAddress"),
            submitButton            = $("#submit"),
            resultField             = $("#output");

    public TextBoxPage openPage() {
        open("/text-box");
        $("h1.text-center").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        resultField.shouldHave(text(key + ":" + value));

        return this;
    }
}
