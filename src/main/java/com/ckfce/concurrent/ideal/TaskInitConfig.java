package com.ckfce.concurrent.ideal;

import java.util.Map;

/**
 * This is passed into a TaskType to initialize an instance of the task to run. I'm
 * using a fairly generic class type here with key value configs so that we can log
 * and store the initialization parameters.  This makes jobs more portable and helps 
 * with restarting.
 */
public class TaskInitConfig {

    private String taskTypeName;
    private Map<String, String> config;

}
