package com.crossmin.megaverse.infrastructure;

import com.crossmin.megaverse.domain.model.Cometh;
import com.crossmin.megaverse.domain.repository.ComethRepository;
import com.crossmin.megaverse.infrastructure.outbound.external.MegaverseAPIClient;
import com.crossmin.megaverse.infrastructure.utils.SleepAfterApiCall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ComethRepositoryImpl implements ComethRepository {

    private final MegaverseAPIClient megaverseAPIClient;

    @Override
    public void createCometh(Cometh cometh) {
        megaverseAPIClient.createCometh(cometh);
        SleepAfterApiCall.sleepSeconds();
    }

    @Override
    public void deleteCometh(Cometh cometh) {
        megaverseAPIClient.deleteCometh(cometh);
        SleepAfterApiCall.sleepSeconds();
    }
}