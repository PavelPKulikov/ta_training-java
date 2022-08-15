import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://atlantmarket.com.ua/b2b/");
        WebElement login = driver.findElement(By.xpath("//*[@class='registration-form__input'][@type='text']"));
        WebElement password = driver.findElement(By.xpath("//*[@class='registration-form__input'][@type='password']"));
        login.sendKeys("sales@legioner.com.ua");
        password.sendKeys("*K4y%f");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Увійти']")));
        WebElement lgnBtn = waitForElementLocatedBy(driver, By.xpath("//*[@value='Увійти']"));

        lgnBtn.click();
        Thread.sleep(2000);
        driver.quit();



    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) { // Ожидание появления элемента по признаку (напр. By.xpath)
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));

    }
}
