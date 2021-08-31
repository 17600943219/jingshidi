package cn.itcast.seletest;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;


public class AppiumTest {

    private static AndroidDriver driver;
    @Test
    public void InitDriver() throws Exception{
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName","Android");
        des.setCapability("deviceName","SLY6R16A12001046");
        des.setCapability("platformVersion","7.0");
        des.setCapability("appPackage","com.baidu.searchbox");
        des.setCapability("appActivity",".MainActivity");
        //A new session could not be created的解决方法
//        des.setCapability("appWaitActivity",".MainActivity");
//        //每次启动时覆盖session，否则第二次后运行会报错不能新建session
//        des.setCapability("sessionOverride", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);



//        WebDriverWait wait =new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/search_box_text_1")));

//        driver.findElementById("com.baidu.searchbox:id/search_box_text_1").click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/SearchTextInput")));
//        driver.findElementById("com.baidu.searchbox:id/SearchTextInput").sendKeys("中国");
//        System.out.println(driver.);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.baidu.searchbox:id/float_search_or_cancel")));
//        driver.findElementById("com.baidu.searchbox:id/float_search_or_cancel").click();

//
      Thread.sleep(3000);
//        driver.quit();





    }


}
