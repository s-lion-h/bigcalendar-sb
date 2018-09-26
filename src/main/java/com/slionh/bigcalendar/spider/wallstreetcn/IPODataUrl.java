package com.slionh.bigcalendar.spider.wallstreetcn;

/*
 * Create by s lion h on 2018/9/26
 */
public class IPODataUrl {
    private static final String START="https://api-prod.wallstreetcn.com/apiv1/finance/ipodatas?";
    private static final String BEGIN="start=";
    private static final String END="&end=";

    private String start;
    private String end;

    public IPODataUrl(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl(){
        return START+BEGIN+start+END+end;
    }

    public static String getUrl(String startStamp,String endStamp){
        return START+BEGIN+startStamp+END+endStamp;
    }

    @Override
    public String toString() {
        return "IPODataUrl{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
