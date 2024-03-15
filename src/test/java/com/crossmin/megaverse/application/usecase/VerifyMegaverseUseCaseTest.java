package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.application.model.ActualMap;
import com.crossmin.megaverse.application.model.ContentObject;
import com.crossmin.megaverse.application.model.GoalMap;
import com.crossmin.megaverse.application.model.MapObject;
import com.crossmin.megaverse.domain.repository.MapRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VerifyMegaverseUseCaseTest {

    @Mock
    MapRepository mapRepository;

    @InjectMocks
    VerifyMegaverseUseCase verifyMegaverseUseCase;

    @Test
    public void verify_checkBothMapAreEquals() {
        List<String> rowGoal1 = List.of("SPACE");
        List<String> rowGoal2 = List.of("POLYANET");
        List<List<String>> rows = List.of(rowGoal1, rowGoal2);

        when(mapRepository.findGoalMap()).thenReturn(new GoalMap(rows));

        List<ContentObject> rowActual1 = new ArrayList<>();
        rowActual1.add(null);
        List<ContentObject> rowActual2 = List.of(new ContentObject(0));
        List<List<ContentObject>> content = List.of(rowActual1, rowActual2);

        when(mapRepository.findActualMap()).thenReturn(new ActualMap(new MapObject(content)));

        String result = verifyMegaverseUseCase.verify();
        Assertions.assertEquals("Actual and Goal Maps Match", result);
    }

    @Test
    public void verify_checkBothMapAreNotEquals() {
        List<String> rowGoal1 = List.of("SPACE");
        List<String> rowGoal2 = List.of("POLYANET");
        List<List<String>> rows = List.of(rowGoal1, rowGoal2);

        when(mapRepository.findGoalMap()).thenReturn(new GoalMap(rows));

        List<ContentObject> rowActual1 = List.of(new ContentObject(0));
        List<ContentObject> rowActual2 = List.of(new ContentObject(0));
        List<List<ContentObject>> content = List.of(rowActual1, rowActual2);

        when(mapRepository.findActualMap()).thenReturn(new ActualMap(new MapObject(content)));

        String result = verifyMegaverseUseCase.verify();
        Assertions.assertEquals("Actual and Goal Maps NOT Match", result);
    }
}