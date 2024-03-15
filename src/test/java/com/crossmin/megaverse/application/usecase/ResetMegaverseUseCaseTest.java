package com.crossmin.megaverse.application.usecase;

import com.crossmin.megaverse.application.model.ActualMap;
import com.crossmin.megaverse.application.model.ContentObject;
import com.crossmin.megaverse.application.model.MapObject;
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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResetMegaverseUseCaseTest {

    @Mock
    MapRepository mapRepository;

    @Mock
    PolyanetRepository polyanetRepository;

    @Mock
    SoloonRepository soloonRepository;

    @Mock
    ComethRepository comethRepository;

    @InjectMocks
    ResetMegaverseUseCase resetMegaverseUseCase;

    @Test
    public void reset_checkResult() {
        List<ContentObject> row1 = new ArrayList<>();
        row1.add(null);
        List<ContentObject> row2 = List.of(new ContentObject(0));
        List<List<ContentObject>> content = List.of(row1, row2);

        when(mapRepository.findActualMap()).thenReturn(new ActualMap(new MapObject(content)));

        resetMegaverseUseCase.reset();
        verify(polyanetRepository, times(1)).deletePolyanet(any());
        verify(soloonRepository, times(0)).deleteSoloon(any());
        verify(comethRepository, times(0)).deleteCometh(any());
    }
}
