package com.epam.mailru.steps;

import com.epam.mailru.entity.Email;
import com.epam.mailru.pages.EmailMainPage;
import com.epam.mailru.pages.MainPage;
import com.epam.mailru.pages.MessageCreatingPage;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        return mainPage;
    }

    public EmailMainPage logIn(String username, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.enterUsername(username);
        mainPage.enterPassword(password);
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
        return new EmailMainPage(driver);
    }

    public MainPage logOut() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickLogOut();
        return new MainPage(driver);
    }

    public String getCurrentUser() {
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        return emailMainPage.getCurrentUserEmail();
    }

    public MessageCreatingPage openCreateMessagePage(){
        EmailMainPage emailMainPage = new EmailMainPage(driver);
        emailMainPage.clickCreateMessage();
        return new MessageCreatingPage(driver);
    }

    public void createMessage(Email email){
        MessageCreatingPage createPage = new MessageCreatingPage(driver);
        createPage.createMessage(email);
    }
    public void saveAsDraft(){
        MessageCreatingPage createPage = new MessageCreatingPage(driver);
        createPage.saveEmailAsDraft();
    }

}
