package PracticWorkWebDriver.test;

//При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
//
//Открыть https://pastebin.com  или аналогичный сервис в любом браузере
//        Создать New Paste со следующими деталями:
//        * Код:
//
//        git config --global user.name  "New Sheriff in Town"
//        git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
//        git push origin master --force
//        * Syntax Highlighting: "Bash"
//
//        * Paste Expiration: "10 Minutes"
//
//        * Paste Name / Title: "how to gain dominance among developers"
//
//        3. Сохранить paste и проверить следующее:
//
//        * Заголовок страницы браузера соответствует Paste Name / Title
//
//        * Синтаксис подвечен для bash
//
//        * Проверить что код соответствует введенному в пункте 2
import PracticWorkWebDriver.page.PastebinHomePage;
import PracticWorkWebDriver.page.PastebinPasteCreated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class BringItOn {

    protected WebDriver driver;
    private String syntaxOfPaste = "Bash";
    private String nameOfPaste = "how to gain dominance among developers";
    private String textToPaste = "git config --global user.name  \"New Sheriff in Town\"\n"+
                                 "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"+
                                 "git push origin master --force";
    static String resultUrl;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test(description = "Second practice task for WebDriver & PO")
    public void bringItOn()  {
        resultUrl = new PastebinHomePage(driver).openPage().fillNewPaste(textToPaste)
        .selectPasteExpiration("10 Minutes")
        .selectSyntaxHighlite(syntaxOfPaste)
        .fillPasteName(nameOfPaste)
        .createNewPaste()
        .getNewPasteUrl();
    }

    @Test(description = "Equal page Title and paste name")
    public void checkPageTitle(){
        new PastebinPasteCreated(driver).setUrlOfPaste(resultUrl).openPage();
        Assert.assertEquals(driver.getTitle().replace(" - Pastebin.com",""),
                nameOfPaste);
    }


    @Test(description = "Equal syntax from page and syntax from task")
    public void checkSyntax(){

        new PastebinPasteCreated(driver).setUrlOfPaste(resultUrl).openPage();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='top-buttons']//a")).getText(),
                syntaxOfPaste);
    }

    @Test
    public void checkTextOfPaste(){
        new PastebinPasteCreated(driver).setUrlOfPaste(resultUrl).openPage();
        Assert.assertEquals(driver.findElement(By.xpath("//textarea")).getText(), textToPaste);
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
