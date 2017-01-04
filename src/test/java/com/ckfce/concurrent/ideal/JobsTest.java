package com.ckfce.concurrent.ideal;

import static org.mockito.Mockito.*;

import org.junit.Test;

public class JobsTest {

    @Test
    public void testTaskTypeCreation() {
        TaskType tt = new TaskType(
                (TaskInitConfig c) -> mock(Runnable.class), "mockTT", ExecutionPool.SECONDS);

        //Jobs jobs = new JobsImpl();
    }

}
