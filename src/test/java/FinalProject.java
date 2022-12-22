import com.codeborne.selenide.Configuration;
import data.LoginData;
import data.RegistrationData;
import data.SearchData;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.RegistrationSteps;
import steps.SearchSteps;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

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
    public void firstTest(){
        open(baseUrl);
        loginSteps.
                login(loginData.email,loginData.password).
                checkErrorMessage().
                checkPassword();
    }

    @Test
    public void secondTest(){
        open(baseUrl);
        registrationSteps.
                chooseLegalPerson().
                checkRequiredFields().
                notificationsCheckbox();
    }

    @Test(dependsOnMethods = "secondTest")
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
    public void fourthTest(){
        open(baseUrl);
        searchSteps.
                search(searchData.lowPrice,
                        searchData.highPrice);
    }

}
