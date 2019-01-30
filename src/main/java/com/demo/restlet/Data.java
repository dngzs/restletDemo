package com.demo.restlet;


import java.io.Serializable;

public class Data implements Serializable {

    private static final long serialVersionUID = -7038892607883821835L;
    private String name;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
