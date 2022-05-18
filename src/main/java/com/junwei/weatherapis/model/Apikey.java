package com.junwei.weatherapis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
// The class name is table name in DB
@Table
public class Apikey {
    //set id as primary key
    @Id
    //set id as column name
    @Column
    private int id;

    //set key as column name
    @Column
    private String apiKey;

    //set calltime as column name
    @Column
    private String lastCallTime;

    //set count as column name
    @Column
    private int callCount;

    //set realAPI as column name
    @Column
    private String realApi;

    public Apikey(int id, String apiKey, String lastCallTime, int callCount, String realApi) {
        this.id = id;
        this.apiKey = apiKey;
        this.lastCallTime = lastCallTime;
        this.callCount = callCount;
        this.realApi = realApi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(String lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    public String getRealApi() {
        return realApi;
    }

    public void setRealApi(String realApi) {
        this.realApi = realApi;
    }
}
