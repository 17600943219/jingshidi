package cn.itcast.seletest;

import cn.itcast.test.Commonshare;
import cn.itcast.test.Login;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class seleTest {
    public static Login log = new Login();

    @BeforeTest
    public void open(){
        Commonshare.openFirefox();
    }

    @AfterTest
    public void close() throws InterruptedException {
        Commonshare.closeFirefox();
    }

    @Test(priority = 1)
    public void loginTest(){
        log.login("15701266087", "keke0216");
    }

    @Test(priority = 0)
    public void loginTest1(){
        log.login("15701266087", "");
        String text = Commonshare.getText("id", "error_tips");
        Assert.assertEquals(text, "请输入密码");
    }
}
