package com.example.application3a;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Players {

//Give the field a custom name//

    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("web_pages")
    private List<String> urlList;
    private String url;

    @SerializedName("domains")
    private List<String> domainsList;

    public Players(String name, String country, List<String> urlList, List<String> domainsList) {
        this.name = name;
        this.country = country;
        this.urlList = urlList;
        this.domainsList = domainsList;
    }



//Retrieve the data using setter/getter methods//

    public String getUser() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getURLList() {
        return urlList;
    }

    public List<String> getDomainsList() {
        return domainsList;
    }
    public String getURL() {
        return url;
    }

    public void setUser(String name) {
        this.name = name;
    }

}