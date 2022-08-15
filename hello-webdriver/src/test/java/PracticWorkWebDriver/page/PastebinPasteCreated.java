package PracticWorkWebDriver.page;

import PracticWorkWebDriver.test.BringItOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPasteCreated extends AbstractPage{

   // private WebDriver driver;


    public PastebinPasteCreated (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public PastebinPasteCreated openPage() {
        driver.get("");
        new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//*[@class='active-path']")).click(); //close Ads
        return this;
    }

}
