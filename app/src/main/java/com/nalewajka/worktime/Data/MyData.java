package com.nalewajka.worktime.Data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class MyData extends RealmObject {

    @Required
    private String name;
    @PrimaryKey
    @Required
    private String email;
    @Required
    private String password;

    private String phone = "";
    @Required
    private String type;
    @Required
    private String company_id;

    public MyData(String name, String email, String password, String phone, String type, String company_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.type = type;
        this.company_id = company_id;
    }

    public MyData(String name, String email, String password, String type, String company_id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.company_id = company_id;
    }

    public MyData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
