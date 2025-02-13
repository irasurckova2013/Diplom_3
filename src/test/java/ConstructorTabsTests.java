import PageObjects.LoginPage;
import PageObjects.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstructorTabsTests {
    private WebDriver driver;

    @Before
    public void prepare(){
        WebDriverManager.chromiumdriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

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
