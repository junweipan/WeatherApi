package com.junwei.weatherapis.model;

import javax.persistence.*;

@Entity
// The class name is table name in DB
@Table
public class Weather {
    //set id as primary key
    @Id
    //set id as column name
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //set country as column name
    @Column
    private String country;

    //set city as column name
    @Column
    private String city;

    //set description  as column name
    @Column
    private String description;

    //set api as column name
    @Column
    private String api;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
