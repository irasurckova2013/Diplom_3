import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelector {
    protected WebDriver driver;

    protected String yandexDriverPath = "C:/Users/User/local/bin";

    public BrowserSelector() {
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        driver = new ChromeDriver();
    }
}
