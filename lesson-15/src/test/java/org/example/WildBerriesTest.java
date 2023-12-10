package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице
несколько товаров кладется в корзину, затем осуществляется переход в корзину и
происходят проверки на соответствие названия товаров, их количество,
цен каждого товара в корзине и общей суммы товаров.
При написании автотестов необходимо использовать подходящие паттерны, изученные в данной теме.
*/
public class WildBerriesTest {
    private WebDriver driver;
    private WildBerriesHomePage homePage;
    private WildBerriesCardPage cardPage;
    private WildBerriesProductPage productPage;

    @BeforeClass
    public void setUp() {
        // инициализация драйвера
        driver = new SafariDriver();
        //driver.manage().window().maximize();
        // инициализация страниц
        homePage = PageFactory.initElements(driver, WildBerriesHomePage.class);
        cardPage = PageFactory.initElements(driver, WildBerriesCardPage.class);
        productPage = PageFactory.initElements(driver, WildBerriesProductPage.class);
    }

    @Test
    public void testAddCartAndVerify() {
        // открытие главной страницы WildBerries и поиск товара
        homePage.open();
        homePage.findProduct("варежки");

        // переход на страницу товара и добавление в карзину
        productPage.open();
        productPage.addToCard();

        // переход в корзину
        productPage.goToCart();

        // проверка на соответствие информации в корзине
        cardPage.verifyCartItem("Варежки зимние теплые из эко меха");
        // проверка общей цены
        cardPage.verifyTotalPrice();
    }

    @AfterClass
    public void tearDown() {
        // закрытие браузера
        driver.quit();
    }
}
