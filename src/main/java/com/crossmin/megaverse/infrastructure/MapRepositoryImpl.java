package com.crossmin.megaverse.infrastructure;

import com.crossmin.megaverse.application.model.ActualMap;
import com.crossmin.megaverse.application.model.GoalMap;
import com.crossmin.megaverse.domain.repository.MapRepository;
import com.crossmin.megaverse.infrastructure.outbound.external.MegaverseAPIClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MapRepositoryImpl implements MapRepository {

    private final MegaverseAPIClient megaverseAPIClient;

    @Override
    public GoalMap findGoalMap() {
        return megaverseAPIClient.getGoalMap();
    }

    @Override
    public ActualMap findActualMap() {
        return megaverseAPIClient.getActualMap();
    }
}