import PageObjects.LoginPage;
import PageObjects.MainPage;
import org.junit.After;
import org.junit.Test;

public class ConstructorTabsTests extends BrowserSelector{

    @Test
    public void constructorTabsTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFieldEmail(TestCredentials.LOGINEMAIL);
        loginPage.setFieldPassword(TestCredentials.LOGINPASSWORD);
        loginPage.clickEnterButton();

        mainPage.checkTextExists("Оформить заказ");

        mainPage.clickIngredient("Начинки");
        mainPage.checkIngredient("Начинки");

        mainPage.clickIngredient("Соусы");
        mainPage.checkIngredient("Соусы");

        mainPage.clickIngredient("Булки");
        mainPage.checkIngredient("Булки");

    }
    @After
    public void closeBrowser () {
        driver.quit();
    }
}
