package com.nalewajka.worktime.Data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Project extends RealmObject {

    @PrimaryKey
    @Required
    private String project_id;
    @Required
    private String name;
    @Required
    private String client;
    @Required
    private String platform;
    @Required
    private String api;
    @Required
    private String time;
    @Required
    private String project_date;
    @Required
    private String info;
    @Required
    private String extra_info;
    @Required
    private String user_master_id;

    public Project(String project_id, String name, String client, String platform, String api, String time, String project_date, String info, String extra_info, String user_master_id) {
        this.project_id = project_id;
        this.name = name;
        this.client = client;
        this.platform = platform;
        this.api = api;
        this.time = time;
        this.project_date = project_date;
        this.info = info;
        this.extra_info = extra_info;
        this.user_master_id = user_master_id;
    }

    public Project(){}

    public String getProject_id() {
        return project_id;
    }

    public String getName() {
        return name;
    }

    public String getClient() {
        return client;
    }

    public String getPlatform() {
        return platform;
    }

    public String getApi() {
        return api;
    }

    public String getTime() {
        return time;
    }

    public String getProject_date() {
        return project_date;
    }

    public String getInfo() {
        return info;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public String getUser_master_id() {
        return user_master_id;
    }
}
