package com.example.aidemo;


import java.util.*;
import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;
public class text_Sample {
    //设置APPID/AK/SK


    public static void main(String[] args) {
        String APP_ID = "57519446";
        String API_KEY = "X0nZqHEEFXMiiM2IUhNPU1TL";
        String SECRET_KEY = "E8cQTJfFs5U3pZ2kDVHdyNfr44SQyAJh";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        String path = "E:\\ai\\resou.png";
        /*
            {"words": "百度热搜〉"},
            {"words": ")换一换"},
            {"words": "不心连百姓情系人民"},
            {"words": "1除夕三件套热"},
            {"words": "200后真的没有人情世故"},
            {"words": "热"},
            {"words": "32023这一刻"},
            {"words": "4哈尔滨今冬\u201c第一座待爆城市\u201d"},
            {"words": "热"},
            {"words": "5抗癌宝贝毅玲去世"},
            {"words": "6奢侈品行业进入寒冬"},
            {"words": "7文心一言用户规模破1亿"},
            {"words": "8"},
            {"words": "贴身衣物穿黑色更容易得癌症？"},
            {"words": "9韩后创始人：我欠一空姐1500万"}
         */
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}