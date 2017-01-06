package com.ckfce.concurrent.ideal;

import java.util.List;

public interface Jobs {

    /**
     * Add the task type to the list of tasks available for submission.  This is separated
     * from job submission because it is. These task type objects include an object that can 
     * create runnables.  I think that I expected them to be more long lived so I wanted to 
     * separate them from job submission.
     */
    void registerTaskType(TaskType task);

    /*
     * What task types have been registered?  Here ya go!
     */
    List<TaskType> listRegisteredTaskTypes();

    TaskStatus submit(TaskInitConfig jobDef);

    void start();

    List<TaskStatus> allJobs();

    List<TaskStatus> jobsByTask(TaskType task);

    List<TaskStatus> stopAll();

    List<TaskStatus> stopByTask(TaskType task);
}
