package com.example.aidemo;


import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class correct_Sample {
    //设置APPID/AK/SK


    public static void main(String[] args) {
        String APP_ID = "57523202";
        String API_KEY = "9YIiXAMgLe335texst583dtc";
        String SECRET_KEY = "p0sqdioqMEEyTRJUXKT40OyJpVO7fOij";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        String word = "我今天完游戏一直嬴";
        /*
            我今天玩游戏一直赢
        */
        JSONObject res = client.ecnet(word, null);
        System.out.println(res.toString(2));

    }
}