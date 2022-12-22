package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.HomePage;

public class LoginSteps {
    HomePage homePage = new HomePage();
    @Step("Login")
    public LoginSteps login(String email, String password){
        HomePage.login.click();
        HomePage.emailField.sendKeys(email);
        HomePage.passwordField.sendKeys(password);
        HomePage.loginButton.click();
        return this;
    }

    @Step("Checking error message")
    public LoginSteps checkErrorMessage(){
        HomePage.wrongCredentialsErrorMessage.shouldHave(Condition.exactText("მეილი ან პაროლი არასწორია, თუ დაგავიწყდათ პაროლი,გთხოვთ ისარგებლოთ პაროლის აღდგენის ფუნქციით!"));
        return this;
    }

    @Step("Checking the password")
    public LoginSteps checkPassword(){
        HomePage.passwordField.shouldBe(Condition.empty);
        return this;
    }
}
