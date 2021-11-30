package com.mary.pages;

import com.mary.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;
import java.util.Date;
import java.util.List;

public class VacancyPage extends BasePage {

    private By titleLabel = new By.ByXPath("//h1");
    private By fractionWhatYouHave = new By.ByXPath("(//ul[@class='bullet-list'])[2]/li");
    private By jobDescription = new By.ByXPath("(//ul[@class='bullet-list'])[2]/li");

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
        String label = driver.findElement(titleLabel).getText();
        String url = driver.getCurrentUrl();
        String job = driver.findElement(jobDescription).getText();
        Date date = new Date();
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("Mary_Komkova_" + date.toString() + ".txt"), "utf-8"));
            writer.write(label + "\n" + url + "\n" + job + "\n");
        } catch (IOException ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
