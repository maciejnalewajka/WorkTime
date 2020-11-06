package com.nalewajka.worktime.Data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Task extends RealmObject {

    @PrimaryKey
    @Required
    private String task_id;
    @Required
    private String name;
    @Required
    private String task;
    @Required
    private String time;
    @Required
    private String used_time;
    @Required
    private String task_date;
    @Required
    private String priority;
    @Required
    private String extra_info;
    @Required
    private String project_id;
    @Required
    private String user_id;

    public Task(String task_id, String name, String task, String time, String used_time, String task_date, String priority, String extra_info, String project_id, String user_id) {
        this.task_id = task_id;
        this.name = name;
        this.task = task;
        this.time = time;
        this.used_time = used_time;
        this.task_date = task_date;
        this.priority = priority;
        this.extra_info = extra_info;
        this.project_id = project_id;
        this.user_id = user_id;
    }

    public Task(){}

    public String getTask_id() {
        return task_id;
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }

    public String getTime() {
        return time;
    }

    public String getUsed_time() {
        return used_time;
    }

    public String getTask_date() {
        return task_date;
    }

    public String getPriority() {
        return priority;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public String getProject_id() {
        return project_id;
    }

    public String getUser_id() {
        return user_id;
    }
}
