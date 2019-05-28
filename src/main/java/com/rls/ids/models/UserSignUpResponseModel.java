package com.rls.ids.models;

import com.rls.ids.entities.User;

import java.util.LinkedList;
import java.util.List;

public class UserSignUpResponseModel {
    private String userId;
    private String role;
    private String appKey;
    private String companyId;
    private List<SubordinateModel> subordinates;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public List<SubordinateModel> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<User> subordinates) {
        this.subordinates = new LinkedList<>();
        subordinates.forEach((user -> this.subordinates.add(new SubordinateModel(user.getUserId()))));
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
