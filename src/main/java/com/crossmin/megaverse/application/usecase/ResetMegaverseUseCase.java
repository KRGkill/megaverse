package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.application.model.ContentObject;
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
public class ResetMegaverseUseCase {

    private final MapRepository mapRepository;
    private final PolyanetRepository polyanetRepository;
    private final SoloonRepository soloonRepository;
    private final ComethRepository comethRepository;

    public void reset() {
        List<List<ContentObject>> actualMap = this.mapRepository.findActualMap().getMap().getContent();
        IntStream.range(0, actualMap.size())
                .forEach(row -> {
                    List<ContentObject> columns = actualMap.get(row);
                    IntStream.range(0, columns.size())
                            .forEach(column -> deleteAstralObject(columns.get(column), row, column));
                });
    }

    private void deleteAstralObject(ContentObject astralObject, int row, int column) {
        if (astralObject == null) return;
        if (astralObject.getType() == 0) {
            polyanetRepository.deletePolyanet(new Polyanet(row, column));
        } else if (astralObject.getType() == 2) {
            comethRepository.deleteCometh(new Cometh(row, column));
        } else if (astralObject.getType() == 1) {
            soloonRepository.deleteSoloon(new Soloon(row, column));
        }
    }
}