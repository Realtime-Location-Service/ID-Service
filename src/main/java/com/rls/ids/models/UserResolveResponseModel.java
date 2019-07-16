package com.rls.ids.models;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.rls.ids.entities.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserResolveResponseModel {
    private String companyName;
    private int companyId;
    private String domain;
    private String userId;
    private String role;
    private List<User> subordinates;

    public UserResolveResponseModel(){}

    public UserResolveResponseModel(List<java.util.Map.Entry> adminWithCompany) {
        for (Map.Entry entry: adminWithCompany){
            if ("company_name".equals(entry.getKey())) {
                companyName = (String) entry.getValue();
            } else if ("domain".equals(entry.getKey())) {
                domain = (String) entry.getValue();
            } else if ("user_id".equals(entry.getKey())) {
                userId = (String) entry.getValue();
            } else if ("role".equals(entry.getKey())) {
                role = (String) entry.getValue();
            } else if ("company_id".equals(entry.getKey())) {
                companyId = (int) entry.getValue();
            }
        }
    }

    public UserResolveResponseModel(String userId, String role, String companyName, String domain) {
        this.userId = userId;
        this.role = role;
        this.companyName = companyName;
        this.domain = domain;
    }

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

    public List<User> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<User> subordinates) {
        this.subordinates = new LinkedList<>();
        this.subordinates.addAll(subordinates);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
