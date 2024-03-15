package com.crossmin.megaverse.infrastructure.utils;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class SleepAfterApiCall {

    public static void sleepSeconds() {
        sleepSeconds(1);
    }

    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
