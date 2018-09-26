package com.slionh.bigcalendar.spider.wallstreetcn;

import com.slionh.bigcalendar.spider.util.WebRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2018/9/26
 * @Param start end时间戳，秒级
 * @Return List<IPOData> 这段时间的ipo信息
 */
public class IPODataUtil {
    public static List<IPOData> getTimeIPO(String start,String end) {
        String url=IPODataUrl.getUrl(start,end);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String content="";
        content = WebRequest.getString(url, httpclient, content);
        System.out.println(content);


        JSONObject response=new JSONObject(content);
//        System.out.println(response);
        JSONArray ipos = response.getJSONObject("data").getJSONArray("items");
        int num=ipos.length();
        List<IPOData> ipoList=new ArrayList<IPOData>();
        for (int i=0;i<num;i++){
            JSONObject ipo=ipos.getJSONObject(i);
            IPOData ipoObject=new IPOData(ipo.getInt("id"),ipo.getString("code"),ipo.getString("company_name"),ipo.getString("country"),ipo.getString("flag_uri"));
            ipoList.add(ipoObject);
        }

//        System.out.println(ipoList);
        for (IPOData ipo:ipoList){
            System.out.println(ipo.toString());
        }

        return ipoList;

    }
}
