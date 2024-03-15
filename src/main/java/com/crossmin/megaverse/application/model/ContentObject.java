package com.crossmin.megaverse.application.model;

import lombok.Getter;

@Getter
public class ContentObject {
    int type;
    String color;
    String direction;

    public ContentObject(int type){
        this.type = type;
    }
}
