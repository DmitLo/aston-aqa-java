package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PaymentPageTest {
    private WebDriver driver;
    private static final String BASE_URL = "https://www.mts.by";

    @BeforeClass
    public void setUp() {
        driver = new SafariDriver();
        driver.get(BASE_URL);
    }

    // проверка надписей услуги связи, домашний интернет, рассрочка, задолженность
    @Test(priority = 1)
    public void testFieldsValidation() {
        // список адресов
        List<String> url = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            url.add("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[" + (i + 1) + "]/p");
            System.out.println(url.get(i));
        }

        // список элементов
        List<WebElement> serviceOption = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            serviceOption.add(driver.findElement(By.xpath(url.get(i))));
        }

        // проверки
        Assert.assertEquals(serviceOption.get(0).getText(), "Услуги связи");
        Assert.assertEquals(serviceOption.get(1).getText(), "Домашний интернет");
        Assert.assertEquals(serviceOption.get(2).getText(), "Рассрочка");
        Assert.assertEquals(serviceOption.get(3).getText(), "Задолженность");
    }

    // проверка надписей в полях каждого варианта оплаты услуг:
    // услуги связи, домашний интернет, рассрочка, задолженность
    @Test(priority = 2)
    public void testFieldsValidationName() {
        // удаление заставки
        WebElement coocie = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]"));
        if (coocie.isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
        }
        // заполнение полей
        WebElement serviceField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        serviceField.click();

        // список адресов
        List<String> url = new ArrayList<>();
        int k = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                url.add("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[" + (i + 1) +
                        "]/div[" + (j + 1) + "]/input");
                System.out.println(url.get(k));
                k++;
            }
        }

        // список элементов
        List<WebElement> serviceOption = new ArrayList<>();
        k = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j < 3; j++) {
                serviceOption.add(driver.findElement(By
                        .xpath((url.get(k)))));
                k++;
            }
        }

        // проверки
        Assert.assertEquals(serviceOption.get(0).getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(serviceOption.get(1).getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(serviceOption.get(2).getAttribute("placeholder"), "E-mail для отправки чека");
        Assert.assertEquals(serviceOption.get(3).getAttribute("placeholder"), "Номер абонента");
        Assert.assertEquals(serviceOption.get(4).getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(serviceOption.get(5).getAttribute("placeholder"), "E-mail для отправки чека");
        Assert.assertEquals(serviceOption.get(6).getAttribute("placeholder"), "Номер счета на 44");
        Assert.assertEquals(serviceOption.get(7).getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(serviceOption.get(8).getAttribute("placeholder"), "E-mail для отправки чека");
        Assert.assertEquals(serviceOption.get(9).getAttribute("placeholder"), "Номер счета на 2073");
        Assert.assertEquals(serviceOption.get(10).getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(serviceOption.get(11).getAttribute("placeholder"), "E-mail для отправки чека");
    }

    // Заполнить поля и проверить работу кнопки Продолжить
    // проверяем только вариант «Услуги связи», номер для теста 297777777
    @Test(priority = 3)
    public void testContinueButton() {

        // удаление заставки
        WebElement coocie = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]"));
        if (coocie.isDisplayed()) {
            driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
        }

        // заполнение полей
        WebElement serviceField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        serviceField.sendKeys("Услуги связи");
        serviceField.click();
        WebElement numberField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[1]/input"));
        numberField.sendKeys("297777777");
        WebElement priceField =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[2]/input"));
        priceField.sendKeys("5");

        // проверка работы кнопки Продолжить
        WebElement continueButton =
                driver.findElement(By
                        .xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/button"));
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // переключение на фрейм
        driver.switchTo().frame(driver.findElement(By.xpath("//div/iframe")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement priceNew =
                driver.findElement(By
                        .xpath("//body/app-root/div/div/app-payment-container/app-header/header/div/div/p[1]"));
        WebElement phoneNew =
                driver.findElement(By
                        .xpath("//body/app-root/div/div/app-payment-container/app-header/header/div/div/p[2]"));
        WebElement cardName =
                driver.findElement(By
                        .xpath("//body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]"));
        WebElement termName =
                driver.findElement(By
                        .xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]"));
        WebElement cvcName =
                driver.findElement(By
                        .xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div"));
        WebElement nameName =
                driver.findElement(By
                        .xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]"));
        WebElement priceButton =
                driver.findElement(By
                        .xpath("//body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button/text()"));
        WebElement visaName =
                driver.findElement(By
                        .xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]"));
        WebElement mirName =
                driver.findElement(By
                        .xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]"));

        Assert.assertEquals(priceNew.getText().substring(0, 5).trim(), "5.00");
        Assert.assertEquals(phoneNew.getText().substring(phoneNew.getText().length() - 10).trim(), "297777777");
        Assert.assertEquals(cardName.getText().trim(), "Номер карты");
        Assert.assertEquals(termName.getText().trim(), "Срок действия");
        Assert.assertEquals(cvcName.getText().trim(), "CVC");
        Assert.assertEquals(nameName.getText().trim(), "Имя держателя (как на карте)");
        Assert.assertEquals(priceButton.getText().substring(priceButton.getText().length() - 9).trim(), "5.00 BYN");
        Assert.assertTrue(visaName.isDisplayed());
        Assert.assertTrue(mirName.isDisplayed());
    }

    // завершение
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
