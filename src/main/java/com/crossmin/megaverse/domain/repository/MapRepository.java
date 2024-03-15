package com.crossmin.megaverse.domain.repository;

import com.crossmin.megaverse.application.model.ActualMap;
import com.crossmin.megaverse.application.model.GoalMap;

public interface MapRepository {

    GoalMap findGoalMap();

    ActualMap findActualMap();

}
