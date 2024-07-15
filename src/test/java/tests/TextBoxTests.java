package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testData.TestDataGenerationFaker;

public class TextBoxTests extends TestBase{

    TextBoxPage textBoxPage = new TextBoxPage();
    TestDataGenerationFaker tData = new TestDataGenerationFaker();
    @Test
    void successfulFormSubmitTest(){
        textBoxPage.openPage()
                .setFullName(String.format("%s %s",tData.firstName,tData.lastName))
                .setEmail(tData.email)
                .setCurrentAddress(tData.address)
                .setPermanentAddress(tData.address)
                .submit()

                .checkResult("Name",String.format("%s %s",tData.firstName,tData.lastName))
                .checkResult("Email",tData.email)
                .checkResult("Current Address ",tData.address)
                .checkResult("Permananet Address ",tData.address);
    }
}
