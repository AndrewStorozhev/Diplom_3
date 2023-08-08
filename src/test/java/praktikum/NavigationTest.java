package praktikum;

import io.qameta.allure.junit4.DisplayName;
import praktikum.pages.LoginPage;
import praktikum.pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class NavigationTest extends BaseMethods {

    @Before
    public void registrationUser(){
        getUser().registrationUser(getUserRegistration());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goToConstructorFromProfileOnConstructorLink() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        mainPage.clickOnConstructorLink();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void goToConstructorFromProfileOnStellarBurgerLogo() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnEnterAccountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getEmail(), getPassword());
        mainPage.clickOnPersonalArea();
        mainPage.clickOnStellarBurgersLogo();
        Assert.assertTrue(getDriver().findElement(mainPage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Работа переходов между разделами «Булки», «Соусы» и «Начинки»")
    public void correctTransitionsBetweenChapter() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesChapter();
        mainPage.clickOnBunsChapter();
        Assert.assertEquals("Булки", mainPage.getTextFromTheChosenElement());
        mainPage.clickOnSaucesChapter();
        Assert.assertEquals("Соусы", mainPage.getTextFromTheChosenElement());
        mainPage.clickOnIngredientsChapter();
        Assert.assertEquals("Начинки", mainPage.getTextFromTheChosenElement());
    }

    @Test
    @DisplayName("Работа перехода на раздел «Булки»")
    public void correctTransitionsBetweenChaptersIngredientsAndBuns() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsChapter();
        mainPage.clickOnBunsChapter();
        Assert.assertEquals("Булки", mainPage.getTextFromTheChosenElement());
    }

    @Test
    @DisplayName("Работа перехода на раздел «Соусы»")
    public void correctTransitionsBetweenChaptersIngredientsAndSauces() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnIngredientsChapter();
        mainPage.clickOnSaucesChapter();
        Assert.assertEquals("Соусы", mainPage.getTextFromTheChosenElement());
    }

    @Test
    @DisplayName("Работа перехода на раздел «Начинки»")
    public void correctTransitionsBetweenChaptersSaucesAndIngredients() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickOnSaucesChapter();
        mainPage.clickOnIngredientsChapter();
        Assert.assertEquals("Начинки", mainPage.getTextFromTheChosenElement());
    }

}
