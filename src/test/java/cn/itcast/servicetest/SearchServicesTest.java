package cn.itcast.servicetest;

import cn.itcast.utils.AppiumUtils;
import com.alibaba.fastjson.JSON;
import io.appium.java_client.android.AndroidDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.*;

public class SearchServicesTest {

    public void search(AndroidDriver driver, String key) throws Exception{
        AppiumUtils.click(CommonData.searchbox2_type, CommonData.searchbox2_str, driver);
        AppiumUtils.sendKey(CommonData.searchbox2_type, CommonData.searchbox2_str, driver, key);
       AppiumUtils.click(CommonData.button_type, CommonData.button_str, driver);
    }

    public List<Map<String, String>> readYaml() throws Exception {
        Yaml yaml = new Yaml();
        Map<String,Map<String, Map<String,Integer>>>data = yaml.load(new FileInputStream("src/data.yaml"));
        System.out.println(JSON.toJSONString(data));
        System.out.println(data.get("baidu_search").get("search001").get("input"));
        System.out.println(data.get("baidu_search").keySet());
        Set<String> keys =data.get("baidu_search").keySet();
        List<Map<String, String>> dataList = new ArrayList<>();
        for (String key: keys) {
            Map<String, String> map = new HashMap<>();
            map.put("key",key);
            map.put("value",data.get("baidu_search").get(key).get("input").toString());
            dataList.add(map);
        }

        return dataList;

    }

  @DataProvider
    public Object[][] getDataMethod() throws Exception {
        List<Map<String, String>> list = readYaml();
        Object[][] datas = new Object[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            datas[i]=new Object[]{list.get(i)};
        }
        System.out.println(JSON.toJSONString(datas));
    return datas;
}

    public static void readXml(Element node) throws Exception {
        System.out.println(node.getName());
        Iterator<Element> elements=node.elementIterator();
        while (elements.hasNext()){
            Element element=elements.next();
            readXml(element);
        }

    }


    public static void main(String[] args) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/search.xml");
        Element node = document.getRootElement();
        readXml(node);
        Element ele1=node.element("searchbox1");
        System.out.println(ele1.attribute("type").getText());


    }
}
