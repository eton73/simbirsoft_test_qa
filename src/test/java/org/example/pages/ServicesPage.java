package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

    private WebDriver driver;

    public ServicesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"services-big-item-disk-title\"]")
    private WebElement diskButton;

    public void clickDiskButton() {
        diskButton.click();
    }

}
