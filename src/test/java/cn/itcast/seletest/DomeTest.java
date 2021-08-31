package cn.itcast.seletest;

import cn.itcast.servicetest.CommonData;
import cn.itcast.servicetest.SearchServicesTest;
import cn.itcast.utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.Map;

public class DomeTest extends SearchServicesTest {
    private static AndroidDriver driver;

    @BeforeClass
    public void initDriver() throws Exception {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "Android");
        des.setCapability("deviceName", "SLY6R16A12001046");
        des.setCapability("platformVersion", "7.0");
        des.setCapability("appPackage", "com.baidu.searchbox");
        des.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
        AppiumUtils.click(CommonData.searchbox1_type, CommonData.searchbox1_str, driver);
    }

    @Description("报读搜索")
    @Step("慢慢搜索")
    @Attachment(value = "Page screenshot", type = "png")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "getDataMethod")
    public void dome1(Map<String, String> data) throws Exception {
        SearchServicesTest services = new SearchServicesTest();
        services.search(driver, data.get("value"));
        Thread.sleep(4000);
        driver.getScreenshotAs(OutputType.FILE);
//        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
//        return screenshot;
        FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("./"+data.get("value")+".jpg"));


    }


}
