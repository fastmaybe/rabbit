package com.rabbit.demo.pojo;

import java.io.Serializable;

public class RabbitParams implements Serializable {

    private String content;

    private String phone;

    private String name;

    public RabbitParams() {
        this.content = content;
        this.phone = phone;
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RabbitParams{" +
                "content='" + content + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
