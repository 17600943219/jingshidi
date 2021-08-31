package cn.itcast.seletest;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.security.Key;
import java.util.*;

public class DataTest {
    @Test
    public void yamlTest() throws Exception {
        Yaml yaml = new Yaml();
        Map<String,Map<String,Map<String,Integer>>>data = yaml.load(new FileInputStream("src/data.yaml"));
        System.out.println(JSON.toJSONString(data));
        System.out.println(data.get("baidu_search").get("search001").get("input"));
        System.out.println(data.get("baidu_search").keySet());
        Set<String> keys =data.get("baidu_search").keySet();
        ArrayList<Map<String, String>> dataList = new ArrayList<>();
        for (String key: keys) {
            Map<String, String> map = new HashMap<>();
            map.put("key",key);
            map.put("value",data.get("baidu_search").get(key).get("input").toString());
            dataList.add(map);
        }
        System.out.println(dataList);

    }
}
