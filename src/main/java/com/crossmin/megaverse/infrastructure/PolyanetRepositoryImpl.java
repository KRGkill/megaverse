package com.crossmin.megaverse.infrastructure;

import com.crossmin.megaverse.domain.model.Polyanet;
import com.crossmin.megaverse.domain.repository.PolyanetRepository;
import com.crossmin.megaverse.infrastructure.outbound.external.MegaverseAPIClient;
import com.crossmin.megaverse.infrastructure.utils.SleepAfterApiCall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PolyanetRepositoryImpl implements PolyanetRepository {

    private final MegaverseAPIClient megaverseAPIClient;

    @Override
    public void createPolyanet(Polyanet polyanet) {
        megaverseAPIClient.createPolyanet(polyanet);
        SleepAfterApiCall.sleepSeconds();
    }

    @Override
    public void deletePolyanet(Polyanet polyanet) {
        megaverseAPIClient.deletePolyanet(polyanet);
        SleepAfterApiCall.sleepSeconds();
    }
}