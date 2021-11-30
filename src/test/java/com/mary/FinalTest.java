package com.mary;

import com.mary.pages.FindJobPage;
import com.mary.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FinalTest extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open("https://www.epam.com/careers");
        Assert.assertTrue(mainPage.isOpened());
        mainPage.switchLanguage("Global");
        FindJobPage findJobPage = mainPage.clickOnFindJob();
        Assert.assertTrue(findJobPage.isOpened());

    }
}
