package com.demo.restlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClentUtil {


    /**
     * httpPost
     * @param url  路径
     * @param urlEncodedFormEntity 参数
     * @return
     */
    public static Object httpPost (String url,UrlEncodedFormEntity urlEncodedFormEntity) {

        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpResponse httpResponse =null;

        // 请求地址
        HttpPost httpPost = new HttpPost(url);

        try {
            httpPost.setEntity(urlEncodedFormEntity);
            //post请求
            httpResponse = closeableHttpClient.execute(httpPost);
            //getEntity()
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                //打印响应内容
                System.out.println("response:" + EntityUtils.toString(httpEntity, "UTF-8"));

                return httpEntity;
            }
            //释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * httpGet
     * @param url  路径
     * @return
     */
    public static Object httpGet(String url) {
        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet(url);
        System.out.println(httpGet.getRequestLine());
        try {
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            //响应状态
            System.out.println("status:" + httpResponse.getStatusLine());
            //判断响应实体是否为空
            if (entity != null) {
                System.out.println("contentEncoding:" + entity.getContentEncoding());
                System.out.println("response content:" + EntityUtils.toString(entity));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}