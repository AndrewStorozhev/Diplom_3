package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[@value='Enotiy']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вернуть заголовок Имя")
    public By getNameField() {
        return nameField;
    }


}
