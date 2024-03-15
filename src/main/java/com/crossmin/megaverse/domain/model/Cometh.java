package com.crossmin.megaverse.domain.model;

import lombok.Getter;

@Getter
public class Cometh extends AstralObject {
    String direction;

    public Cometh(int row, int column, String direction) {
        super(row, column);
        this.direction = direction;
    }

    public Cometh(int row, int column) {
        super(row, column);
    }
}
