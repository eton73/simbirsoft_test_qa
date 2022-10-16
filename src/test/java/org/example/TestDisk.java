package org.example;

import org.example.pages.DiskPage;
import org.example.pages.LoginPage;
import org.example.pages.ServicesPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class TestDisk {

    private static LoginPage loginPage;
    private static DiskPage diskPage;
    private static ServicesPage servicesPage;
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("startPage"));

        loginPage = new LoginPage(driver);
        servicesPage = new ServicesPage(driver);
        diskPage = new DiskPage(driver);
    }

    @Test
    public void emailTest() throws InterruptedException {
        servicesPage.clickDiskButton();
        diskPage.clickLoginButton();

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginButton();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();

        String nameNewDirectory = ConfProperties.getProperty("nameNewDirectory");
        diskPage.clickCreateButton();
        diskPage.clickCreateDirectoryButton();
        diskPage.nameNewElementInput(nameNewDirectory);
        diskPage.clickSaveButton();

        String updatedNameNewDirectory = null;
        if (diskPage.isExistsErrorTextForNewElement()) {
            updatedNameNewDirectory = nameNewDirectory + new Random().nextInt();
            diskPage.clickCloseDialogWindowButton();
            diskPage.clickCreateButton();
            diskPage.clickCreateDirectoryButton();
            Thread.sleep(5000);
            diskPage.nameNewElementInput(updatedNameNewDirectory);
            diskPage.clickSaveButton();
        }
        if (updatedNameNewDirectory != null) {
            nameNewDirectory  = updatedNameNewDirectory;
        }

        diskPage.clickCloseWinInfoButton();
        diskPage.searchInput(nameNewDirectory);
        diskPage.clickSearchButton();
        diskPage.clickFoundedDirectoryButton();
        diskPage.clickCreateButton();
        diskPage.clickCreateTextFileButton();

        String nameNewFile = ConfProperties.getProperty("nameNewFile");
        Thread.sleep(5000);
        diskPage.nameNewElementInput(nameNewFile);
        diskPage.clickSaveButton();

        diskPage.searchInput(nameNewFile);
        diskPage.clickSearchButton();

        Assert.assertNull(diskPage.getNotFoundedText());
    }

    @AfterClass
    public static void logout() {
        diskPage.clickUserMenu();
        diskPage.clickLogoutButton();
        driver.close();
    }
}
