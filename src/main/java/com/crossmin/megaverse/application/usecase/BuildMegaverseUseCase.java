package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.domain.model.Cometh;
import com.crossmin.megaverse.domain.model.Polyanet;
import com.crossmin.megaverse.domain.model.Soloon;
import com.crossmin.megaverse.domain.repository.ComethRepository;
import com.crossmin.megaverse.domain.repository.MapRepository;
import com.crossmin.megaverse.domain.repository.PolyanetRepository;
import com.crossmin.megaverse.domain.repository.SoloonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class BuildMegaverseUseCase {

    private static final String SPACE = "SPACE";
    private final MapRepository mapRepository;
    private final PolyanetRepository polyanetRepository;
    private final SoloonRepository soloonRepository;
    private final ComethRepository comethRepository;

    public void build() {
        List<List<String>> goalMap = this.mapRepository.findGoalMap().getGoal();
        IntStream.range(0, goalMap.size())
                .forEach(row -> {
                    List<String> columns = goalMap.get(row);
                    IntStream.range(0, columns.size())
                            .forEach(column -> createAstralObject(columns.get(column), row, column));
                });
    }

    private void createAstralObject(String astralObject, int row, int column) {
        if (astralObject.equals(SPACE)) return;
        String[] astral = astralObject.toLowerCase().split("_");
        if (astral[0].equalsIgnoreCase(Polyanet.class.getSimpleName())) {
            polyanetRepository.createPolyanet(new Polyanet(row, column));
        } else if (astral[1].equalsIgnoreCase(Cometh.class.getSimpleName())) {
            comethRepository.createCometh(new Cometh(row, column, astral[0]));
        } else if (astral[1].equalsIgnoreCase(Soloon.class.getSimpleName())) {
            soloonRepository.createSoloon(new Soloon(row, column, astral[0]));
        }
    }
}