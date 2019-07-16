package com.rls.ids.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Validated
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "user_id")
    private String userId;

    private String role;

    @Column(name = "app_key")
    private String appKey;

    @NotNull
    @Column(name = "company_id")
    @MapKey
    private int companyId;

    public User() {}
    public User(String userId, int cid, String role) {
        this.userId = userId;
        this.companyId = cid;
        this.role = role;
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

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int cid) {
        this.companyId = cid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
