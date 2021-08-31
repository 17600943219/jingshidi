package cn.itcast.seletest;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.connection.ConnectionState.*;
import static io.appium.java_client.android.connection.ConnectionState.AIRPLANE_MODE_MASK;


public class Jiangshabi {
    @Test
    public void appTest() throws Exception {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName","Android");
        des.setCapability("deviceName","SLY6R16A12001046");
        des.setCapability("platformVersion","7.0");
        des.setCapability("appPackage","com.android.settings");
        des.setCapability("appActivity",".Settings$WifiSettingsActivity");

        //A new session could not be created的解决方法
//        des.setCapability("appWaitActivity",".MainActivity");
//        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
//        des.setCapability("sessionOverride", true);
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
/*        driver.findElementById("com.baidu.searchbox:id/image_search_entrance").click();
        driver.closeApp();
        driver.startActivity("com.baidu.searchbox",".MainActivity");
       System.out.println(driver.isAppInstalled("com.baidu.searchbox"));
       System.out.println(driver.getPageSource());
       driver.findElementByAndroidUIAutomator();
        driver.findElementByXPath("//*[contains(@text,'奥运')]").click();
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));*/

//driver.findElementByClassName("android.widget.LinearLayout").click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
////        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/bottom_close_btn"))).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/search_box_text"))).click();
////
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/SearchTextInput"))).sendKeys("景师弟");
////        driver.findElementById("com.baidu.searchbox:id/SearchTextInput").sendKeys("景师弟");
////        driver.findElementById()
////        System.out.println(driver.getPageSource());
//        System.out.println(driver.findElementById("com.baidu.searchbox:id/SearchTextInput").getAttribute("checked"));
//        Point location = driver.findElementById("com.baidu.searchbox:id/SearchTextInput").getLocation();
//        System.out.println(driver.getCurrentPackage()+","+driver.currentActivity()
//                +"\n"+driver.manage().window().getSize()+"\n"+driver.getDeviceTime());
//
//
//        driver.runAppInBackground(Duration.ofSeconds(10));
////        new TouchAction<>();
//        driver.openNotifications();
//        ConnectionState connection = driver.getConnection();
//       System.out.println(connection.getBitMask());
//
//        driver.setConnection(new ConnectionState(6));
//        driver.pressKeyCode(3);
        int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;

        TouchAction action = new TouchAction(driver);

        PointOption option1= PointOption.point(width/2,height*4/5);
        PointOption option2= PointOption.point(width/2,height/5);
//        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        WaitOptions waitOptions =  WaitOptions.waitOptions(Duration.ofSeconds(10));
//        action.press(option1).waitAction(waitOptions).moveTo(option2).release().perform();
//        LongPressOptions optionL= LongPressOptions.longPressOptions().withPosition(PointOption.point(290,561)).withDuration(Duration.ofSeconds(10));
//       action.longPress(PointOption.point(290,561)).release().perform();
//        action.tap(TapOptions.tapOptions().withPosition(PointOption.point(290,561)).withTapsCount(1)).perform();
    action.tap(PointOption.point(290,561)).perform();
    WebDriverWait wait =new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1111")));
    }
}
