package com.ckfce.concurrent.ideal;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;

/**
 * This needs to be thread safe. 
 */
public class JobsImpl implements Jobs {

    ConcurrentMap<String, TaskType> taskTypes = Maps.newConcurrentMap();

    @Override
    public void registerTaskType(TaskType task) {
        taskTypes.put(task.getName(), task);
    }

    @Override
    public List<TaskType> listRegisteredTaskTypes() {
        // Is this even Java anymore!  Right?  I know. 
        return taskTypes
                .entrySet()
                .stream()
                .map(e -> e.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public TaskStatus submit(TaskInitConfig jobDef) {
        // Produce a task here for the workers.
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void start() {
        // 
        // TODO Auto-generated method stub

    }

    @Override
    public List<TaskStatus> allJobs() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TaskStatus> jobsByTask(TaskType task) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TaskStatus> stopAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TaskStatus> stopByTask(TaskType task) {
        // TODO Auto-generated method stub
        return null;
    }

}
