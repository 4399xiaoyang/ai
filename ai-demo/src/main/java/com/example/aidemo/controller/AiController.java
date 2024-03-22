package com.example.aidemo.controller;

import com.example.aidemo.view;
import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class AiController {
    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String img(@RequestParam("file") MultipartFile file) throws IOException {
        return view.img(file);
    }

    @RequestMapping(value = "/text",method = RequestMethod.POST)
    public String text(@RequestParam("file") MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "57519446";
        String API_KEY = "X0nZqHEEFXMiiM2IUhNPU1TL";
        String SECRET_KEY = "E8cQTJfFs5U3pZ2kDVHdyNfr44SQyAJh";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            sb.append(jsonArray.getJSONObject(i).getString("words"))
                    .append("\n");
        }
        return sb.toString();
    }

    @RequestMapping(value ="/correct",method = RequestMethod.GET)
    public String correct(@RequestParam("word") String word){
        return view.correct(word);
    }
}
