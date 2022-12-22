package steps;

import com.codeborne.selenide.Condition;
import pages.HomePage;

public class RegistrationSteps {
    HomePage homePage = new HomePage();
        public RegistrationSteps chooseLegalPerson() {
            HomePage.login.click();
            HomePage.registration.click();
            HomePage.legalPerson.click();
            return this;
        };
        public RegistrationSteps checkRequiredFields(){
            HomePage.requiredFieldErrorMessage.shouldBe(Condition.visible);
            return this;
        }
        public RegistrationSteps notificationsCheckbox(){
            HomePage.notificationsCheckbox.shouldBe(Condition.checked);
            return this;
        }

        public RegistrationSteps registration(String form, String name, String code, String town, String postCode, String pass, String secondPass, String person, String personCode, String phoneNumber){
            HomePage.legalForm.selectOption(form);
            HomePage.companyName.sendKeys(name);
            HomePage.IdentificationCode.sendKeys(code);
            HomePage.city.sendKeys(town);
            HomePage.postalCode.sendKeys(postCode);
            HomePage.registrationPassword.sendKeys(pass);
            HomePage.passwordConfirmation.sendKeys(secondPass);
            HomePage.contactPerson.sendKeys(person);
            HomePage.personIdentificationCode.sendKeys(personCode);
            HomePage.phone.sendKeys(phoneNumber);
            HomePage.legalTermsCheckbox.click();
            HomePage.registrationButton.scrollIntoView(true).click();
            return this;
        }

        public RegistrationSteps checkRegistrationErrorMessage(){
            HomePage.registrationErrorMessage.shouldHave(Condition.exactText("რეგისტრაციის დროს დაფიქსირდა შეცდომა!"));
            return this;
        }
}
