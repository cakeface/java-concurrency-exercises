package com.ckfce.concurrent.ideal;

import java.util.Date;

/** 
 * For every job submitted we can query the current state of the job and get a TaskStatus.
 * @author rpollock
 *
 */
public class TaskStatus {

    private final String taskTypeName;
    private final TaskInitConfig taskInitConfig;
    private final TaskState taskState;
    private final long uuid;
    // TODO RYAN should I be using new java 8 time type here?
    private final Date submitTime;
    private final Date statusPollTime;

    public TaskStatus(String taskTypeName, TaskInitConfig taskInitConfig, TaskState taskState, long uuid, Date submitTime, Date statusPollTime) {
        super();
        this.taskTypeName = taskTypeName;
        this.taskInitConfig = taskInitConfig;
        this.taskState = taskState;
        this.uuid = uuid;
        this.submitTime = submitTime;
        this.statusPollTime = statusPollTime;
    }

    public String getTaskTypeName() {
        return taskTypeName;
    }

    public TaskInitConfig getTaskInitConfig() {
        return taskInitConfig;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public long getUuid() {
        return uuid;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public Date getStatusPollTime() {
        return statusPollTime;
    }

    @Override
    public String toString() {
        return "TaskStatus [taskTypeName=" + taskTypeName + ", taskInitConfig=" + taskInitConfig + ", taskState=" + taskState + ", uuid=" + uuid
                + ", submitTime=" + submitTime + ", statusPollTime=" + statusPollTime + "]";
    }


}
