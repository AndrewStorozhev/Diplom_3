package praktikum.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserTypeSetup {

    private final static Browser CURRENT_BROWSER = Browser.CHROME; // выбор браузера CHROME или YANDEX
    private static final ChromeOptions options = new ChromeOptions();

    public static WebDriver browserDriverSetUp(){
        WebDriver driver = null;
        options.addArguments("--remote-allow-origins=*");
        switch (CURRENT_BROWSER) {
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                driver = new ChromeDriver(options);
                break;
            case CHROME:
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }

}