package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By constructorButton = By.xpath(".//*[text() = 'Конструктор']");
    private By logo = By.xpath(".//*[@class= 'AppHeader_header__logo__2D0X2']");
    private By exitButton = By.xpath(".//*[text() = 'Выход']");

    public OnlineAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

}
