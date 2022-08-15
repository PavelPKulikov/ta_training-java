package PracticWorkWebDriver.test;

//При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
//
//        Открыть https://pastebin.com или аналогичный сервис в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код: "Hello from WebDriver"
//
//        * Paste Expiration: "10 Minutes"
//
//        * Paste Name / Title: "helloweb"

import PracticWorkWebDriver.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ICanWin {
    protected WebDriver driver;



    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test(description = "First practice work for WebDriver & PO")
    public void iCanWin()  {
        new PastebinHomePage(driver).openPage().fillNewPaste("Hello from WebDriver")
        .selectPasteExpiration("10 Minutes").fillPasteName("helloweb")
        .createNewPaste();

    }



    @AfterMethod(alwaysRun = true)
    public void browserTearDown() throws InterruptedException {
        Thread.sleep(20000);
        driver.quit();
        driver = null;
    }
}
