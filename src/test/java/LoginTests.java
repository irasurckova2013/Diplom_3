import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import PageObjects.ForgotPasswordPage;
import org.junit.After;
import org.junit.Test;


public class LoginTests extends BrowserSelector {

    @Test
    public void loginMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        mainPage.checkTextExists("Оформить заказ");

    }

    @Test
    public void loginOnlineAccount() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnlineAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        mainPage.checkTextExists("Оформить заказ");

    }

    @Test
    public void loginRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkTextExists("Оформить заказ");

    }

    @Test
    public void loginPasswordRecoveryButton() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkTextExists("Оформить заказ");

    }

    @After
    public void closeBrowser () {
        driver.quit();
    }
}
