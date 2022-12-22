package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage {
    public static SelenideElement login = $(".swoop-login");
    public static SelenideElement emailField = $("#emailinp");
    public static SelenideElement passwordField = $("#feed-password");
    public static SelenideElement loginButton = $("#AuthBtn");
    public static SelenideElement wrongCredentialsErrorMessage = $("#authInfo");
    public static SelenideElement registration = $("#ui-id-4");
    public static SelenideElement legalPerson = $("#ui-id-2");
    public static SelenideElement requiredFieldErrorMessage = $(By.xpath("//*[@id=\"register-content-2\"]/h4"));
    public static SelenideElement notificationsCheckbox = $("#IsLegalSubscribedNewsletter");
    public static SelenideElement legalForm = $("#lLegalForm");
    public static SelenideElement companyName = $("#lName");
    public static SelenideElement IdentificationCode = $("#lTaxCode");
    public static SelenideElement city = $("#lCity");
    public static SelenideElement postalCode = $("#lPostalCode");
    public static SelenideElement registrationEmail = $("#lContactPersonEmail");
    public static SelenideElement registrationPassword = $("#lContactPersonPassword");
    public static SelenideElement passwordConfirmation = $("#lContactPersonConfirmPassword");
    public static SelenideElement contactPerson = $("#lContactPersonName");
    public static SelenideElement personIdentificationCode = $("#lContactPersonPersonalID");
    public static SelenideElement phone = $("#lContactPersonPhone");
    public static SelenideElement legalTermsCheckbox = $("#IsLegalAgreedTerms");
    public static SelenideElement registrationButton = $(By.xpath("//*[@id=\"register-content-2\"]/div[2]/a/div/input"));
    public static SelenideElement registrationErrorMessage = $("#legalInfoMassage");
    public static SelenideElement vacationButton = $(byLinkText("დასვენება"));
    public static SelenideElement categoryTitle = $(By.xpath("//*[@id=\"sidebar\"]/div/div/div/section/div/div[3]/h2"));
    public static SelenideElement lowestPrice = $("#minprice");
    public static SelenideElement highestPrice = $("#maxprice");
    public static SelenideElement submitButton = $(By.xpath("//*[@id=\"sidebar\"]/div/div/div/section/div/div[5]/div[1]"));
    public static ElementsCollection prices = $$(".deal-voucher-price");
}
