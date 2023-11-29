package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/*
Необходимо написать автотесты для сайта mts.by.
Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
Проверить название указанного блока;Проверить наличие логотипов платёжных систем;
Проверить работу ссылки «Подробнее о сервисе»;
Заполнить поля и проверить работу кнопки «Продолжить»
(проверяем только вариант «Услуги связи», номер для теста 297777777)
*/
public class App {
    public static void main(String[] args) {

        WebDriver webDriver = new SafariDriver();
        webDriver.get("https://mts.by");
    }
}
