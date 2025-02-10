package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By enterButton = By.xpath(".//*[text() = 'Войти']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

}
