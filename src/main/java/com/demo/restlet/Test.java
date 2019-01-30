package com.demo.restlet;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test2();
                    test1();

                }
            }).start();

        }
    }

    private static void test1() {
        String postUrl = "http://localhost:8080/rest/v1/test1";

        Map<String, String> params = new HashMap();
        params.put("name", "0");
        params.put("data", "10");
        List<NameValuePair> nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("seq", JSONObject.toJSONString(params)));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8);
        HttpClentUtil.httpPost(postUrl, urlEncodedFormEntity);
    }

    private static void test2() {
        String postUrl = "http://localhost:8080/rest/v2/test2";

        Map<String, String> params = new HashMap();
        params.put("name", "error");
        params.put("data", "20");
        List<NameValuePair> nvps = new ArrayList();
        nvps.add(new BasicNameValuePair("seq", JSONObject.toJSONString(params)));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8);
        HttpClentUtil.httpPost(postUrl, urlEncodedFormEntity);
    }



}
