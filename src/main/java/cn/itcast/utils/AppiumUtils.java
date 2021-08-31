package cn.itcast.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumUtils {


    public static void click(String type, String str, AndroidDriver driver) {

        findElement(type, str, driver).click();

    }

    public static void sendKey(String type, String str, AndroidDriver driver, String key) {

        findElement(type, str, driver).clear();
        findElement(type, str, driver).sendKeys(key);
    }


    public static WebElement findElement(String type, String str, AndroidDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        if ("id".equals(type)) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(str)));

        } else if ("className".equals(type)) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(str)));
        } else if ("xpath".equals(type)) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(str)));
        }
        return null;
    }

}
