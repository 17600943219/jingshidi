package cn.itcast.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Commonshare {

    public static WebDriver driver;

    public static void openFirefox() {
        System.setProperty("webdriver.firefox.bin", "D:\\Software\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "E:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void closeFirefox() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    public static void openUrl(String url) {
        driver.get(url);

    }


    public static WebElement locateElement(String type, String value) {
        WebElement element = null;

        if ("id".equals(type)) {
            element = driver.findElement(By.id(value));
        } else if ("name".equals(type)) {
            element = driver.findElement(By.name(value));
        } else if ("class".equals(type)) {
            element = driver.findElement(By.className(value));
        } else if ("tag".equals(type)) {
            element = driver.findElement(By.tagName(value));
        } else if ("text".equals(type)) {
            element = driver.findElement(By.linkText(value));
        } else if ("partialText".equals(type)) {
            element = driver.findElement(By.partialLinkText(value));
        } else if ("xpath".equals(type)) {
            element = driver.findElement(By.xpath(value));
        } else if ("css".equals(type)) {
            element = driver.findElement(By.cssSelector(value));
        }
        return element;

    }

    public static void click(String type, String value) {
        WebElement element = locateElement(type, value);
        element.click();

    }

    public static void inputData(String type, String value, String data) {
        WebElement element = locateElement(type, value);
        element.sendKeys(data);

    }

    public static String getText(String type, String value) {
        WebElement element = locateElement(type, value);
        String text = element.getText();
        return text;

    }


}
