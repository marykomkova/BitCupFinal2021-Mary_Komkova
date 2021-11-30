package com.mary.pages;

import com.mary.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FindJobPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h2/span[@class='title__bottom-line']");
    private By keywordInput = new By.ByXPath("//input[@id='new_form_job_search_1445745853_copy-keyword']");
    private By chooseLocationButton = new By.ByXPath("//span[@class='select2-selection__arrow']");
    private By cities = new By.ByXPath("//ul[@class='select2-results__options select2-results__options--nested open']/li");
    private By skillsButton = new By.ByXPath("//div[@class='default-label' and contains(text(), 'All Skills')]");
    private By skillsButton2 = new By.ByXPath("//div[@class='selected-params selected']");
    private By skills = new By.ByXPath("//label/span[@class='checkbox-custom-label']");
    private By adds = new By.ByXPath("//label[@class='recruiting-search__filter-label checkbox-custom-label']");
    private By findButton = new By.ByXPath("//button[@class='recruiting-search__submit']");

    public FindJobPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return driver.findElement(titleLabel).isDisplayed();
    }

    public void enterKeyword(String word) {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(keywordInput));
        driver.findElement(keywordInput).click();
    }

    public void enterLocation(String city) {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(chooseLocationButton));
        driver.findElement(chooseLocationButton).click();
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(cities));
        List<WebElement> citiesButtons = driver.findElements(cities);
        for (int i=0; i<citiesButtons.size(); i++) {
            if (citiesButtons.get(i).getText().contains(city)) {
                citiesButtons.get(i).click();
                break;
            }
        }
    }

    public void enterSkills(String skill) {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(skillsButton));
        driver.findElement(skillsButton).click();
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(skills));
        List<WebElement> skillsB = driver.findElements(skills);
        for (int i=0; i<skillsB.size(); i++) {
            if (skillsB.get(i).getText().contains(skill)) {
                skillsB.get(i).click();
                break;
            }
        }
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(skillsButton2));
        driver.findElement(skillsButton2).click();
    }

    public void chooseAdds(String add) {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(adds));
        List<WebElement> addsButtons = driver.findElements(adds);
        for (int i=0; i<addsButtons.size(); i++) {
            if (addsButtons.get(i).getText().contains(add)) {
                addsButtons.get(i).click();
                break;
            }
        }
    }

    public VacanciesPage clickOnFind() {
        waitUntil(TimeConstants.PAGE_LOAD_TIMEOUT, ExpectedConditions.presenceOfElementLocated(findButton));
        driver.findElement(findButton).click();
        return new VacanciesPage(driver);
    }
}
