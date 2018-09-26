package com.slionh.bigcalendar.spider.wallstreetcn;

/*
 * Create by s lion h on 2018/9/26
 */
public class IPOData {
    private int id;
    private String code;
    private String company_name;
    private String country;
    private String flag_uri;

    public IPOData(int id, String code, String company_name, String country, String flag_uri) {
        this.id = id;
        this.code = code;
        this.company_name = company_name;
        this.country = country;
        this.flag_uri = flag_uri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag_uri() {
        return flag_uri;
    }

    public void setFlag_uri(String flag_uri) {
        this.flag_uri = flag_uri;
    }

    @Override
    public String toString() {
        return "IPOData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", company_name='" + company_name + '\'' +
                ", country='" + country + '\'' +
                ", flag_uri='" + flag_uri + '\'' +
                '}';
    }
}
