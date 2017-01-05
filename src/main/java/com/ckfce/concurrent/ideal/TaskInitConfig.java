package com.ckfce.concurrent.ideal;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

/**
 * This is passed into a TaskType to initialize an instance of the task to run. I'm
 * using a fairly generic class type here with key value configs so that we can log
 * and store the initialization parameters.  This makes jobs more portable and helps 
 * with restarting.
 */
public class TaskInitConfig {

    private final String taskTypeName;
    private final ImmutableMap<String, String> config;

    public TaskInitConfig(String taskTypeName, Map<String, String> config) {
        super();
        this.taskTypeName = taskTypeName;
        // blah blah null checks
        this.config = ImmutableMap.copyOf(config);
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public ImmutableMap<String, String> getConfig() {
        return config;
    }


}
