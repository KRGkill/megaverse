package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.application.model.ContentObject;
import com.crossmin.megaverse.domain.model.Cometh;
import com.crossmin.megaverse.domain.model.Polyanet;
import com.crossmin.megaverse.domain.model.Soloon;
import com.crossmin.megaverse.domain.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class VerifyMegaverseUseCase {

    private static final String SPACE = "SPACE";
    private final MapRepository mapRepository;

    public String verify() {
        List<List<String>> goalMap = this.mapRepository.findGoalMap().getGoal();
        List<List<ContentObject>> actualMap = this.mapRepository.findActualMap().getMap().getContent();
        boolean allMatch = IntStream.range(0, goalMap.size())
                .allMatch(row -> {
                    List<String> columns = goalMap.get(row);
                    return IntStream.range(0, columns.size())
                            .allMatch(column -> verifyMapValue(actualMap.get(row).get(column), columns.get(column)));
                });
        return allMatch ? "Actual and Goal Maps Match" : "Actual and Goal Maps NOT Match";
    }

    private boolean verifyMapValue(ContentObject actualValue, String goalValue) {
        if (actualValue == null) return goalValue.equals(SPACE);

        String[] astral = goalValue.toLowerCase().split("_");
        return switch (actualValue.getType()) {
            case 0 -> astral[0].equalsIgnoreCase(Polyanet.class.getSimpleName());
            case 1 -> astral[1].equalsIgnoreCase(Soloon.class.getSimpleName());
            case 2 -> astral[1].equalsIgnoreCase(Cometh.class.getSimpleName());
            default -> false;
        };
    }
}