package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.application.model.GoalMap;
import com.crossmin.megaverse.domain.repository.ComethRepository;
import com.crossmin.megaverse.domain.repository.MapRepository;
import com.crossmin.megaverse.domain.repository.PolyanetRepository;
import com.crossmin.megaverse.domain.repository.SoloonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildMegaverseUseCaseTest {

    private final String SPACE = "SPACE";

    @Mock
    MapRepository mapRepository;

    @Mock
    PolyanetRepository polyanetRepository;

    @Mock
    SoloonRepository soloonRepository;

    @Mock
    ComethRepository comethRepository;

    @InjectMocks
    BuildMegaverseUseCase buildMegaverseUseCase;

    @Test
    public void build_checkResult() {
        List<String> row1 = List.of(SPACE, SPACE);
        List<String> row2 = List.of(SPACE, "POLYANET");
        List<List<String>> rows = List.of(row1, row2);

        when(mapRepository.findGoalMap()).thenReturn(new GoalMap(rows));

        buildMegaverseUseCase.build();
        verify(polyanetRepository, times(1)).createPolyanet(any());
        verify(soloonRepository, times(0)).createSoloon(any());
        verify(comethRepository, times(0)).createCometh(any());
    }
}
