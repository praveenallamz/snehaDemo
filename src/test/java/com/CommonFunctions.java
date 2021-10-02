package com;

import controllers.BaseMethod;
import org.testng.Assert;
import utils.ConfigReader;

public class CommonFunctions extends BaseMethod {
    //-----------------------------------Tool QA-------------------------------------------------------------------------------------

    public void launchWebsite(){
        navigateToUrl(ConfigReader.getValue("BASE_URL"));
    }

    public void doLoginToolQa(){
        inputText(Locators.loginPageToolQA.input_userName,Constants.userNameToolQa,"enter user name");
        inputText(Locators.loginPageToolQA.input_password,Constants.passwordToolQa,"enter password");
        click(Locators.loginPageToolQA.btn_login,"click on login button");
    }
    public void validateSuccessfulLoginOfToolsQa(){
        Assert.assertTrue(isWebElementVisible(Locators.loginPageToolQA.btn_logout),"logout button does not displayed");
    }

    public void searchBookOnToolQa() throws Exception {
        scrollToBottom();
        click(Locators.loginPageToolQA.btn_bookStore,"click on book store button");
        inputText(Locators.loginPageToolQA.input_searchBox,Constants.searchTextToolQa,"enter book name on search box");
    }

    public void validateBookSearchedOnToolsQa() throws InterruptedException {
        delay(2000);
        Assert.assertTrue(isWebElementVisible(Locators.loginPageToolQA.link_book),"book does not displayed on list");
    }
}




