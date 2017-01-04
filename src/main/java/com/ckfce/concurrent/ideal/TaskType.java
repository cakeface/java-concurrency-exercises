package com.ckfce.concurrent.ideal;

import java.util.function.Function;

public class TaskType {

    private final Function<TaskInitConfig, Runnable> instatiator;
    private final String name;
    private final ExecutionPool targetPool;

    public TaskType(Function<TaskInitConfig, Runnable> instatiator, String name, ExecutionPool targetPool) {
        super();
        this.instatiator = instatiator;
        this.name = name;
        this.targetPool = targetPool;
    }

    public Function<TaskInitConfig, Runnable> getInstatiator() {
        return instatiator;
    }

    public String getName() {
        return name;
    }

    public ExecutionPool getTargetPool() {
        return targetPool;
    }

    @Override
    public String toString() {
        return "TaskType [instatiator=" + instatiator + ", name=" + name + ", targetPool=" + targetPool + "]";
    }
}
