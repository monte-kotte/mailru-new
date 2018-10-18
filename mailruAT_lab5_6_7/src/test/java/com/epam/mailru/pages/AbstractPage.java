package com.epam.mailru.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitForClicableAndClick(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitForDocumentReady() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

    protected void waitElementRefresh(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    protected void safeClick(WebElement element) {
        //method tries to click until the link to the element is updated
        for (int i = 0; i <= 2; i++) {
            try {
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
