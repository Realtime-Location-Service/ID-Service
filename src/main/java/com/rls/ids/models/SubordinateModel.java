package com.rls.ids.models;

public class SubordinateModel {
    private String userId;

    SubordinateModel(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
