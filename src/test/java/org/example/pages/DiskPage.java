package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DiskPage {

    public WebDriver driver;

    public DiskPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class=\"button button_login header__login-link\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_view_raised Button2_size_m Button2_width_max\"]")
    private WebElement createButton;

    @FindBy(xpath = "//*[@class=\"create-resource-button create-resource-popup-with-anchor__create-item\"]")
    private WebElement createDirectoryButton;

    @FindBy(xpath = "//*[@class=\"rename-dialog__rename-error\"]")
    private WebElement errorText;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit \"]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_view_clear-inverse Button2_size_m resources-action-bar__close\"]")
    private WebElement closeWinInfoButton;

    @FindBy(xpath = "//*[@class=\"Textinput-Control\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_pin_clear-round Button2_type_submit Button2_view_suggest Button2_size_m search-input__form-button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"Button2 Button2_view_clear Button2_size_s dialog__close\"]")
    private WebElement closeDialogWindowButton;

    @FindBy(xpath = "//*[@class=\"listing-item__icon-wrapper js-prevent-mouse-selection\"]")
    private WebElement foundedDirectoryButton;

    @FindBy(xpath = "//*[@class=\"file-icon file-icon_size_m file-icon_doc create-resource-button__icon\"]")
    private WebElement createTextFileButton;

    @FindBy(xpath = "//*[@class=\"listing-search-stub__caption\"]")
    private WebElement notFoundedText;

    @FindBy(xpath = "//*[@class=\"PSHeader-User PSHeader-User_noUserName promozavr-anchor-user\"]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@class=\"menu__item menu__item_type_link legouser__menu-item legouser__menu-item_action_exit\"]")
    private WebElement logoutButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickCreateDirectoryButton() {
        createDirectoryButton.click();
    }

    public void nameNewElementInput(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Textinput-Control")));
        driver.switchTo().activeElement().sendKeys(name);
    }

    public void clickCloseDialogWindowButton() {
        closeDialogWindowButton.click();
    }

    public void clickSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void clickCloseWinInfoButton() {
        closeWinInfoButton.click();
    }

    public boolean isExistsErrorTextForNewElement() {
        WebElement element = driver.findElement(By.className("rename-dialog__rename-error"));
        try {
            element.getText();
            return true;
        } catch (Exception exc) {
            return false;
        }
    }
    public void searchInput(String name) {
        searchInput.sendKeys(name);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickFoundedDirectoryButton() {
        Actions action = new Actions(driver);
        action.doubleClick(foundedDirectoryButton).perform();
    }

    public void clickCreateTextFileButton() {
        createTextFileButton.click();
    }

    public String getNotFoundedText() {
        try {
            return notFoundedText.getText();
        } catch (Exception exc) {
            return null;
        }
    }

    public void clickUserMenu() {
        userMenu.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}
