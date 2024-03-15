package com.crossmin.megaverse.application.model;

import lombok.Getter;

import java.util.List;

@Getter
public class MapObject {
    List<List<ContentObject>> content;
    int phase;
    String candidateId;

    public MapObject(List<List<ContentObject>> content) {
        this.content = content;
    }
}
