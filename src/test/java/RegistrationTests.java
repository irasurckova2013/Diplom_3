import PageObjects.RegistrationPage;
import org.junit.After;
import org.junit.Test;

public class RegistrationTests  extends BrowserSelector{
    private DeleteUserSteps deleteUserSteps = new DeleteUserSteps();

    @Test
    public void successfulRegistrationTest() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setFieldName(TestCredentials.NAME);
        registrationPage.setFieldEmail(TestCredentials.EMAIL);
        registrationPage.setFieldPassword(TestCredentials.PASSWORD);
        registrationPage.clickRegistrationButton();
        deleteUserSteps.deleteUser();


    }

    @Test
    public void failedRegistrationTest() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.setFieldName(TestCredentials.NAME);
        registrationPage.setFieldEmail(TestCredentials.EMAIL);
        registrationPage.setFieldPassword(TestCredentials.INCORRECTPASSWORD);
        registrationPage.clickRegistrationButton();
        registrationPage.checkErrorText("Некорректный пароль");


    }

    @After
    public void closeBrowser () {
        driver.quit();
    }

}
