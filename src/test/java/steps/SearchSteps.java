package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.HomePage;


public class SearchSteps {
    HomePage homePage = new HomePage();
    @Step("Searching vacations by price")
    public SearchSteps search(String lowPrice, String highPrice){
        HomePage.vacationButton.click();
        HomePage.categoryTitle.scrollIntoView(true); //ფასის ფილდებზე ცოცხალი თავით არ სქროლავს და ამაზე მომიწია ჩამოსქროლვა
        HomePage.lowestPrice.setValue(lowPrice);
        HomePage.highestPrice.setValue(highPrice);
        HomePage.submitButton.click();
        return this;
    }
}
