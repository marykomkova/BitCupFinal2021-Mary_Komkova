package com.mary.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindJobPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h2/span[@class='title__bottom-line']");

    public FindJobPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }
}
