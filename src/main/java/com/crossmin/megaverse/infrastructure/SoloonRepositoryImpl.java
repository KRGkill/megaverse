package com.crossmin.megaverse.infrastructure;

import com.crossmin.megaverse.domain.model.Soloon;
import com.crossmin.megaverse.domain.repository.SoloonRepository;
import com.crossmin.megaverse.infrastructure.outbound.external.MegaverseAPIClient;
import com.crossmin.megaverse.infrastructure.utils.SleepAfterApiCall;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SoloonRepositoryImpl implements SoloonRepository {

    private final MegaverseAPIClient megaverseAPIClient;

    @Override
    public void createSoloon(Soloon soloon) {
        megaverseAPIClient.createSoloon(soloon);
        SleepAfterApiCall.sleepSeconds();
    }

    @Override
    public void deleteSoloon(Soloon soloon) {
        megaverseAPIClient.deleteSoloon(soloon);
        SleepAfterApiCall.sleepSeconds();
    }
}