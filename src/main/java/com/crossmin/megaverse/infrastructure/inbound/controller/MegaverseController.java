package com.crossmin.megaverse.infrastructure.inbound.controller;

import com.crossmin.megaverse.application.usecase.BuildMegaverseUseCase;
import com.crossmin.megaverse.application.usecase.ResetMegaverseUseCase;
import com.crossmin.megaverse.application.usecase.VerifyMegaverseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/megaverse")
@RequiredArgsConstructor
public class MegaverseController {

    private final BuildMegaverseUseCase buildMegaverseUseCase;
    private final ResetMegaverseUseCase resetMegaverseUseCase;
    private final VerifyMegaverseUseCase verifyMegaverseUseCase;

    @PostMapping("/build")
    public ResponseEntity<String> buildMegaverse() {
        this.buildMegaverseUseCase.build();
        return ResponseEntity.ok("Goal Map Built");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetMegaverse() {
        this.resetMegaverseUseCase.reset();
        return ResponseEntity.ok("Actual Map Reset");
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyMegaverse() {
        return ResponseEntity.ok(this.verifyMegaverseUseCase.verify());
    }
}