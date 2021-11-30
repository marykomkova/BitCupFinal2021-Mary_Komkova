package com.mary.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VacanciesPage extends BasePage {

    private By titlePage = new By.ByXPath("//h1[@class='search-result__heading']");

    public VacanciesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titlePage).isDisplayed();
    }
}
