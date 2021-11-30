package com.mary.pages;

import com.mary.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VacancyPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1");
    private By fractionWhatYouHave = new By.ByXPath("(//ul[@class='bullet-list'])[2]/li");

    public VacancyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public boolean checkText(String word) {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(fractionWhatYouHave));
        List<WebElement> text = driver.findElements(fractionWhatYouHave);
        boolean status = false;
        for (int i=0; i<text.size(); i++) {
            if (text.get(i).getText().contains(word)) {
                status = true;
            }
        }
        return status;
    }

    public void storeInformation() {

    }
}
