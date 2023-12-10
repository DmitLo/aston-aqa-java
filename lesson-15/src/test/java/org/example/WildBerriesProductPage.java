package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildBerriesProductPage {

    private WebDriver driver;

    // локаторы элементов на странице товара
    @FindBy(xpath = "/html/body/div[1]/main/div[2]/div/div[3]/div/div[3]/div[11]/div[1]/div/button[2]")
    private WebElement addToCartButton;
    @FindBy(xpath = "/html/body/div[2]/a[2]")
    private WebElement cartIcon;

    public WildBerriesProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        // открытие главной страницы
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.getPageSource());
        driver.get("https://www.wildberries.ru/catalog/184118646/detail.aspx");
    }

    public void addToCard() {
        // нажатие кнопки добавить в корзину
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        addToCartButton.click();
        wait.until(d -> driver.getPageSource());
    }

    public void goToCart() {
        // переход в корзину
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        cartIcon.click();
        wait.until(d -> driver.getPageSource());
    }
}
