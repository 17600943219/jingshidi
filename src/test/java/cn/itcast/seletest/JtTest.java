package cn.itcast.seletest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class JtTest {
    @BeforeTest
    @Parameters("aaa")
    public void setUp(String aaa) {
        System.out.println("setup");
        System.out.println(aaa);
    }

    @AfterTest
    public void tearDown() {
        System.out.println("tearDown");

    }

    @Test(priority = 2)
    public void test01() {
        if(2>1){
//            throw new SkipException("2大于一，跳过");
            assert false:"2大于一，跳过";
    }
        System.out.println("test01");
//    assertEquals(1,2);
    }

    @Test(priority = 4)
    public void test02() {
        System.out.println("test02");
    }

    @Test(priority = 3)
    public void test03() {
        System.out.println("test03");
    }

    @Test(priority = 1)
    public void test04() {
        System.out.println("test04");
    }

}
