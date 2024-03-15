package com.crossmin.megaverse.domain.model;

import lombok.Getter;

@Getter
public class Soloon extends AstralObject {
    String color;

    public Soloon(int row, int column, String color) {
        super(row, column);
        this.color = color;
    }

    public Soloon(int row, int column) {
        super(row, column);
    }
}
