package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PaymentPageTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.mts.by";

    @BeforeClass
    public void setUp() {
        driver = new SafariDriver();
        driver.get(BASE_URL);
    }

    // Проверить название указанного блока Онлайн пополнение без комиссии
    @Test(priority = 1)
    public void testBlockTitle() {
        List<WebElement> blockTitle =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        Assert.assertEquals(blockTitle.get(0).getText(), "Онлайн пополнение без комиссии");
    }

    // Проверить наличие логотипов платёжных систем
    @Test(priority = 2)
    public void testPaymentLogs() {
        List<WebElement> paymentLogo1 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        List<WebElement> paymentLogo2 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        List<WebElement> paymentLogo3 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        List<WebElement> paymentLogo4 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        List<WebElement> paymentLogo5 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        List<WebElement> paymentLogo6 =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[2]/ul/li[6]/img"));

        Assert.assertTrue(paymentLogo1.get(0).isDisplayed());
        Assert.assertTrue(paymentLogo2.get(0).isDisplayed());
        Assert.assertTrue(paymentLogo3.get(0).isDisplayed());
        Assert.assertTrue(paymentLogo4.get(0).isDisplayed());
        Assert.assertTrue(paymentLogo5.get(0).isDisplayed());
        Assert.assertTrue(paymentLogo6.get(0).isDisplayed());
    }

    // Проверить работу ссылки Подробнее о сервисе
    @Test(priority = 3)
    public void testServiceDetailsLink() {
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        List<WebElement> detailsLink =
                driver.findElements(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a"));
        Assert.assertTrue(detailsLink.get(0).isEnabled());
    }

    // Заполнить поля и проверить работу кнопки Продолжить
    // проверяем только вариант «Услуги связи», номер для теста 297777777
    @Test(priority = 4)
    public void testContinueButton() {
        // заполнение полей
        WebElement serviceField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        serviceField.sendKeys("Услуги связи");
        WebElement numberField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[1]/input"));
        numberField.sendKeys("297777777");

        // проверка работы кнопки Продолжить
        WebElement continueButton =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/button"));
        Assert.assertTrue(continueButton.isEnabled());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
