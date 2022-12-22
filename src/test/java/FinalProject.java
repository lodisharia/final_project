import com.codeborne.selenide.Configuration;
import data.LoginData;
import data.RegistrationData;
import data.SearchData;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.RegistrationSteps;
import steps.SearchSteps;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

@Epic("Try logging in, signing up and filtering by prices")
public class FinalProject {
    LoginSteps loginSteps = new LoginSteps();
    LoginData loginData = new LoginData();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    RegistrationData registrationData = new RegistrationData();
    SearchData searchData = new SearchData();
    SearchSteps searchSteps = new SearchSteps();
    public FinalProject(){
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize="1920x1080";
        baseUrl = "https://www.swoop.ge/";
    }
    @Test
    @Description("Failed login")
    @Story("Try logging in without password")
    @Attachment
    public void firstTest(){
        open(baseUrl);
        loginSteps.
                login(loginData.email,loginData.password).
                checkErrorMessage().
                checkPassword();
    }

    @Test
    @Description("Check Registration Page")
    @Story("Check registration page for a legal person")
    @Attachment
    public void secondTest(){
        open(baseUrl);
        registrationSteps.
                chooseLegalPerson().
                checkRequiredFields().
                notificationsCheckbox();
    }

    @Test(dependsOnMethods = "secondTest")
    @Description("Failed registration")
    @Story("Try signing up without an email")
    @Attachment
    public void thirdTest() {
        registrationSteps.
                registration(registrationData.form,
                        registrationData.name,
                        registrationData.code,
                        registrationData.town,
                        registrationData.postCode,
                        registrationData.pass,
                        registrationData.pass,
                        registrationData.person,
                        registrationData.personCode,
                        registrationData.phoneNumber).
                checkRegistrationErrorMessage();
    }

    @Test
    @Description("Filter by price")
    @Story("Filter vacation results that range from 170 to 180")
    @Attachment
    public void fourthTest(){
        open(baseUrl);
        searchSteps.
                search(searchData.lowPrice,
                        searchData.highPrice);
    }

}
