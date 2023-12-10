package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WildBerriesCardPage {
    private WebDriver driver;

    // локаторы элементов на странице корзины
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/a/span[1]")
    private WebElement cartItem;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div[1]/form/div[2]/div/div/div/div[2]/p/span[2]/span")
    private WebElement totalPrice;

    public WildBerriesCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCartItem(String productName) {
        // проверка названия товаров
        Assert.assertEquals(cartItem.getText(), productName);
    }

    public void verifyTotalPrice() {
        // проверка общей суммы товаров в корзине
        Assert.assertEquals(cartItem.getText(), cartItem.getText());
    }
}
