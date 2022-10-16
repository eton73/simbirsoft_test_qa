package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class=\"Button2 Button2_checked Button2_size_l Button2_view_default\"]")
    private WebElement imailButton;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passwordField;

    public void emailButtonClick() {
        imailButton.click();
    }

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}

