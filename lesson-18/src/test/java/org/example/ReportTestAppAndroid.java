package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ReportTestAppAndroid {
    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    public void initialise() {

        // настройка
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone64_x86_64");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "jp.Appsys.PanecalST");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "jp.Appsys.PanecalST.MainActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkCalculate() {
        // элементы математических действий
        AndroidElement multiplication = driver.findElementById("jp.Appsys.PanecalST:id/buttonMultiply");
        AndroidElement division = driver.findElementById("jp.Appsys.PanecalST:id/buttonDivide");
        AndroidElement subtraction = driver.findElementById("jp.Appsys.PanecalST:id/buttonSubtract");
        AndroidElement addition = driver.findElementById("jp.Appsys.PanecalST:id/buttonPlus");
        AndroidElement equal = driver.findElementById("jp.Appsys.PanecalST:id/buttonEqual");
        AndroidElement display = driver.findElementById("jp.Appsys.PanecalST:id/display");
        AndroidElement clear = driver.findElementById("jp.Appsys.PanecalST:id/buttonAC");

        // список кнопок
        List<AndroidElement> webElements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            webElements.add(driver.findElementById("jp.Appsys.PanecalST:id/button" + (i + 1)));
        }

        // умножение
        webElements.get(0).click();
        webElements.get(1).click();
        multiplication.click();
        webElements.get(2).click();
        webElements.get(3).click();
        equal.click();
        Assert.assertEquals("408", display.getText().trim().substring(display.getText().length() - 4));
        System.out.println(driver.findElementById("jp.Appsys.PanecalST:id/display").getText());
        clear.click();

        // сложение
        webElements.get(0).click();
        webElements.get(1).click();
        addition.click();
        webElements.get(2).click();
        webElements.get(3).click();
        equal.click();
        Assert.assertEquals("46", display.getText().trim().substring(display.getText().length() - 3));
        System.out.println(driver.findElementById("jp.Appsys.PanecalST:id/display").getText());
        clear.click();

        // вычитание
        webElements.get(8).click();
        webElements.get(7).click();
        subtraction.click();
        webElements.get(6).click();
        webElements.get(5).click();
        equal.click();
        Assert.assertEquals("22", display.getText().trim().substring(display.getText().length() - 3));
        System.out.println(driver.findElementById("jp.Appsys.PanecalST:id/display").getText());
        clear.click();

        // деление
        webElements.get(7).click();
        webElements.get(3).click();
        division.click();
        webElements.get(1).click();
        equal.click();
        Assert.assertEquals("42", display.getText().trim().substring(display.getText().length() - 3));
        System.out.println(driver.findElementById("jp.Appsys.PanecalST:id/display").getText());
        clear.click();
    }

    @AfterTest
    public void tearDown() {
        // закрытие двайвера после тестов
        if (driver != null) {
            driver.quit();
        }
    }
}
