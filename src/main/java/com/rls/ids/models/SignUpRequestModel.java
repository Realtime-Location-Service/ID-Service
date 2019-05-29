package com.rls.ids.models;

import javax.validation.constraints.NotBlank;

public class SignUpRequestModel {
    @NotBlank
    private String appKey;
    @NotBlank
    private String userId;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
