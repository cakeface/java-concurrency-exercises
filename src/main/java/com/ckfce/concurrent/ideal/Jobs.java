package com.ckfce.concurrent.ideal;

import java.util.List;

public interface Jobs {

    void registerTaskType(TaskType task);

    TaskStatus submit(TaskInitConfig jobDef);

    void start();

    List<TaskStatus> allJobs();

    List<TaskStatus> jobsByTask(TaskType task);

    List<TaskStatus> stopAll();

    List<TaskStatus> stopByTask(TaskType task);
}
