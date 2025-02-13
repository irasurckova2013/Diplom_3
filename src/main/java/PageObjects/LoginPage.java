package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fieldEmail = By.xpath(".//*[text()= 'Email']/../input");
    private By fieldPassword = By.xpath(".//input[@name = 'Пароль']");
    private By registrationButton = By.xpath(".//*[text() = 'Войти']");
    private By passwordRecoveryButton = By.xpath(".//*[text() = 'Восстановить пароль']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickEnterButton() {
        driver.findElement(registrationButton).click();
    }

    public void setFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    private void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void checkTextExists(String expectedText) {
        waitForElementVisible(By.xpath(".//*[text() = '" + expectedText + "']"));
    }
}
