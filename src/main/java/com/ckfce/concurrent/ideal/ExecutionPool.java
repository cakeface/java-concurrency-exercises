package com.ckfce.concurrent.ideal;

import java.time.Duration;

/**
 * Each pool has a deadline for how long it can run. 
 */
public enum ExecutionPool {

    SECONDS(Duration.ofSeconds(2)), HOUR(Duration.ofHours(1)), WEEK(Duration.ofDays(7));

    private Duration timeLimit;

    ExecutionPool(Duration timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Duration getTimeLimit() {
        return timeLimit;
    }
}
