package PracticWorkWebDriver.page;

import PracticWorkWebDriver.test.BringItOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPasteCreated extends AbstractPage{
    public String urlOfPaste;

    public PastebinPasteCreated setUrlOfPaste(String urlOfPaste) {
        this.urlOfPaste = urlOfPaste;
        return this;
    }

    public PastebinPasteCreated (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public PastebinPasteCreated openPage() {
        driver.get(urlOfPaste);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        return this;
    }

}
