package com.mary;

import com.mary.pages.FindJobPage;
import com.mary.pages.MainPage;
import com.mary.pages.VacanciesPage;
import com.mary.pages.VacancyPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FinalTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open(PropertiesReader.getValue("link"));
        Assert.assertTrue(mainPage.isOpened());
        mainPage.switchLanguage(PropertiesReader.getValue("language"));
        FindJobPage findJobPage = mainPage.clickOnFindJob();
        Assert.assertTrue(findJobPage.isOpened());
        String word = PropertiesReader.getValue("keyword");
        findJobPage.enterKeyword(word);
        findJobPage.enterLocation(PropertiesReader.getValue("city"));
        findJobPage.enterSkills(PropertiesReader.getValue("skill"));
        findJobPage.chooseAdds(PropertiesReader.getValue("add"));
        VacanciesPage vacanciesPage = findJobPage.clickOnFind();
        Assert.assertTrue(vacanciesPage.isOpened());
        List<WebElement> vacancies = vacanciesPage.getListOfVacancies();
        for (int i=0; i<vacancies.size(); i++) {
            vacancies.get(i).click();
            VacancyPage vacancyPage = new VacancyPage(driver);
            Assert.assertTrue(vacancyPage.isOpened());
            vacancyPage.storeInformation();
            vacancyPage.checkText(word);
            driver.navigate().back();
            vacanciesPage = new VacanciesPage(driver);
            Assert.assertTrue(vacanciesPage.isOpened());
        }
    }
}
