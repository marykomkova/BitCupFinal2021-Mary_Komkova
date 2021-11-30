package com.mary.pages;

import com.mary.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {

    private By header = new By.ByXPath("//div[@class='header__content']");
    private By languageButton = new By.ByXPath("//button[@class='location-selector__button']");
    private By languagesButtons = new By.ByXPath("//ul[@class='location-selector__list']/li");
    private By findJobButton = new By.ByXPath("(//span[contains(text(), 'Find Your Dream Job')])[1]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(header).isDisplayed();
    }

    public void open(String link) {
        driver.get(link);
    }

    public void switchLanguage(String lang) {
        driver.findElement(languageButton).click();
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(languagesButtons));
        List<WebElement> languages = driver.findElements(languagesButtons);
        for (int i=0; i<languages.size(); i++) {
            if (languages.get(i).getText().contains(lang)) {
                languages.get(i).click();
                break;
            }
        }
    }

    public FindJobPage clickOnFindJob() {
        driver.findElement(findJobButton).click();
        return new FindJobPage(driver);
    }

}
