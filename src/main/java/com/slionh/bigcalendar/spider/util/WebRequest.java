package com.slionh.bigcalendar.spider.util;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/*
 * Create by s lion h on 2018/9/26
 */
public class WebRequest {
    private static final String COOKIES="aliyungf_tc=AQAAACrTJl3zKwQA1QTFeNqKlW0lxN2N; xq_a_token=7443762eee8f6a162df9eef231aa080d60705b21; xq_a_token.sig=3dXmfOS3uyMy7b17jgoYQ4gPMMI; xq_r_token=9ca9ab04037f292f4d5b0683b20266c0133bd863; xq_r_token.sig=6hcU3ekqyYuzz6nNFrMGDWyt4aU; u=641530511490635; Hm_lvt_1db88642e346389874251b5a1eded6e3=1530511491; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1530511491; device_id=11a703c9a94f23cbea9347a70a00dd59";

    public static String getString(String url, CloseableHttpClient httpclient, String content) {
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("Cookie",COOKIES);
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    content=EntityUtils.toString(entity);
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }
}
