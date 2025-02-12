import PageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineAccountTests extends BrowserSelector{
    private WebDriver driver;
    private DeleteUserSteps deleteUserSteps = new DeleteUserSteps();

    @Before
    public void prepare(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void navigateToOnlineAccountPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnlineAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        mainPage.checkTextExists("Оформить заказ");

        mainPage.clickOnlineAccountButton();

        mainPage.checkTextExists("Профиль");
    }

    @Test
    public void navigateToMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnlineAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();
        mainPage.checkTextExists("Оформить заказ");

        mainPage.clickOnlineAccountButton();
        mainPage.checkTextExists("Профиль");

        OnlineAccountPage onlineAccountPage = new OnlineAccountPage(driver);
        onlineAccountPage.clickConstructorButton();
        mainPage.checkTextExists("Оформить заказ");

        mainPage.clickOnlineAccountButton();
        mainPage.checkTextExists("Профиль");

        onlineAccountPage.clickLogo();
        mainPage.checkTextExists("Оформить заказ");
    }

    @Test
    public void exitTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnlineAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();
        mainPage.checkTextExists("Оформить заказ");

        mainPage.clickOnlineAccountButton();
        mainPage.checkTextExists("Профиль");

        OnlineAccountPage onlineAccountPage = new OnlineAccountPage(driver);
        onlineAccountPage.clickExitButton();

        loginPage.checkTextExists("Вход");

    }

    @After
    public void closeBrowser () {
        driver.quit();
    }
}
