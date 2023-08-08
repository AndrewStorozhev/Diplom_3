package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProfilePage {

    private final By nameField = By.xpath(".//input[@value='Enotiy']");

    @Step("Вернуть заголовок Имя")
    public By getNameField() {
        return nameField;
    }


}
