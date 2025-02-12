import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class BrowserSelector {
    protected WebDriver driver;

    public BrowserSelector() {

        File driverFile = new File(getClass().getClassLoader().getResource("chromedriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
        driver = new ChromeDriver();
    }
}
