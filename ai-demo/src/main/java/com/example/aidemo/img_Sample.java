package com.example.aidemo;


import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class img_Sample {
    //设置APPID/AK/SK


    public static void main(String[] args) {
        String APP_ID = "57521110";
        String API_KEY = "PKfDEfHCJ0re9iAz3NcZzRK2";
        String SECRET_KEY = "AfHAAWlvm5vDq6WUWSfnQ5CP8yLVc2VR";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        String path = "E:\\ai\\cat.png";
        /*
            {
                "score": 0.859457,
                "root": "动物-猫",
                "keyword": "猫"
            },
            {
                "score": 0.678857,
                "root": "动物-猫",
                "keyword": "狮子猫"
            },
            {
                 "score": 0.441387,
                 "root": "动物-猫",
                 "keyword": "挪威森林猫"
            },
            {
                 "score": 0.25122,
                 "root": "商品-玩具",
                 "keyword": "玩具"
            },
            {
                "score": 0.048077,
                "root": "动物-狗",
                "keyword": "小狗"
            }
         */
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }

}