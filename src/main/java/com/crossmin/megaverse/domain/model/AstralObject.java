package com.crossmin.megaverse.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@AllArgsConstructor
public abstract class AstralObject {
    @Value("${megaverse.candidate.id:5921dea1-8893-4be1-a8ee-b8373e2cedee}")
    private String candidateId = "5921dea1-8893-4be1-a8ee-b8373e2cedee";
    private int row;
    private int column;

    protected AstralObject(int row, int column) {
        this.row = row;
        this.column = column;
        this.candidateId = getCandidateId();
    }
}
