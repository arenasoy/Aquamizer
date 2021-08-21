package com.app.aquamizer.models;

public class Tip {

    private String text;
    private CATEGORY category;

    public Tip (String text, CATEGORY category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CATEGORY getCategory() {
        return category;
    }

    public void setCategory(CATEGORY category) {
        this.category = category;
    }
}
