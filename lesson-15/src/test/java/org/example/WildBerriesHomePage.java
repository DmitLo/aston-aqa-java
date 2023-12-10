package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildBerriesHomePage {
    private WebDriver driver;

    // Локаторы элементов на главной странице
    // строка поиска
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div[1]/input")
    private WebElement searchInput;
    // кнопка поиска
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div[1]/div[2]/button[1]")
    private WebElement searchButton;
    // кнопка очистки
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[2]/div[1]/div[2]/button[2]")
    private WebElement clearButton;
    // первый результат поиска
    @FindBy(xpath = "//*[@id=\"c184118646\"]/div/a")
    private WebElement firstSearchResult;

    public WildBerriesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        // открытие главной страницы
        driver.get("https://www.wildberries.ru/");
    }

    public void findProduct(String itemName) {
        // поиск элементов
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.getPageSource());
        searchInput.click();
        wait.until(d -> driver.getPageSource());
        searchInput.sendKeys(itemName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        searchInput.sendKeys(Keys.ENTER);

        // выбираем первый попавшийся товар
        WebElement dynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("/html/body/div[1]/main/div[2]/div/div[2]/div/div/div[4]/div[1]/div[1]/div/article[10]/div/a"))));
        dynamicElement.click();
    }
}
