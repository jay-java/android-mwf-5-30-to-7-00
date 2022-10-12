package com.example.recyclerview_cardview;

public class Model {
    private String name;
    private String chat;
    private int img;

    public Model() {
    }

    public Model(String name, String chat, int img) {
        this.name = name;
        this.chat = chat;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
