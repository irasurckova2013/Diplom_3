import PageObjects.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;;

public class RegistrationTests {
    private WebDriver driver;
    private DeleteUserSteps deleteUserSteps = new DeleteUserSteps();

    @Before
    public void prepare(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

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
