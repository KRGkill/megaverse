package com.crossmin.megaverse.infrastructure.outbound.external;

import com.crossmin.megaverse.domain.model.*;
import com.crossmin.megaverse.application.model.ActualMap;
import com.crossmin.megaverse.application.model.GoalMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${megaverse.client.name}", url = "${megaverse.url}")
public interface MegaverseAPIClient {

    @PostMapping("/polyanets")
    void createPolyanet(@RequestBody Polyanet polyanet);

    @DeleteMapping("/polyanets")
    void deletePolyanet(@RequestBody Polyanet polyanet);

    @PostMapping("/soloons")
    void createSoloon(@RequestBody Soloon soloon);

    @DeleteMapping("/soloons")
    void deleteSoloon(@RequestBody Soloon soloon);

    @PostMapping("/comeths")
    void createCometh(@RequestBody Cometh cometh);

    @DeleteMapping("/comeths")
    void deleteCometh(@RequestBody Cometh cometh);

    @GetMapping("/map/${megaverse.candidate.id}")
    ActualMap getActualMap();

    @GetMapping("/map/${megaverse.candidate.id}/goal")
    GoalMap getGoalMap();
}