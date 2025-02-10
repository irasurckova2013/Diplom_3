package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginButton = By.xpath(".//*[text() = 'Войти в аккаунт']");
    private By createOrderButton = By.xpath(".//*[text() = 'Оформить заказ']");
    private By onlineAccountButton = By.xpath(".//*[text() = 'Личный Кабинет']");

    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickEnterButton() {
        driver.findElement(loginButton).click();
    }

    public void clickOnlineAccountButton() {
        driver.findElement(onlineAccountButton).click();
    }

    private void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void checkTextExists(String expectedText) {
        waitForElementVisible(By.xpath(".//*[text() = '" + expectedText + "']"));
    }

    public void clickIngredient(String ingredient) {
        driver.findElement(By.xpath(".//div//*[text() ='" + ingredient + "'][1]")).click();
    }

    public void checkIngredient(String expectedText) {
        waitForElementVisible(By.xpath(".//h2[text() = '" + expectedText + "']"));
    }
}
