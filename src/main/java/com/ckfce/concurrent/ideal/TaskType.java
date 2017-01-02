package com.ckfce.concurrent.ideal;

import java.util.function.Function;

public class TaskType {

    private Function<TaskInitConfig, Runnable> instatiator;
    private String name;
    private ExecutionPool targetPool;
}
