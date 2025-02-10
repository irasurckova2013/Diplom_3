import PageObjects.*;
import org.junit.After;
import org.junit.Test;

public class OnlineAccountTests extends BrowserSelector{

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
