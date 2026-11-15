package com.example.ntl;
public class ChatMessage {

    private String name;
    private String message;
    private String date;
    private int image;

    public ChatMessage(String name, String message, String date, int image) {
        this.name = name;
        this.message = message;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }
}