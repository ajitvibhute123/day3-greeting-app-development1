package com.bz.greetingappdevelopment.controller;

public class Greeting {
    private long id;

    public String getContent() {
        return content;
    }
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }
}