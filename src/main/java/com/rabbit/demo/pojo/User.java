package com.rabbit.demo.pojo;

public class User {
     private  int id;
     private String name;
     private  String location ;
     private Boolean man;

    public Boolean getMan() {
        return man;
    }

    public void setMan(Boolean man) {
        this.man = man;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
