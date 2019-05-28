package com.rls.ids.entities;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
@Validated
@IdClass(User.CompositeKey.class)
public class User extends BaseEntity{
    @Id
    @NotNull
    @Column(name = "user_id")
    private String userId;

    private String role;

    @Column(name = "app_key")
    private String appKey;

    @Id
    @NotNull
    private String cid;

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

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    static class CompositeKey implements Serializable {
        private String cid;
        private String userId;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
