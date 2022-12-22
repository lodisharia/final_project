package steps;

import com.codeborne.selenide.Condition;
import pages.HomePage;

public class LoginSteps {
    HomePage homePage = new HomePage();
    public LoginSteps login(String email, String password){
        HomePage.login.click();
        HomePage.emailField.sendKeys(email);
        HomePage.passwordField.sendKeys(password);
        HomePage.loginButton.click();
        return this;
    }
    public LoginSteps checkErrorMessage(){
        HomePage.wrongCredentialsErrorMessage.shouldHave(Condition.exactText("მეილი ან პაროლი არასწორია, თუ დაგავიწყდათ პაროლი,გთხოვთ ისარგებლოთ პაროლის აღდგენის ფუნქციით!"));
        return this;
    }
    public LoginSteps checkPassword(){
        HomePage.passwordField.shouldBe(Condition.empty);
        return this;
    }
}
