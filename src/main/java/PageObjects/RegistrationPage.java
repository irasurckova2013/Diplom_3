package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By fieldName = By.xpath(".//*[text()= 'Имя']/../input");
    private By fieldEmail = By.xpath(".//*[text()= 'Email']/../input");
    private By fieldPassword = By.xpath(".//input[@name = 'Пароль']");
    private By registrationButton = By.xpath(".//*[text() = 'Зарегистрироваться']");
    private By enterButton = By.xpath(".//*[text() = 'Войти']");

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void setFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void setFieldEmail(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }

    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void checkErrorText(String textErrorER) {
        String checktextQuestionsAR = driver.findElement(By.xpath(".//*[@class = 'input__error text_type_main-default']")).getAttribute("textContent");
        assertEquals("Некорректный пароль", textErrorER, checktextQuestionsAR);
    }
}
