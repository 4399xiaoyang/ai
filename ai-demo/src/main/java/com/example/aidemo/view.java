package com.example.aidemo;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;

public class view {
    public static String img(MultipartFile file) throws IOException {
        String APP_ID = "57521110";
        String API_KEY = "PKfDEfHCJ0re9iAz3NcZzRK2";
        String SECRET_KEY = "AfHAAWlvm5vDq6WUWSfnQ5CP8yLVc2VR";


        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        JSONObject result = res.getJSONArray("result").getJSONObject(0);

        String s = "这张图" + result.getDouble("score")*100 + "%的可能是" + result.getString("root") + "-" +result.getString("keyword");
        return s;
    }
    public static String correct(String word)
    {
        String APP_ID = "57523202";
        String API_KEY = "9YIiXAMgLe335texst583dtc";
        String SECRET_KEY = "p0sqdioqMEEyTRJUXKT40OyJpVO7fOij";

        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        JSONObject res = client.ecnet(word, null);
        String res1 = res.getJSONObject("item").getString("correct_query");
        return res1;
    }
    public static String text(MultipartFile file) throws IOException
    {
        String APP_ID = "57519446";
        String API_KEY = "X0nZqHEEFXMiiM2IUhNPU1TL";
        String SECRET_KEY = "E8cQTJfFs5U3pZ2kDVHdyNfr44SQyAJh";

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        System.out.println(res.toString(2));
        return res.toString(2);
    }

    public static void main(String[] args) {
        String word="我今天完游戏一直嬴";
        System.out.println(correct(word));
    }
}
