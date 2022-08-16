package PracticWorkWebDriver.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    static String resultPageUrl;

    ///private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement fieldForPaste;

    @FindBy(id="postform-name")
    private WebElement fieldForTitle;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createButton;

    public PastebinHomePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @Override
    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@class='active-path']")).click();//close Ads
        return this;
    }

    public PastebinHomePage fillNewPaste(String string){
        fieldForPaste.sendKeys(string);
        return this;
    }

    public PastebinHomePage selectPasteExpiration(String string){
        WebElement iframe = driver.findElement(By.xpath("//*[@class='btn -big']"));
        new Actions(driver).scrollToElement(iframe).perform();
        waitForContainer(driver, "//*[@id='select2-postform-expiration-container']");
        driver.findElement(By.xpath("//*[@id='select2-postform-expiration-container']")).click();
        waitForContainer(driver, "//*[@id='select2-postform-expiration-results']");
        driver.findElement(By.xpath("//li[text()='"+string+"']")).click();
        return this;
    }
    public PastebinHomePage selectSyntaxHighlite(String string){
        WebElement iframe = driver.findElement(By.xpath("//*[@class='btn -big']"));
        new Actions(driver).scrollToElement(iframe).perform();
        waitForContainer(driver, "//*[@id='select2-postform-format-container']");
        driver.findElement(By.xpath("//*[@id='select2-postform-format-container']")).click();
        waitForContainer(driver, "//*[@id='select2-postform-format-results']");
        driver.findElement(By.xpath("//li[text()='"+string+"']")).click();
        return this;
    }

    public PastebinHomePage fillPasteName(String string){
        fieldForTitle.sendKeys(string);
        return this;
    }

    public PastebinHomePage createNewPaste(){
        createButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='date']")));
        return this;
    }

    public String getNewPasteUrl(){
        return driver.getCurrentUrl();
    }

    private static void waitForContainer(WebDriver driver, String xPath) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath(xPath))));
    }
}
