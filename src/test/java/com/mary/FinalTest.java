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
        mainPage.open("https://www.epam.com/careers");
        Assert.assertTrue(mainPage.isOpened());
        mainPage.switchLanguage("Global");
        FindJobPage findJobPage = mainPage.clickOnFindJob();
        Assert.assertTrue(findJobPage.isOpened());
        String word = "Jenkins";
        findJobPage.enterKeyword(word);
        findJobPage.enterLocation("Minsk");
        findJobPage.enterSkills("Software Test Engineering");
        findJobPage.chooseAdds("Remote");
        VacanciesPage vacanciesPage = findJobPage.clickOnFind();
        Assert.assertTrue(vacanciesPage.isOpened());
        List<WebElement> vacancies = vacanciesPage.getListOfVacancies();
        for (int i=0; i<vacancies.size(); i++) {
            vacancies.get(i).click();
            VacancyPage vacancyPage = new VacancyPage(driver);
            Assert.assertTrue(vacancyPage.isOpened());

            vacancyPage.checkText(word);
            driver.navigate().back();
            vacanciesPage = new VacanciesPage(driver);
            Assert.assertTrue(vacanciesPage.isOpened());
        }

    }
}
