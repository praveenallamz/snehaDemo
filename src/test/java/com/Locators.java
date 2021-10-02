package com;

import org.openqa.selenium.By;

public interface Locators {

    //----------------------------------Tools Qa--------------------------------------------------------------------------------

    interface loginPageToolQA{
        By input_userName=By.id("userName");
        By input_password=By.id("password");
        By btn_login=By.id("login");
        By btn_logout=By.xpath("//button[text()='Log out']");


        By btn_bookStore=By.xpath("//*[text()='Book Store']");
        By input_searchBox=By.id("searchBox");
        By link_book=By.xpath("//a[text()='Git Pocket Guide']");
    }

}
