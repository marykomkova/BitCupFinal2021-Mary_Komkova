package com.mary.pages;

import com.mary.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class VacanciesPage extends BasePage {

    private By titlePage = new By.ByXPath("//h1[@class='search-result__heading']");
    private By vacancies = new By.ByXPath("//a[@class='search-result__item-apply']");

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titlePage).isDisplayed();
    }

    public List<WebElement> getListOfVacancies() {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(vacancies));
        List<WebElement> checkButtons = driver.findElements(vacancies);
        return checkButtons;
    }
}
